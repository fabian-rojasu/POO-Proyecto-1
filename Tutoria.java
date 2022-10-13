import java.util.ArrayList;
/**
 * Clase tutoria con sus atributos y metodos
 */
public class Tutoria {
    private String nombre;
    private String horario;
    private ArrayList<Estudiante> asistencia;

    //Metodo constructor de la clase
    public Tutoria(String nombre,String horario){
        this.nombre = nombre;
        this.horario = horario;
        this.asistencia = new ArrayList<>();
    }

    //Metodos Gets
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Estudiante> getAsistencia() {
        return this.asistencia;
    }
    public String getHorario() {
        return horario;
    }

    //Metodo donde agrega a una lista de estudiantes los que asistieron a dicha instancia de tutoria
    public void agregarAsistencia(Estudiante est) {
        asistencia.add(est);
    }
}
