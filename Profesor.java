import java.util.ArrayList;

public class Profesor extends Cuenta {
    private ArrayList<Grupo> gruposVA;
    private ArrayList<Grupo> gruposVS;
    private ArrayList<Grupo> gruposP;
    private ArrayList<Acompañamiento> acompañamientos;

    public Profesor(String nombre,String apellido1,String apellido2,String telefono,String telefono2,String correo,String usuario,String contrasena){

        super(nombre, apellido1, apellido2, telefono,telefono2, correo, usuario, contrasena);
        this.acompañamientos = new ArrayList<>();
        this.gruposP = new ArrayList<>();
        this.gruposVA = new ArrayList<>();
        this.gruposVS = new ArrayList<>();
    }

    public ArrayList<Grupo> getGruposP() {
        return gruposP;
    }
    public ArrayList<Grupo> getGruposVA() {
        return gruposVA;
    }
    public ArrayList<Grupo> getGruposVS() {
        return gruposVS;
    }

    // public void agregarAsistencia(Estudiante est, Tutoria lista) {
    //     lista.getAsistencia.add(est);
    // }
    // public void registrarTutoria()
    // {

    // }
    
}