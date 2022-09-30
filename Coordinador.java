import java.util.ArrayList;
import java.io.Console;
import java.util.GregorianCalendar;
import java.util.Calendar;


public class Coordinador extends Cuenta {
    static ArrayList<Estudiante> estudiantes;
    static ArrayList<VirtualA> gruposVA;
    static ArrayList<VirtualS> gruposVS;
    static ArrayList<Presencial> gruposP;
    static ArrayList<Profesor> profesores;
    

    public Coordinador(String nombre,String apellido1,String apellido2,String telefono1,String telefono2,String correo,String usuario,String contrasena){

        super(nombre, apellido1, apellido2, telefono1, telefono2, correo, usuario, contrasena);
        estudiantes = new ArrayList<>();
        gruposVA = new ArrayList<>();
        gruposVS = new ArrayList<>();
        gruposP = new ArrayList<>();
        profesores = new ArrayList<>();
        
    }

    //Metodos Gets
    public static ArrayList<Presencial> getGruposP() {
        return gruposP;
    }

    public static ArrayList<VirtualA> getGruposVA() {
        return gruposVA;
    }

    public static ArrayList<VirtualS> getGruposVS() {
        return gruposVS;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }
    

    //Metodos Agregar
    public void agregarProfesores(Profesor profesor) {
        profesores.add(profesor);
    }
    public void agregarGrupos(VirtualA grupo) {
        gruposVA.add(grupo);
    }

    public void agregarGrupos(VirtualS grupo) {
        gruposVS.add(grupo);
    }
    public void agregarGrupos(Presencial grupo) {
        gruposP.add(grupo);
    }

    public void agregarEstudiantes(Estudiante est) {
        estudiantes.add(est);
    }
    public void asociarEst()
    {
        Console console = System.console();
        String est = console.readLine("%s", "Ingrese el nombre del estudiante: ");
        String curso = console.readLine("%s", "Ingrese el nombre del curso: ");
        System.out.println("Grupos disponibles");
        for ( Grupo grup : grupos)
        {
            
        }
    }

    // metodos para buscar por nombre 
    public static Profesor buscarProfesor(String nom)
    {
        for (Profesor prof: profesores)
        {
            if (prof.nombre == nom)
            {
                return (prof);
            }
        }
        return null;

    }
    public static Coordinador buscarCoordinador(String nom)
    {
        for (Coordinador coordi: Main.coordinadores)
        {
            if (coordi.nombre == nom)
            {
                return (coordi);
            }
        }
        return null;

    }
    public static Estudiante buscareEstudiante(String nom)
    {
        for (Estudiante est: estudiantes)
        {
            if (est.getNombre() == nom)
            {
                return (est);
            }
        }
        return null;

    }
    
    //Metodos Modificar
    public void modificarCurso(Curso curso) {
        Console console = System.console();
        System.out.println("1.Codigo");
        System.out.println("2.Nombre");
        System.out.println("3.Creditos");
        System.out.println("4.Cantidad Horas");
        System.out.println("5.Requisitos");
        System.out.println("6.Correqusitos");
        System.out.println("7.Calificacion");
        System.out.println("8.RN");
        String opt = console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt){

            case "1":
                String codigo=console.readLine("%s","Codigo nuevo");
                curso.codigo=codigo;
                break;
            case "2":
                String nombre=console.readLine("%s","Nombre nuevo");
                curso.nombre=nombre;
                break;
            case "3":
                String cred=console.readLine("%s","Creditos nuevos");
                byte[] creditos = cred.getBytes();
                curso.creditos=creditos;
                break;
            case "4":
                String ch=console.readLine("%s","Creditos nuevos");
                byte[] cantidadHoras = ch.getBytes();
                curso.cantidadHoras=cantidadHoras;
                break;
            case "5":
                curso.setRequisitos(curso);
                
                break;
            case "6":
                
                break;
            case "7":
                
                break;
            default:
                Ansi.limpiarPantalla();
                System.out.print("\u001B[31m");
                console.readLine("Usar otra opcion");
                Ansi.restablecerColor();  
                
        }
        String nombre = console.readLine("%s", "username: ");
        curso.nombre =nombre;
    }

    public static void CrearProfesor(){
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
            profesores.add(new Profesor(nombre, ap1, ap2, tel1,tel2, correo, usuario, contrasena));
        }

    public static void CrearEstudiante(){
        Ansi.limpiarPantalla();
        Console console = System.console();
        String nombre = console.readLine("%s", "nombre: ");
        String apellido1 = console.readLine("%s", "Primer Apellido: ");
        String apellido2 = console.readLine("%s", "Segundo Apellido: ");
        int carnet = Integer.parseInt((console.readLine("%s", "carnet: "))) ;
        int anio = Integer.parseInt((console.readLine("%s", "año: "))) ;
        int mes = Integer.parseInt((console.readLine("%s", "mes: "))) ;
        int dia = Integer.parseInt((console.readLine("%s", "dia: "))) ;
        Calendar fechaNacimiento = new GregorianCalendar();
        fechaNacimiento.set(anio,mes,dia);
        String ed=  console.readLine("%s", "edad: ");
        byte[] edad = ed.getBytes();
        String genero = console.readLine("%s", "genero: ");
        String residencia = console.readLine("%s", "residencia: ");
        estudiantes.add(new Estudiante(nombre, apellido1, apellido2, carnet, fechaNacimiento, edad, genero, residencia));
    }

    public static void MenuGrupo(){
        Console console = System.console();
         System.out.println("Seleccione la modalidad del grupo");
        System.out.println("1.Presencial");
        System.out.println("2.Virtual Asincronico");
        System.out.println("3.Virtual Sincronico");
        System.out.println("4.Volver");
        String opt = console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt){
            case "1":
                CrearGrupo();
                String aula = console.readLine("%s", "Aula: "); 
                String horaInicio = console.readLine("%s", "Hora de inicio: "); 
                String horaFinal = console.readLine("%s", "Hora de final: ");
                gruposP.add(new Presencial(nombre,aula));
            case "2":
                CrearGrupo();
                String medio = console.readLine("%s", "Plataforma: "); 
            
            case "3":
                CrearGrupo();
                String medio = console.readLine("%s", "Plataforma: "); 
                String horaInicio = console.readLine("%s", "Hora de inicio: "); 
                String horaFinal = console.readLine("%s", "Hora de final: ");
                
            case "4":
                Main.MenuCoordinador();
        }
    }

    public static void CrearGrupo()
    {
        Ansi.limpiarPantalla();
        Console console = System.console();
        String nombre = console.readLine("%s", "Nombre: ");
        String cred = console.readLine("%s", "Creditos: ");
        byte[] creditos = cred.getBytes();
        String codigo = console.readLine("%s", "Codigo: ");
        String cantH = console.readLine("%s", "Horas: ");
        byte[] cantidadHoras = cantH.getBytes();
        int numGrupo = Integer.parseInt((console.readLine("%s", "Numero de grupo: ")));
        Profesor profe = buscarProfesor(console.readLine("%s", "Nombre del profesor: "));
        // Curso requisitos = console.readLine("%s", "requisitos: ");
        // Curso correquisitos = console.readLine("%s", "correquisitos: ");
        

    }
    
    
}
