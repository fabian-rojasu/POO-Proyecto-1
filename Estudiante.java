import java.util.ArrayList;
import java.util.Calendar;
/**
 * Clase donde se describe los datos del estudiante TEC
 */
public class Estudiante {
    //Atributos
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int carnet;
    private Calendar fechaNacimiento;
    private byte[] edad;
    private String genero;
    private String residencia;
    
    private ArrayList<VirtualA> gruposVA ;
    private ArrayList<VirtualS> gruposVS ;
    private ArrayList<Presencial> gruposP ;
    private ArrayList<Tutoria> tutorias;
    private ArrayList<ITramites> tramites;
    private ArrayList<Calificacion> calificaciones;

    //Metodo constructor de la clase estudiante
    public Estudiante(String nombre,String apellido1,String apellido2,int carnet,Calendar fechaNacimiento,byte[] edad,String genero,String residencia){
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.carnet=carnet;
        this.fechaNacimiento=fechaNacimiento;
        this.edad=edad;
        this.genero=genero;
        this.residencia=residencia;
        gruposVA = new ArrayList<>();
        gruposVS = new ArrayList<>();
        gruposP = new ArrayList<>();
        tutorias = new ArrayList<>();
        tramites = new ArrayList<>();
        calificaciones= new ArrayList<>();

    }

    //Metodos Sets
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }
    public void ModificarFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setEdad(byte[] edad) {
        this.edad = edad;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    //Metodos Gets
    public String getNombre() {
        return nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public int getCarnet() {
        return carnet;
    }
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }
    public byte[] getEdad() {
        return edad;
    }
    public String getGenero() {
        return genero;
    }
    public String getResidencia() {
        return residencia;
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
    public ArrayList<ITramites> getTramites() {
        return tramites;
    }
    public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    // Metodos de agragar en las listas
   public void setListaGruposP(Presencial grupo) {
        this.gruposP.add(grupo);
    }
    public void setListaGruposVA(VirtualA grupo) {
        this.gruposVA.add(grupo);
    }
    public void setListaGruposVS(VirtualS grupo) {
        this.gruposVS.add(grupo);
    }
    public void setTramites(ITramites tramites) {
        this.tramites.add(tramites);
    }
    public void setTutorias(Tutoria tutoria) {
        this.tutorias.add(tutoria);
    }
    public void setCalificaciones(Calificacion calificacion) {
        this.calificaciones.add(calificacion);
    }
    
}