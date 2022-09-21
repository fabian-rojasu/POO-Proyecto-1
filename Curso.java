import java.util.ArrayList;
/**
 * Clase donde se describe los datos del Curso impartido en el TEC
 * @author Fabian Rojas, Geancarlo Oviedo, Jeison Blanco
 */
public class Curso {
    private String codigo;
    private String nombre;
    private byte creditos;
    private byte cantidadHoras;
    private ArrayList<Curso> requisitos;
    private ArrayList<Curso> correquisitos;
    private float calificacion;
    private String RN;

    //Metodo constructor de la clase curso
    public Curso(String codigo,String nombre,byte creditos,byte cantidadHoras, float calificacion, String RN){
        this.codigo=codigo;
        this.nombre=nombre;
        this.creditos=creditos;
        this.cantidadHoras=cantidadHoras;
        this.requisitos=new ArrayList<Curso>();
        this.correquisitos=new ArrayList<Curso>();
        this.calificacion=calificacion;
        this.RN=RN;
    }

    //Metodos Sets
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }
    public void setCantidadHoras(byte cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }
    public void setRequisitos (Curso curso){
        requisitos.add(curso);
    }
    public void setCorrequisitos (Curso curso){
        correquisitos.add(curso);
    }
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    public void setRN(String rN) {
        RN = rN;
    }

    //Metodos Gets
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public byte getCreditos() {
        return creditos;
    }
    public byte getCantidadHoras() {
        return cantidadHoras;
    }
    public ArrayList<Curso> getRequisitos() {
        return requisitos;
    }
    public ArrayList<Curso> getCorrequisitos() {
        return correquisitos;
    }
    public float getCalificacion() {
        return calificacion;
    }
    public String getRN() {
        return RN;
    }
}
