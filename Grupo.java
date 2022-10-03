import java.util.ArrayList;
/**
 */
public abstract class Grupo extends Curso{
    protected int numGrupo;
    protected String id;
    public ArrayList<Estudiante>estudiantes;
    public Profesor profesor;
    

    public Grupo(String id, String codigo,String nombre,byte creditos,byte cantidadHoras,int numGrupo, Profesor profesor){
        super(codigo,nombre,creditos,cantidadHoras/*,calificacion,RN*/);
        this.numGrupo = numGrupo;
        this.profesor = profesor;
        this.id = id;
        this.estudiantes= new ArrayList<>();
    }

    public void AgregarEstudiantes(Estudiante estudiantes) {
        this.estudiantes.add(estudiantes);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String getDescripcion()
    {
        String respuesta;
        respuesta=String.format("%s (%d)\n\t %s\n", this.nombre,this.numGrupo,this.profesor.getNombre());
        return (respuesta);
    }
}

class VirtualS extends Grupo{
    private String medio;
    private String horaInicio;
    private String horaFinal;

    public VirtualS(String id,String codigo,String nombre,byte creditos,byte cantidadHoras,int numGrupo,Profesor profesor, String medio,String horaInicio,String horaFinal){
        super(id,codigo, nombre, creditos, cantidadHoras, numGrupo, profesor);
        this.medio=medio;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
        this.profesor.getGruposVS().add(this);
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }
    public String getMedio() {
        return medio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

}

class Presencial extends Grupo{
    private String aula;
    private String horaInicio;
    private String horaFinal;

    public Presencial(String id,String codigo,String nombre,byte creditos,byte cantidadHoras,int numGrupo,Profesor profesor, String aula,String horaInicio,String horaFinal){
        super(id,codigo, nombre, creditos, cantidadHoras, numGrupo , profesor);
        this.aula=aula;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
        this.profesor.getGruposP().add(this);
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public String getAula() {
        return aula;
    }

    public String getHoraFinal() {
        return horaFinal;
    }
    public void setAula(String aula) {
        this.aula = aula;
    }
    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
}

class VirtualA extends Grupo{
    private String medio;
    public VirtualA(String id,String codigo,String nombre,byte creditos,byte cantidadHoras,int numGrupo,Profesor profesor, String medio){
        super(id,codigo, nombre, creditos, cantidadHoras,numGrupo, profesor);
        this.medio=medio;
        this.profesor.getGruposVA().add(this);
        
    }
    public String getMedio() {
        return medio;
    }
    public void setMedio(String medio) {
        this.medio = medio;
    }
}
