import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.Console;

public class Main{
    static ArrayList<Coordinador> coordinadores = new ArrayList<>();
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Profesor> profesores = new ArrayList<>();
    static ArrayList<VirtualA> gruposVA = new ArrayList<>();
    static ArrayList<VirtualS> gruposVS = new ArrayList<>();
    static ArrayList<Presencial> gruposP = new ArrayList<>();
    static ArrayList<Acompañamiento> acompañamientos = new ArrayList<>();
    static ArrayList<Curso> cursos = new ArrayList<>();
    static ArrayList<ITramites> tramites = new ArrayList<>();
    static boolean ingreso;
    static Console console = System.console();

    public static void main(String[] args) {
        cursos.add(new Curso("123", "POO", Byte.parseByte("4") , Byte.parseByte("4")));
        cursos.add(new Curso("321", "Estruct", Byte.parseByte("3") , Byte.parseByte("5")));
        cursos.add(new Curso("456", "Arqui", Byte.parseByte("2") , Byte.parseByte("6")));
        coordinadores.add(new Coordinador("Jeison", "blanco", "rojas", "8128314","", "", "admin", "admin"));
        profesores.add(new Profesor("Leo", "Viquez", "puto", "84474019", "", "", "prof", "prof"));
        estudiantes.add(new Estudiante("Geancarlo", "Oviedo", "Vargas", 2022412243,new GregorianCalendar(2002,4,24), null, "Hombre", "Ciudad Quesada"));
        gruposP.add(new Presencial( 50,"G50",profesores.get(0),"B-3", "7:00", "11:00",cursos.get(0)));
        gruposVS.add(new VirtualS(50,"G50",profesores.get(0),"teams", "7:00", "11:00",cursos.get(1)));
        gruposVA.add(new VirtualA(50,"G50",profesores.get(0),"zoom",cursos.get(2 )));
        menu();
        
    }
    
    private static boolean loginCoordinador(){
        int cont = 0;
        Ansi.limpiarPantalla();
        
        String usuario = console.readLine("%s", "username: ");
        String contrasena = console.readLine("%s", "password: ");
        while(cont < coordinadores.size()){
            if((usuario.equals(coordinadores.get(cont).usuario)  ) & (contrasena.equals(coordinadores.get(cont).contrasena))){
                return true;
            }
            cont++;
        }
        return false;
    }
    static Profesor profeActual;
    private static boolean loginProfesor(){
        int cont = 0;
        Ansi.limpiarPantalla();
        
        String usuario = console.readLine("%s", "username: ");
        String contrasena = console.readLine("%s", "password: ");
        while(cont < coordinadores.size()){
            if((usuario.equals(profesores.get(cont).usuario)  ) & (contrasena.equals(profesores.get(cont).contrasena))){
                profeActual= profesores.get(cont);
                return true;
            }
            cont++;
        }
        return false;
    }

    public static void MenuTutorias(){
        Ansi.limpiarPantalla();
        System.out.println("1.Crear Tutorias");
        System.out.println("2.Agregar Estudiante a Tutoria");
        
        String opt =console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt)
        {
            case "1":
                profeActual.CrearTutorias();
                break;
            case "2":
                profeActual.MenuAsistenciaTutorias();
        }

    }

    
    
    public static void MenuProfesor()
    {
        Ansi.limpiarPantalla();
        int carne =Integer.parseInt(console.readLine("Ingrese el carnet del estudiante que quiere calificar: ")); 
        Estudiante est =Coordinador.buscarEstudiante(carne);
        System.out.println("1.Tutorias");
        System.out.println("2.Crear acompañamiento");
        System.out.println("2.Crear Calificacion");
        
        String opt =console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt){
            case"1":
                MenuTutorias();
                break;
            case"2":
                acompañamientos.add(Profesor.crearAcompañamiento());
                break;
            case"3":
                est.setCalificaciones(Profesor.crearCalificacion(est));
                break;
        }

    }
    
    public static void MenuCoordinador(){
        Ansi.limpiarPantalla();
        System.out.println("1.Crear Coordinador");
        System.out.println("2.Crear Profesor");
        System.out.println("3.Crear estudiante");
        System.out.println("4.Crear Grupo");
        System.out.println("5.Matricular estudiante");
        System.out.println("6.Salir");
        
        String opt = console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt){

            case "1":
                CrearCoordinador();
                MenuCoordinador();
                break;
            case "2":
                Coordinador.CrearProfesor();
                MenuCoordinador();
                break;
            case "3":
                Coordinador.CrearEstudiante();
                MenuCoordinador();
                break;

            case"4":
                Coordinador.MenuGrupo();
                break;

            case"5":
                Coordinador.asociarEst();
                MenuCoordinador();
                break;
            case "6":
                menu();
                break;
            default:
                Ansi.limpiarPantalla();
                System.out.print("\u001B[31m");
                console.readLine("Usar otra opcion");
                Ansi.restablecerColor();  
                MenuCoordinador();
        }
    }



    private static void CrearCoordinador(){
        Ansi.limpiarPantalla();
        
        String nombre = console.readLine("%s", "nombre: ");
        String ap1 = console.readLine("%s", "Primer Apellido: ");
        String ap2 = console.readLine("%s", "Segundo Apellido: ");
        String tel1 = console.readLine("%s", "telefono: ");
        String tel2 = console.readLine("%s", "telefono2 (Opcional): ");
        String correo = console.readLine("%s", "correo: ");
        String usuario = console.readLine("%s", "username: ");
        String contrasena = console.readLine("%s", "password: ");
        coordinadores.add(new Coordinador(nombre, ap1, ap2, tel1,tel2, correo, usuario, contrasena));

    }


    private static void menu(){
        
        Ansi.limpiarPantalla();
        System.out.println("1.Iniciar sesion coordinador");
        System.out.println("2.Iniciar sesion profesor");
        System.out.println("3.Salir");
        
        String opt = console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt) 
        {
            case "1":
                if(coordinadores.size()==0){
                    Ansi.limpiarPantalla();
                    System.out.print("\u001B[31m");
                    console.readLine("No existen coordinadores");
                    Ansi.restablecerColor();
                    menu();
                }
                else{
                    ingreso = loginCoordinador();
                    if(ingreso == false){
                        Ansi.limpiarPantalla();
                        System.out.print("\u001B[31m");
                        console.readLine("*Coordinador no existe*");
                        Ansi.restablecerColor();
                        menu();
                    }else{
                        MenuCoordinador();
                    }
                } 
                break;
   
            case "2":
                if(profesores.size()==0){
                    Ansi.limpiarPantalla();
                    System.out.print("\u001B[31m");
                    console.readLine("No existen profesores");
                    Ansi.restablecerColor();
                    menu();
                }
                else{
                    ingreso = loginProfesor();
                    if(ingreso == false){
                        Ansi.limpiarPantalla();
                        System.out.print("\u001B[31m");
                        console.readLine("Profesor no existe"); 
                        Ansi.restablecerColor();
                        menu();
                    }else{
                        System.out.println("Profesor existe");
                        MenuProfesor();
                    }
                } 
                break;
            case "3":
                break;
            
            default:
                Ansi.limpiarPantalla();
                System.out.print("\u001B[31m");
                console.readLine("Usar otra opcion");
                Ansi.restablecerColor(); 
                menu();
        }       
    }

}
