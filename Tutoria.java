import java.util.ArrayList;

public class Tutoria {
    private String nombre;
    private String horario;
    private ArrayList<Estudiante> asistencia;

    public Tutoria(String nombre,String horario){
        this.nombre = nombre;
        this.horario = horario;
        this.asistencia = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Estudiante> getAsistencia() {
        return this.asistencia;
    }
    public String getHorario() {
        return horario;
    }
    public void agregarAsistencia(Estudiante est) {
        asistencia.add(est);
    }
}
