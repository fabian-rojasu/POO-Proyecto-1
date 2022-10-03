
import java.util.ArrayList;

/**
 * Clase donde se describe los datos del Curso impartido en el TEC
 * @author Fabian Rojas, Geancarlo Oviedo, Jeison Blanco
 */
public abstract class Curso {
    protected String codigo;
    protected String nombre;
    protected byte[] creditos;
    protected byte[] cantidadHoras;
    protected ArrayList<Curso> requisitos;
    protected ArrayList<Curso> correquisitos;
  

    //Metodo constructor de la clase curso
    public Curso(String codigo,String nombre,byte[] creditos,byte[] cantidadHoras){
        this.codigo=codigo;
        this.nombre=nombre;
        this.creditos=creditos;
        this.cantidadHoras=cantidadHoras;
        this.requisitos=new ArrayList<Curso>();
        this.correquisitos=new ArrayList<Curso>();
    }
    //Metodos Sets
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCreditos(byte[] creditos) {
        this.creditos = creditos;
    }
    public void setCantidadHoras(byte[] cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }
    public void setRequisitos (Curso curso){
        requisitos.add(curso);
    }
    public void setCorrequisitos (Curso curso){
        correquisitos.add(curso);
    }
    

    //Metodos Gets
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public byte[] getCreditos() {
        return creditos;
    }
    public byte[] getCantidadHoras() {
        return cantidadHoras;
    }
    public ArrayList<Curso> getRequisitos() {
        return requisitos;
    }
    public ArrayList<Curso> getCorrequisitos() {
        return correquisitos;
    }
    

}


