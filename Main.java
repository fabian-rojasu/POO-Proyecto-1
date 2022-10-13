import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.Console;
/**
 * @author Fabian Rojas Ugalde, Jeison Blanco Rojas, Geancarlo Oviedo Vargas
 * Sistema administrativo para Coordinadores y profesores
 * Archivo Principal del Sistema
 */

public class Main{
    //Apartado de declaraciones globales
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

    //Inicio de sistema
    public static void main(String[] args) {
        //Apartado de la creacion de instancias 
        //Cursos:
        cursos.add(new Curso("123", "POO", Byte.parseByte("4") , Byte.parseByte("4")));
        cursos.add(new Curso("321", "Estruct", Byte.parseByte("3") , Byte.parseByte("5")));
        cursos.add(new Curso("456", "Arqui", Byte.parseByte("2") , Byte.parseByte("6")));
        //Coordinadores:
        coordinadores.add(new Coordinador("Jeison", "blanco", "rojas", "8128314","", "", "admin", "admin"));
        //Profesores:
        profesores.add(new Profesor("Leo", "Viquez", "puto", "84474019", "", "", "prof", "prof"));
        //Estudiantes:
        estudiantes.add(new Estudiante("Geancarlo", "Oviedo", "Vargas", 2022412243,new GregorianCalendar(2002,4,24), null, "Hombre", "Ciudad Quesada"));
        //Grupos:
        gruposP.add(new Presencial( 50,"G50",profesores.get(0),"B-3", "7:00", "11:00",cursos.get(0)));
        gruposVS.add(new VirtualS(50,"G50",profesores.get(0),"teams", "7:00", "11:00",cursos.get(1)));
        gruposVA.add(new VirtualA(50,"G50",profesores.get(0),"zoom",cursos.get(2 )));
        //Menu con todas las opciones principales del sistema
        menu();
        
    }
    /**
     * Metodo donde el usuario Coordinador podra ingresar al sistema
     * @return boolean
     */ 
    private static boolean loginCoordinador(){
        int cont = 0;
        Ansi.limpiarPantalla();//Metodo para limpiar la terminal 
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
    /**
     * Metodo donde el usuario Profesor podra ingresar al sistema
     * @return boolean
     */ 
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
    /**
     *Menu donde se podran acceder a todas las funciones con las que cuenta un profesor 
     *acciones como: Crear acompañamiento, crear calificaciones
     */
    public static void MenuProfesor()
    {
        Ansi.limpiarPantalla();
        int carne =Integer.parseInt(console.readLine("Ingrese el carnet del estudiante que quiere calificar: ")); 
        Estudiante est =Coordinador.buscarEstudiante(carne);
        System.out.println("1.Tutorias");
        System.out.println("2.Crear acompañamiento");
        System.out.println("3.Crear Calificacion");
        
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
            default:
                Ansi.limpiarPantalla();
                System.out.print("\u001B[31m");
                console.readLine("Usar otra opcion");
                Ansi.restablecerColor();
                MenuProfesor();
        }

    }
    /**
     *Menu donde se podran acceder a todas las funciones con las que cuenta un coordinador 
     *acciones como: Crear otro coordinador, crear profesor, crear estudiantes, crear grupos, crear cursos y matricular estudiantes en algun grupo 
     */
    public static void MenuCoordinador(){
        Ansi.limpiarPantalla();
        System.out.println("1.Crear estudiante");
        System.out.println("2.Crear Grupo");
        System.out.println("3.Matricular estudiante");
        System.out.println("4.Crear Curso");
        System.out.println("5.Historial academico estudiante");
        System.out.println("6.Salir");
        
        String opt = console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt){

            case "1":
                Coordinador.CrearEstudiante();
                MenuCoordinador();
                break;

            case"2":
                Coordinador.MenuGrupo();
                break;

            case"3":
                Coordinador.asociarEst();
                MenuCoordinador();
                break;
            case "4":
                Coordinador.crearCurso();
                MenuCoordinador();
                break;
            case "5":
                Coordinador.Historial_academico();
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


    /**
     * Metodo donde se crea el coordinador con todos sus atributos y lo agrega a la lista global de coordinadores
     */
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

    /**
     * Menu principal del sistema
     * Cuenta con las siguientes opciones:Iniciar sesion con profesor y coordinador y registrarse con cualquiera de los dos usuarios
     */
    private static void menu(){
        Ansi.limpiarPantalla();//metodo de limpiar la terminal
        System.out.println("1.Iniciar sesion coordinador");
        System.out.println("2.Iniciar sesion profesor");
        System.out.println("3.Registrar coordinador");
        System.out.println("4.Registrar profesor");
        System.out.println("5.Salir");
        
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
                CrearCoordinador();
                menu();
                break;
            case "4":
                Coordinador.CrearProfesor();
                menu();
                break;//Se llama a la clase Coordinador que posee el metodo para crear profesores
            case "5":
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
