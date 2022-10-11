import java.io.Console;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Profesor extends Cuenta {
    private ArrayList<VirtualA> gruposVA;
    private ArrayList<VirtualS> gruposVS;
    private ArrayList<Presencial> gruposP;
    private ArrayList<Tutoria> tutorias;

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


    public void CrearTutorias(){
        String nom =Main.console.readLine("%s", "Nombre de la tutoria: ");
        String horio =Main.console.readLine("%s", "Horario: ");
        this.tutorias.add(new Tutoria(nom, horio));
        
    }


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
    // public void agregarAsistencia(Estudiante est, Tutoria lista) {
    //     lista.getAsistencia.add(est);
    // }
    // public void registrarTutoria()
    // {

    // }

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
}