import java.util.ArrayList;

public class Profesor extends Cuenta {
    private ArrayList<Grupo> grupos;
    private ArrayList<Acompañamiento> acompañamientos;

    public Profesor(String nombre,String apellido1,String apellido2,String telefono,String telefono2,String correo,String usuario,String contrasena){

        super(nombre, apellido1, apellido2, telefono,telefono2, correo, usuario, contrasena);
        this.acompañamientos = new ArrayList<>();
    }

    public ArrayList<Grupo> getGrupos() {
        return this.grupos;
    }

    // public void agregarAsistencia(Estudiante est, Tutoria lista) {
    //     lista.getAsistencia.add(est);
    // }
    // public void registrarTutoria()
    // {

    // }
    
}