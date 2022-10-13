import java.io.Console;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
* clase profesor
* @param gruposVA  lista de grupos virtuales asincronicos relacionados con el profesor
* @param gruposVS lista de grupos virtuales sincronicos relacionados con el profesor
* @param gruposP lista de grupos virtuales presenciales relacionados con el profesor
* @param tutorias lista de grupos de tutorias creadas por el profesor
*/
public class Profesor extends Cuenta {
    private ArrayList<VirtualA> gruposVA;
    private ArrayList<VirtualS> gruposVS;
    private ArrayList<Presencial> gruposP;
    private ArrayList<Tutoria> tutorias;
    /**
    * 
    * @param nombre
    * @param apellido1
    * @param apellido2
    * @param telefono
    * @param telefono2
    * @param correo
    * @param usuario
    * @param contrasena
    */
    public Profesor(String nombre,String apellido1,String apellido2,String telefono,String telefono2,String correo,String usuario,String contrasena){

        super(nombre, apellido1, apellido2, telefono,telefono2, correo, usuario, contrasena);
        this.tutorias = new ArrayList<>();
        this.gruposP = new ArrayList<>();
        this.gruposVA = new ArrayList<>();
        this.gruposVS = new ArrayList<>();
    }

    public ArrayList<Presencial> getGruposP() {
        return gruposP;
    }
    public ArrayList<VirtualA> getGruposVA() {
        return gruposVA;
    }
    public ArrayList<VirtualS> getGruposVS() {
        return gruposVS;
    }
    public ArrayList<Tutoria> getTutorias() {
        return tutorias;
    }

    /**
     * Busca de la lista global de grupos presenciales con el id de un grupo especifico
     * @param id  id del grupo a buscar
     * @return null
     */
    public static Presencial buscarGrupoP(String id)
    {
        for (Presencial grup: Main.gruposP)
        {
            if (grup.getId() == id)
            {
                
                return (grup);
            }
        }
        return null;

    }

    /**
     * Busca de la lista global de grupos Virtuales asioncronicos con el id de un grupo especifico
     * @param id  id del grupo a buscar
     * @return null
     */
    public static VirtualA buscarGrupoVA(String id)
    {
        for (VirtualA grup: Main.gruposVA)
        {
            if (grup.getId() == id)
            {
                
                return (grup);
            }
        }
        return null;

    }

    /**
     * Busca de la lista global de grupos virtuales sincronicos con el id de un grupo especifico
     * @param id  id del grupo a buscar
     * @return null
     */
    public static VirtualS buscarGrupoVS(String id)
    {
        for (VirtualS grup: Main.gruposVS)
        {
            if (grup.getId() == id)
            {
                
                return (grup);
            }
        }
        return null;

    }
    
    /**
     * crea un acompañamiento y se lo asigna a un estudiante
     * @return  objeto de acompañamiento nuevo
     */
    public static Acompañamiento crearAcompañamiento(){
        Console console = System.console();
        String tipoRep =console.readLine("%s", "Escriba el tipo de reporte: ");
        int anio = Integer.parseInt((console.readLine("%s", "año: "))) ;
        int mes = Integer.parseInt((console.readLine("%s", "mes: "))) ;
        int dia = Integer.parseInt((console.readLine("%s", "dia: "))) ;
        Calendar fech = new GregorianCalendar();
        fech.set(anio,mes,dia);
        String descrip =console.readLine("%s", "Descrepcion: ");
        int carne =Integer.parseInt(console.readLine("%s","Carnet del estudiante: "));
        Estudiante est = Coordinador.buscarEstudiante(carne);           
        return new Acompañamiento(tipoRep, fech, descrip, est);
    }

    /**
     * crea una calificacion y se asgina a un estudiante especifico de un curso
     * @param est estudiante al que se le va relacionar la calificacion(buscar estudiante previamente)
     * @return retorna el objeto calificacion ya asignado, como para agregarlo en la lista de calificaciones del estudiante
     */
    public static Calificacion crearCalificacion(Estudiante est){

        Console console = System.console();
        System.out.println("En que tipo de curso se ecuentra el estudiante?");
        System.out.println("1.Presencial");
        System.out.println("2.Virtual asincronico");
        System.out.println("2.Virtual sincronico");
        String opt =console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt){
            case"1":
                String idGrupoPre =console.readLine("%s", "Ingrese el id del grupo al que pertenece el estudiante a calificar: ");
                Presencial grupoPre = Profesor.buscarGrupoP(idGrupoPre);
                float notaP = Float.parseFloat(console.readLine("%s","Ingrese la nota que quiere asignar: "));
                notaP=Math.round(notaP/5)*5;
                Calificacion nuevaCalP=new Calificacion(notaP, est);
                nuevaCalP.setGrupoP(grupoPre);
                return nuevaCalP;
            case"2":
                String idGrupoVirA =console.readLine("%s", "Ingrese el id del grupo al que pertenece el estudiante a calificar: ");
                VirtualA grupoVirA = Profesor.buscarGrupoVA(idGrupoVirA);
                float notaVA = Float.parseFloat(console.readLine("%s","Ingrese la nota que quiere asignar: "));
                notaVA=Math.round(notaVA/5)*5;
                Calificacion nuevaCalVA=new Calificacion(notaVA, est);
                nuevaCalVA.setGrupoVA(grupoVirA);
                return nuevaCalVA;
            case"3":
                String idGrupoVirS =console.readLine("%s", "Ingrese el id del grupo al que pertenece el estudiante a calificar: ");
                VirtualS grupoVirS = Profesor.buscarGrupoVS(idGrupoVirS);
                float notaVS = Float.parseFloat(console.readLine("%s","Ingrese la nota que quiere asignar: "));
                notaVS=Math.round(notaVS/5)*5;
                Calificacion nuevaCalVS=new Calificacion(notaVS, est);
                nuevaCalVS.setGrupoVS(grupoVirS);
                return nuevaCalVS;
        }
        return null;
    }

    /** 
     * crea una nueva tutoria y se agrega al profesor al que se le hace el llamado
     * 
    */
    public void CrearTutorias(){
        String nom =Main.console.readLine("%s", "Nombre de la tutoria: ");
        String horio =Main.console.readLine("%s", "Horario: ");
        this.tutorias.add(new Tutoria(nom, horio));
        
    }

    /**
     * menu para agregar un estudiante a una tutoria
     */
    public void MenuAsistenciaTutorias(){
        Console console = System.console();
        System.out.println("1.Grupos de tutorias: ");
        int contP = 0;
        if(this.tutorias.size() == 0){
            System.out.println("------------------");
        }
        else{
            while(contP < this.tutorias.size()){
                System.out.println((contP+1)+"."+ "Nombre: "+ this.tutorias.get(contP).getNombre());
                contP++;
            }
        
        }
        System.out.println((contP+1)+".volver");
        int opt =Integer.parseInt(console.readLine("%s","opcion: "));
        if(opt == (contP+1)){
            return;
        }else{
            int carnet = Integer.parseInt(console.readLine("%s","Carnet del estudiante: "));
            Estudiante est = Coordinador.buscarEstudiante(carnet);
            if (est == null){
                System.out.println("No se encontro el estudiante ");
            }
            else{
                Main.profeActual.getTutorias().get(opt).agregarAsistencia(est);
            }
            
        } 
    }

    /**
     * Crea el reporte sobre los estudiantes con condicion de RN en un curso especifico
     */
    public static  void reporteRNP(Profesor profe){//Probar
        
        Console console = System.console();
        System.out.println("En que tipo de grupo se ecuentra el estudiante?");
        System.out.println("1.Presencial");
        System.out.println("2.Virtual asincronico");
        System.out.println("2.Virtual sincronico");
        String opt =console.readLine("%s", "Seleccione alguna de las opciones: ");
        switch(opt){
            case"1":
                String idGrupoPre =console.readLine("%s", "Ingrese el id del grupo: ");
                Presencial grupoPre = profe.buscarGrupoP(idGrupoPre);
                for (Estudiante est : grupoPre.estudiantes) {
                    String nom = grupoPre.curso.nombre;
                    int cont =0;
                    for (Calificacion calificacion : est.getCalificaciones()) {
                        if(calificacion.getGrupoP().curso.nombre==nom){
                            cont++;
                        }
                    }
                    System.out.println(est.getNombre()+"RN: "+ (cont-1));
                } 
            case"2":
                String idGrupoVA =console.readLine("%s", "Ingrese el id del grupo: ");
                Presencial grupoVA = profe.buscarGrupoP(idGrupoVA);
                for (Estudiante est : grupoVA.estudiantes) {
                    String nom = grupoVA.curso.nombre;
                    int cont =0;
                    for (Calificacion calificacion : est.getCalificaciones()) {
                        if(calificacion.getGrupoVA().curso.nombre==nom){
                            cont++;
                        }
                    }
                    System.out.println(est.getNombre()+"RN: "+ (cont-1));
                }
            case"3":
                String idGrupoVS =console.readLine("%s", "Ingrese el id del grupo: ");
                Presencial grupoVS = profe.buscarGrupoP(idGrupoVS);
                for (Estudiante est : grupoVS.estudiantes) {
                    String nom = grupoVS.curso.nombre;
                    int cont =0;
                    for (Calificacion calificacion : est.getCalificaciones()) {
                        if(calificacion.getGrupoVS().curso.nombre==nom){
                            cont++;
                        }
                    }
                    System.out.println(est.getNombre()+"RN: "+ (cont-1));
                }
        }
    }
    /**
     * Lista los grupos del profesor, dependiendo del grupo lista los estudiantes quienes hicieron un levantamiento para poder estar en ese curso
     */
    public static void reporteLevRequisitosProfe(){
        System.out.println("Grupos:");
        Coordinador.ImprimirCursos(Main.profeActual.getGruposP(), Main.profeActual.getGruposVS(), Main.profeActual.getGruposVA());
        int opt =Integer.parseInt(Main.console.readLine("%s","opcion: "));
        int opt2 = opt;
        if(opt == (Coordinador.contGrupos+1)){
            return;
        }
        if(opt2 <= Main.profeActual.getGruposP().size()){
            int cont =0;
            while(cont < Main.profeActual.getGruposP().size()){  // recorre todos los grupos preseciales del profesor
                if(Coordinador.listaId.get(opt-1) == Main.profeActual.getGruposP().get(cont).id){ // si el grupo es el mismo al de la opcion dada en el imprimir, entra
                    if ( Main.profeActual.getGruposP().get(cont).curso.requisitos.size() != 0){ //si el curso del grupo tiene requisitos, entra
                        ArrayList<Estudiante> listEstudiantes = Main.profeActual.getGruposP().get(cont).estudiantes;
                        for (Estudiante est : listEstudiantes){ //recorre todos los estudiantes del grupo
                            int contT = 0;
                            while (contT < est.getTramites().size()){ // recorre los tramistes de cada estudiante buscando el que sea de tipo LevRequisitos
                                if ( est.getTramites().get(contT).getClass() == LevRequisitos.class){
                                    ITramites levReq = est.getTramites().get(contT);
                                    for(Curso requisito: Main.profeActual.getGruposP().get(cont).curso.requisitos){ // recorre los requisitos que tenga el curso del grupo
                                        if (levReq.getCurso() == requisito){ // compara si el curso levantado es alguno de los requisitos del curso del grupo 
                                            
                                            System.out.println("Curso: %s \n Justificacion: %s".format("%s", levReq.getCurso().getNombre(),levReq.getJustificacion()));
                                        }
                                    }
                                }
                                contT++;
                 
                            }
                        }
                        return;
                    }else{
                        System.out.println("Curso sin requisitos");
                        return;
                    }
                }
                cont++;
            }
            return;
        }else{
            opt2 = opt2-Main.profeActual.getGruposP().size();
        }
        if(opt2 <= Main.profeActual.getGruposVA().size()){
            int cont =0;
            while(cont < Main.profeActual.getGruposVA().size()){ // recorre todos los grupos de tipo Virtual Asincronico del profesor
                if(Coordinador.listaId.get(opt-1) == Main.profeActual.getGruposVA().get(cont).id){// si el grupo es el mismo al de la opcion dada en el imprimir, entra
                    if ( Main.profeActual.getGruposVA().get(cont).curso.requisitos.size() != 0){//si el curso del grupo tiene requisitos, entra
                        ArrayList<Estudiante> listEstudiantes = Main.profeActual.getGruposVA().get(cont).estudiantes;
                        for (Estudiante est : listEstudiantes){//recorre todos los estudiantes del grupo
                            int contT = 0;
                            while (contT < est.getTramites().size()){ // recorre todos los tramites del estudiante buscando el de tipo LevRequisitos
                                if ( est.getTramites().get(contT).getClass() == LevRequisitos.class){
                                    ITramites levReq = est.getTramites().get(contT);
                                    for(Curso requisito: Main.profeActual.getGruposVA().get(cont).curso.requisitos){ //recorre todos los requisitos del curso del grupo
                                        if (levReq.getCurso() == requisito){ // si el curso a levantar es alguno de los requisitos del grupo,entra
                                            
                                            System.out.println("Curso: %s \n Justificacion: %s".format("%s", levReq.getCurso().getNombre(),levReq.getJustificacion()));
                                        }
                                    }
                                }
                                contT++;
                 
                            }
                        }
                        return;
                    }else{
                        System.out.println("Curso sin requisitos");
                        return;
                    }
                }
                cont++;
            }
            return;
            
        }else{
            opt2 = opt2-Main.profeActual.getGruposVA().size();
        }
        if(opt2 <= Main.profeActual.getGruposVS().size()){
            int cont =0;
            while(cont < Main.profeActual.getGruposVS().size()){// recorre todos los grupos de tipo Virtual Sincronico del profesor
                if(Coordinador.listaId.get(opt-1) == Main.profeActual.getGruposVS().get(cont).id){
                    if ( Main.profeActual.getGruposVS().get(cont).curso.requisitos.size() != 0){
                        ArrayList<Estudiante> listEstudiantes = Main.profeActual.getGruposVS().get(cont).estudiantes;
                        for (Estudiante est : listEstudiantes){ //recorre los estudiantes del grupo
                            int contT = 0;
                            while (contT < est.getTramites().size()){ //recorre todos los tramites de cada estudiante
                                if ( est.getTramites().get(contT).getClass() == LevRequisitos.class){
                                    ITramites levReq = est.getTramites().get(contT);
                                    for(Curso requisito: Main.profeActual.getGruposVS().get(cont).curso.requisitos){// recorre los requisitos del curso del grupo
                                        if (levReq.getCurso() == requisito){//verifica si el requisito levantado es alguno de los requisitos del grupo
                                            
                                            System.out.println("Curso: %s \n Justificacion: %s".format("%s", levReq.getCurso().getNombre(),levReq.getJustificacion()));
                                        }
                                    }
                                }
                                contT++;
                 
                            }
                        }
                        return;
                    }else{
                        System.out.println("Curso sin requisitos");
                        return;
                    }
                }
                cont++;
            }
            return;
        }
    }
}