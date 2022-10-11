import java.util.ArrayList;
/**
 */
public abstract class Grupo {
    protected int numGrupo;
    protected String id;
    public ArrayList<Estudiante>estudiantes;
    public Profesor profesor;
    public Curso curso;
    

    public Grupo(int numGrupo,String id, Profesor profesor,Curso curso){
        
        this.numGrupo = numGrupo;
        this.id = id;
        this.estudiantes= new ArrayList<>();
        this.profesor = profesor;
        this.curso=curso;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void AgregarEstudiantes(Estudiante estudiantes) {
        this.estudiantes.add(estudiantes);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public Profesor getProfesor() {
        return profesor;
    }

    public void setCursos(Curso cursos) {
        this.curso = cursos;
    }
    public Curso getCursos() {
        return curso;
    }

    public String getId() {
        return id;
    }


    public String getDescripcion()
    {
        String respuesta;
        respuesta=String.format("%s(%d)\n\t %s\n",this.id,this.numGrupo,this.profesor.getNombre());
        return (respuesta);
    }
}

class VirtualS extends Grupo{
    private String medio;
    private String horaInicio;
    private String horaFinal;

    public VirtualS(int numGrupo,String id, Profesor profesor, String medio,String horaInicio,String horaFinal,Curso curso){
        super(numGrupo,id, profesor,curso);
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

    public Presencial(int numGrupo,String id,Profesor profesor, String aula,String horaInicio,String horaFinal,Curso curso){
        super( numGrupo,id, profesor,curso);
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
    public VirtualA(int numGrupo,String id,Profesor profesor, String medio,Curso curso){
        super(numGrupo,id, profesor,curso);
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
