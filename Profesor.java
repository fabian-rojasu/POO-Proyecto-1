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
            if (grup.getCodigo() == id)
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
            if (grup.getCodigo() == id)
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
            if (grup.getCodigo() == id)
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

    public static Calificacion crearCalificacion(){
        
        float nota = Float.parseFloat(console.readLine("%s","Ingrese"))
        
        return ;
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
    


}