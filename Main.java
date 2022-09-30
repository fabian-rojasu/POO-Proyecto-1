import java.util.ArrayList;
import java.io.Console;

public class Main{
    static ArrayList<Coordinador> coordinadores = new ArrayList<>();
    static ArrayList<Grupo> grupos = new ArrayList<>();

    static ArrayList<Tutoria> tutorias = new ArrayList<>();
    static boolean ingreso;
    public static void main(String[] args) {
        coordinadores.add(new Coordinador("Jeison", "blanco", "rojas", "8128314","", "", "admin", "admin"));
        menu();
    }
    
    private static boolean loginCoordinador(){
        int cont = 0;
        Ansi.limpiarPantalla();
        Console console = System.console();
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

    private static boolean loginProfesor(){
        int cont = 0;
        Ansi.limpiarPantalla();
        Console console = System.console();
        String usuario = console.readLine("%s", "username: ");
        String contrasena = console.readLine("%s", "password: ");
        while(cont < coordinadores.size()){
            if((usuario.equals(Coordinador.profesores.get(cont).usuario)  ) & (contrasena.equals(Coordinador.profesores.get(cont).contrasena))){
                return true;
            }
            cont++;
        }
        return false;
    }


   /* private static void CrearGrupo(){
       Ansi.limpiarPantalla();

    }*/

    private static void MenuCoordinador(){
        Ansi.limpiarPantalla();
        System.out.println("1.Crear Coordinador");
        System.out.println("2.Crear Profesor");
        System.out.println("3.Crear Grupo");
        System.out.println("4.Crear estudiante");
        System.out.println("4.Modificar estudiante");
        System.out.println("5.Salir");
        Console console = System.console();
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
            case "5":
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
        Console console = System.console();
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
        Console console = System.console();
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
                if(Coordinador.profesores.size()==0){
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
                        menu();
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
