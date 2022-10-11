import java.util.ArrayList;
import java.io.Console;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Collections;


public class Coordinador extends Cuenta {
    static ArrayList<String> listaId;
    
    //Metodo constructor de la clase coordinador 
    public Coordinador(String nombre,String apellido1,String apellido2,String telefono1,String telefono2,String correo,String usuario,String contrasena){

        super(nombre, apellido1, apellido2, telefono1, telefono2, correo, usuario, contrasena);
        
    }

    // metodos para buscar por nombre 
    public static Profesor buscarProfesor(String nom)
    {
        for (Profesor prof: Main.profesores)
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

    public static Curso buscarCurso(String cod)
    {
        for (Curso cur: Main.cursos)
        {
            if (cur.codigo == cod)
            {
                return (cur);
            }
        }
        return null;
    }

    public static Estudiante buscarEstudiante(int carnet)
    {
        for (Estudiante est: Main.estudiantes)
        {
            if (est.getCarnet() == carnet)
            {
                return (est);
            }
        }
        return null;
    }

    static int contGrupos = 0;
    public static void ImprimirCursos(ArrayList<Presencial> gruposP,ArrayList<VirtualS> gruposVS,ArrayList<VirtualA> gruposVA){
        contGrupos = 0;
        System.out.println("Grupos disponibles");
        int contP = 0;
        System.out.println("Presencial: ");
        if(gruposP.size() == 0){
            System.out.println("------------------");
        }
        else{
            while(contP < gruposP.size()){
                System.out.println((contGrupos+1)+"."+"Nombre: "+gruposP.get(contP).id + "Grupo#" + gruposP.get(contP).numGrupo);
                listaId.add(gruposP.get(contP).id);
                contGrupos++;
                contP++;
            }
        }
        contP = 0;
        System.out.println("Virtual Asincronico: ");
        if(gruposVA.size() == 0){
            System.out.println("------------------");
        }else{
            while(contP < Main.gruposVA.size()){
                System.out.println((contGrupos+1)+"."+"Nombre: "+gruposVA.get(contP).id + "Grupo#"+ gruposVA.get(contP).numGrupo);
                listaId.add(gruposVA.get(contP).id);
                contGrupos++;
                contP++;
            } 
        }
        contP = 0;
        System.out.println("Virtual Sincronico: ");
        if(gruposVS.size() == 0){
            System.out.println("------------------");
        }else{
            while(contP < gruposVS.size()){
                System.out.println((contGrupos+1)+"."+"Nombre: " + gruposVS.get(contP).id + "Grupo#"+ gruposVS.get(contP).numGrupo);
                listaId.add(gruposVS.get(contP).id);
                contGrupos++;
                contP++;
            }
        }
        System.out.println((contGrupos+1)+".volver");
    }
    // funcion para asociar un estudiante a un grupo de curso
    public static void asociarEst(){   
        listaId = new ArrayList<>();
        Ansi.limpiarPantalla();
        Console console = System.console();
        Estudiante est = buscarEstudiante(Integer.parseInt(console.readLine("%s", "Ingrese el carnet del estudiante: ")));
        ImprimirCursos(Main.gruposP, Main.gruposVS, Main.gruposVA);
        int opt =Integer.parseInt(console.readLine("%s","opcion: "));
        int opt2 = opt;
        if(opt == (contGrupos+1)){
            return;
        }
        if(opt2 <= Main.gruposP.size()){
            int cont =0;
            while(cont < Main.gruposP.size()){
                if(listaId.get(opt-1) == Main.gruposP.get(cont).id){
                    Main.gruposP.get(cont).AgregarEstudiantes(est);
                    est.setListaGruposP(Main.gruposP.get(cont));
                }
                cont++;
            }
            return;
        }else{
            opt2 = opt2-Main.gruposP.size();
        }
        if(opt2 <= Main.gruposVA.size()){
            int cont =0;
            while(cont < Main.gruposVA.size()){
                if(listaId.get(opt-1) == Main.gruposVA.get(cont).id){
                    Main.gruposVA.get(cont).AgregarEstudiantes(est);
                    est.setListaGruposVA(Main.gruposVA.get(cont));
                }
                cont++;
            }
            return;
            
        }else{
            opt2 = opt2-Main.gruposVA.size();
        }
        if(opt2 <= Main.gruposVS.size()){
            int cont =0;
            while(cont < Main.gruposVS.size()){
                if(listaId.get(opt-1) == Main.gruposVS.get(cont).id){
                    Main.gruposVS.get(cont).AgregarEstudiantes(est);
                    est.setListaGruposVS(Main.gruposVS.get(cont));
                }
                cont++;
            }
            return;
        }
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
        String opt = console.readLine("%s", "Seleccione alguna de las opciones: ");
        int cont = 0;
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
                Byte creditos=Byte.parseByte(console.readLine("%s","Creditos nuevos"));
                curso.creditos=creditos;
                break;
            case "4":
                byte cantidadHoras=Byte.parseByte(console.readLine("%s","Creditos nuevos"));
                curso.cantidadHoras=cantidadHoras;
                break;
            case "5":
                cont = 0;
                if(Main.cursos.size()!=0){
                    while(cont < Main.cursos.size()){
                        System.out.println((cont+1)+"."+Main.cursos.get(cont).nombre);
                        cont++;
                    }
                    int seleccionR = Integer.parseInt(console.readLine("%s", "Seleccione el curso para los requisitos: "))-1;
                    curso.setRequisitos(Main.cursos.get(seleccionR));
                }else{
                    System.out.println("No hay Cursos para agregar de requisitos ni correquisitos");
                }
                
                break;
            case "6":
                cont = 0;
                if(Main.cursos.size()!=0){
                    while(cont < Main.cursos.size()){
                        System.out.println((cont+1)+"."+Main.cursos.get(cont).nombre);
                        cont++;
                    }
                    int seleccionC = Integer.parseInt(console.readLine("%s", "Seleccione el curso para los correquisitos: "))-1;
                    curso.setCorrequisitos(Main.cursos.get(seleccionC));
                }else{
                    System.out.println("No hay Cursos para agregar de requisitos ni correquisitos");
                }
                
                break;
            default:
                Ansi.limpiarPantalla();
                System.out.print("\u001B[31m");
                console.readLine("Usar otra opcion");
                Ansi.restablecerColor();  
                
        }
    }


    //Metodos Crear
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
            Main.profesores.add(new Profesor(nombre, ap1, ap2, tel1,tel2, correo, usuario, contrasena));
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
        Main.estudiantes.add(new Estudiante(nombre, apellido1, apellido2, carnet, fechaNacimiento, edad, genero, residencia));
    }

    public static void MenuGrupo(){
        Ansi.limpiarPantalla();
        Console console = System.console();
        System.out.println("Seleccione la modalidad del grupo");
        System.out.println("1.Presencial");
        System.out.println("2.Virtual Asincronico");
        System.out.println("3.Virtual Sincronico");
        System.out.println("4.Volver");
        String opt = console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt){
            case "1":
                CrearGrupoPresencial();
                Main.MenuCoordinador();
                break;
            case "2":
                CrearGrupoVirtualA();
                Main.MenuCoordinador();
                break;
            case "3":
                CrearGrupoVirtualS();
                Main.MenuCoordinador();
                break;
            case "4":
                Main.MenuCoordinador();
                break;
            default:
                System.out.println("Opcion incorreceta");
        }
    }

    public static void CrearGrupoVirtualA(){
        Ansi.limpiarPantalla();
        Console console = System.console();
        String id = console.readLine("%s", "id: ");
        int numGrupo = Integer.parseInt((console.readLine("%s", "Numero de grupo: ")));
        String medio = console.readLine("%s", "Medio: ");
        Ansi.limpiarPantalla();
        System.out.println("Lista Profesores");
        int cont = 0;
        while(cont < Main.profesores.size()){
            System.out.println((cont+1)+"."+Main.profesores.get(cont).nombre);
            cont++;
        }
        int seleccion = Integer.parseInt(console.readLine("%s", "Seleccione el profesor del grupo: "))-1;
        cont = 0;
        while(cont < Main.cursos.size()){
            System.out.println((cont+1)+"."+Main.cursos.get(cont).nombre);
            cont++;
        }
        int seleccionC = Integer.parseInt(console.readLine("%s", "Seleccione el curso del grupo: "))-1;
        Main.gruposVA.add(new VirtualA(numGrupo, id, Main.profesores.get(seleccion), medio,Main.cursos.get(seleccionC)));
    }


    public static void CrearGrupoVirtualS(){
        Ansi.limpiarPantalla();
        Console console = System.console();
        int numGrupo = Integer.parseInt((console.readLine("%s", "Numero de grupo: ")));
        String id = console.readLine("%s", "id: ");
        String medio = console.readLine("%s", "Medio: ");
        String horaInicio = console.readLine("%s", "Hora de inicio: ");
        String horaFinal = console.readLine("%s", "Hora de final: ");
        Ansi.limpiarPantalla();
        System.out.println("Lista Profesores");
        int cont = 0;
                while(cont < Main.profesores.size()){
                    System.out.println((cont+1)+"."+Main.profesores.get(cont).nombre);
                    cont++;
                }
        int seleccion = Integer.parseInt(console.readLine("%s", "Seleccione el profesor del grupo: "))-1;
        cont = 0;
        while(cont < Main.cursos.size()){
            System.out.println((cont+1)+"."+Main.cursos.get(cont).nombre);
            cont++;
        }
        int seleccionC = Integer.parseInt(console.readLine("%s", "Seleccione el curso del grupo: "))-1;
        Main.gruposVS.add(new VirtualS(numGrupo, id, Main.profesores.get(seleccion), medio, horaInicio, horaFinal,Main.cursos.get(seleccionC)));  
    }
    
    public static void CrearGrupoPresencial(){
        Ansi.limpiarPantalla();
        Console console = System.console();
        int numGrupo = Integer.parseInt((console.readLine("%s", "Numero de grupo: ")));
        String id = console.readLine("%s", "id: ");
        String aula = console.readLine("%s", "Aula: ");
        String horaInicio = console.readLine("%s", "Hora de inicio: ");
        String horaFinal = console.readLine("%s", "Hora de final: ");
        Ansi.limpiarPantalla();
        System.out.println("Lista Profesores");
        int cont = 0;
                while(cont < Main.profesores.size()){
                    System.out.println((cont+1)+"."+Main.profesores.get(cont).nombre);
                    cont++;
                }
        int seleccion = Integer.parseInt(console.readLine("%s", "Seleccione el profesor del grupo: "))-1;
        cont = 0;
        while(cont < Main.cursos.size()){
            System.out.println((cont+1)+"."+Main.cursos.get(cont).nombre);
            cont++;
        }
        int seleccionC = Integer.parseInt(console.readLine("%s", "Seleccione el curso del grupo: "))-1;
        Main.gruposP.add(new Presencial(numGrupo,id, Main.profesores.get(seleccion), aula, horaInicio, horaFinal,Main.cursos.get(seleccionC)));
    }
    
    public static void crearCurso(){
        Ansi.limpiarPantalla();
        Console console = System.console();
        String nombre = console.readLine("%s", "Nombre: ");
        byte creditos = Byte.parseByte(console.readLine("%s", "Creditos: "));
        String codigo = console.readLine("%s", "Codigo: ");
        byte cantidadHoras = Byte.parseByte(console.readLine("%s", "Horas: "));
        Curso nuevoCurso =new Curso(codigo, nombre, creditos, cantidadHoras);
        Main.cursos.add(nuevoCurso);
        int cont = 0;
        if(Main.cursos.size()!=0){
            while(cont < Main.cursos.size()){
                System.out.println((cont+1)+"."+Main.cursos.get(cont).nombre);
                cont++;
            }
            int seleccionR = Integer.parseInt(console.readLine("%s", "Seleccione el curso para los requisitos: "))-1;
            int seleccionC = Integer.parseInt(console.readLine("%s", "Seleccione el curso para los correquisitos: "))-1;
            nuevoCurso.setRequisitos(Main.cursos.get(seleccionR));
            nuevoCurso.setCorrequisitos(Main.cursos.get(seleccionC));
        }else{
            System.out.println("No hay Cursos para agregar de requisitos ni correquisitos");
        }
    }

    public static void Historial_academico(){
        
        Ansi.limpiarPantalla();
        Console console = System.console();
        int carnet =  Integer.parseInt(console.readLine("Ingrese el carnet del estudiante que desea ver: ")) ;
        Estudiante est = buscarEstudiante(carnet);
        ArrayList<Calificacion> cal = est.getCalificaciones();
        int cont = 0;
        int valor = (int) 100/cal.size(); 
        double ponderado = 0;
        while(cont < cal.size()){
            if(cont == cal.size()){
                if(cal.get(cont).getGrupoP() != null){
                     System.out.println("Curso: "+cal.get(cont).getGrupoP().getCursos().getNombre()+" Nota: "+cal.get(cont).getNota());
                }else if(cal.get(cont).getGrupoVA() != null){
                    System.out.println("Curso: "+cal.get(cont).getGrupoVA().getCursos().getNombre()+" Nota: "+cal.get(cont).getNota());
                }else{
                    System.out.println("Curso: "+cal.get(cont).getGrupoVS().getCursos().getNombre()+" Nota: "+cal.get(cont).getNota()); 
                }
            }else{
               if(cal.get(cont).getGrupoP() != null){
                     System.out.println("Curso: "+cal.get(cont).getGrupoP().getCursos().getNombre()+" Nota: "+cal.get(cont).getNota()+", ");
                }else if(cal.get(cont).getGrupoVA() != null){
                    System.out.println("Curso: "+cal.get(cont).getGrupoVA().getCursos().getNombre()+" Nota: "+cal.get(cont).getNota()+", ");
                }else{
                    System.out.println("Curso: "+cal.get(cont).getGrupoVS().getCursos().getNombre()+" Nota: "+cal.get(cont).getNota()+", "); 
                }  
            }
            if(cal.get(cont).getNota() == 100){
                ponderado += valor*1;
            }
            else if(cal.get(cont).getNota() < 100){
                if(cal.get(cont).getNota() < 10){
                    ponderado += valor*(cal.get(cont).getNota()*0.1);
                }else{
                    ponderado += valor*(cal.get(cont).getNota()*0.01);
                }
            }
            cont++;
        }
        System.out.println("Ponderado: "+ponderado);
    }


    public static void reporteRN(Estudiante est){//Probar
        ArrayList<Calificacion> calificaciones= est.getCalificaciones();
        for (Calificacion calificacion : calificaciones) {
            if (calificacion.getGrupoP()!=null){
                String nom =calificacion.getGrupoP().getCursos().nombre;
                int cont =0;
                for (Calificacion calificacion2 : calificaciones) { 
                    if(calificacion2.getGrupoP().getCursos().nombre==nom){
                        cont++;
                    }
                }
                System.out.println("En el curso %s tiene un estado de RN: %".format("%s", nom, cont-1));
            }
            if (calificacion.getGrupoVA()!=null){
                String nom =calificacion.getGrupoVA().getCursos().nombre;
                int cont =0;
                for (Calificacion calificacion2 : calificaciones) { 
                    if(calificacion2.getGrupoVA().getCursos().nombre==nom){
                        cont++;
                    }
                }
                System.out.println("En el curso %s tiene un estado de RN: %".format("%s", nom, cont-1));
            }

            if(calificacion.getGrupoVS()!=null){
                String nom =calificacion.getGrupoVS().getCursos().nombre;
                int cont =0;
                for (Calificacion calificacion2 : calificaciones) { 
                    if(calificacion2.getGrupoVS().getCursos().nombre==nom){
                        cont++;
                    }
                }
                System.out.println("En el curso %s tiene un estado de RN: %".format("%s", nom, cont-1));
            }

        }
        
    }
    

    public static void crearTramites(){
        Ansi.limpiarPantalla();
        Console console = System.console();
        System.out.println("Que tramite decea registrar");
        System.out.println("1.Levantamiento de requisitos");
        System.out.println("2.Levantamiento RN");
        System.out.println("3.Salicitud de beca");
        int opt = Integer.parseInt(console.readLine("Selecione alguna opcion: ")) ;
        switch(opt){
            case 1:
                int ced =Integer.parseInt(console.readLine("Digite la carnet del estudiante del tramite: "));
                Estudiante est =Coordinador.buscarEstudiante(ced);
                String descrip = console.readLine("Escriba la descripcion del elevatamientode requisitos: ");
                int anio = Integer.parseInt(console.readLine("Escriba el año: "));
                int mes = Integer.parseInt(console.readLine("Escriba el mes: "));
                int dia = Integer.parseInt(console.readLine("Escriba el dia: "));
                String justEst = console.readLine("Escriba la justificacion del estudiante del por que levantar requisitos: ");
                String cod =console.readLine("Digite la carnet del estudiante del tramite: ");
                Curso cur =Coordinador.buscarCurso(cod);
                Boolean estado;
                String esta = console.readLine("Aprobar tramite? s/n: ");
                if((esta == "s")||(esta == "S")){
                    estado =true;
                }else{
                    estado = false;
                }
                Main.tramites.add(new LevRequisitos(justEst, estado, cur, new GregorianCalendar(anio,mes,dia), descrip, est));
            case 2:
                
                int ced2 =Integer.parseInt(console.readLine("Digite la carnet del estudiante del tramite: "));
                Estudiante est2 =Coordinador.buscarEstudiante(ced2);
                String descrip2 = console.readLine("Escriba la descripcion del elevatamientode requisitos: ");
                int anio2 = Integer.parseInt(console.readLine("Escriba el año: "));
                int mes2 = Integer.parseInt(console.readLine("Escriba el mes: "));
                int dia2 = Integer.parseInt(console.readLine("Escriba el dia: "));

                /*String justEst = console.readLine("Escriba la justificacion del estudiante del por que levantar requisitos: ");
                String cod =console.readLine("Digite la carnet del estudiante del tramite: ");
                Curso cur =Coordinador.buscarCurso(cod);
                Boolean estado;
                String esta = console.readLine("Aprobar tramite? s/n: ");
                if((esta == "s")||(esta == "S")){
                    estado =true;
                }else{
                    estado = false;
                }*/
                //Main.tramites.add(new LevRequisitos(justEst, estado, cur, new GregorianCalendar(anio2,mes2,dia2), descrip2, est2));
        }

    }
}
