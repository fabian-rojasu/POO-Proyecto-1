import java.util.ArrayList;
/**
* Clase padre grupo, se enlaza a un curso y se crea desde sus hijos
*/
public abstract class Grupo {
    protected int numGrupo;
    protected String id;
    public ArrayList<Estudiante>estudiantes;
    public Profesor profesor;
    public Curso curso;
    
    //Constructor
    public Grupo(int numGrupo,String id, Profesor profesor,Curso curso){
        
        this.numGrupo = numGrupo;
        this.id = id;
        this.estudiantes= new ArrayList<>();
        this.profesor = profesor;
        this.curso=curso;
    }
    ////Metodos setters o adds///////*
    public void setId(String id) {
        this.id = id;
    }
    public void AgregarEstudiantes(Estudiante estudiantes) {
        this.estudiantes.add(estudiantes);
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public void setCursos(Curso cursos) {
        this.curso = cursos;
    }
    ////////  Getters  //////////
    public Curso getCursos() {
        return curso;
    }
    public String getId() {
        return id;
    }
        public Profesor getProfesor() {
        return profesor;
    }
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    /// Resumen de los atributos del grupo
    public String getDescripcion()
    {
        String respuesta;
        respuesta=String.format("%s(%d)\n\t %s\n",this.id,this.numGrupo,this.profesor.getNombre());
        return (respuesta);
    }
}

/**
* Hijo de grupo para el tipo Virtual Sincronico 
 */
class VirtualS extends Grupo{
    private String medio;
    private String horaInicio;
    private String horaFinal;

    ////  Costructor \\\\
    public VirtualS(int numGrupo,String id, Profesor profesor, String medio,String horaInicio,String horaFinal,Curso curso){
        super(numGrupo,id, profesor,curso);
        this.medio=medio;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
        this.profesor.getGruposVS().add(this);
    }
    
    //// SETTERS \\\\
    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public void setMedio(String medio) {
        this.medio = medio;
    }

    //// GETTERS \\\\\
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

/**
* Hijo de grupo para el tipo Presencial
*/
class Presencial extends Grupo{
    private String aula;
    private String horaInicio;
    private String horaFinal;

    ////  Costructor \\\\
    public Presencial(int numGrupo,String id,Profesor profesor, String aula,String horaInicio,String horaFinal,Curso curso){
        super( numGrupo,id, profesor,curso);
        this.aula=aula;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
        this.profesor.getGruposP().add(this);
    }
    /// GETTERS \\\
    public String getHoraInicio() {
        return horaInicio;
    }
    public String getAula() {
        return aula;
    }

    public String getHoraFinal() {
        return horaFinal;
    }
    //// SETTERS \\\\
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
/**
* Hijo de grupo para el tipo de grupo Virtual Asincronico
*/
class VirtualA extends Grupo{
    private String medio;
    /// Constructor \\\
    public VirtualA(int numGrupo,String id,Profesor profesor, String medio,Curso curso){
        super(numGrupo,id, profesor,curso);
        this.medio=medio;
        this.profesor.getGruposVA().add(this);
        
    }
    ///Get///
    public String getMedio() {
        return medio;
    }
    //set//
    public void setMedio(String medio) {
        this.medio = medio;
    }
}
