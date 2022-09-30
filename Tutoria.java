import java.util.ArrayList;

public class Tutoria {
    private String horario;
    private ArrayList<Estudiante> asistencia;

    public Tutoria(String horario){
        this.horario=horario;
        this.asistencia = new ArrayList<>();
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
