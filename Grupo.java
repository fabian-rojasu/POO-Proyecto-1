import java.util.ArrayList;
/**
 */
public abstract class Grupo extends Curso{
    protected int numGrupo;
    public ArrayList<Estudiante>estudiantes;
    public Profesor profesor;
    

    public Grupo(String codigo,String nombre,byte[] creditos,byte[] cantidadHoras, float calificacion, String RN,int numGrupo, Profesor profesor){
        super(codigo,nombre,creditos,cantidadHoras/*,calificacion,RN*/);
        this.numGrupo = numGrupo;
        this.profesor = profesor;
        this.profesor.getGrupos().add(this);
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

    public VirtualS(String codigo,String nombre,byte[] creditos,byte[] cantidadHoras, float calificacion,int numGrupo,Profesor profesor, String RN, String medio,String horaInicio,String horaFinal){
        super(codigo, nombre, creditos, cantidadHoras, calificacion, RN, numGrupo, profesor);
        this.medio=medio;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
    }
}

class Presencial extends Grupo{
    private String aula;
    private String horaInicio;
    private String horaFinal;

    public Presencial(String codigo,String nombre,byte[] creditos,byte[] cantidadHoras, float calificacion, String RN,int numGrupo,Profesor profesor, String aula,String horaInicio,String horaFinal){
        super(codigo, nombre, creditos, cantidadHoras, calificacion, RN ,numGrupo , profesor);
        this.aula=aula;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
    }
}

class VirtualA extends Grupo{
    private String medio;
    public VirtualA(String codigo,String nombre,byte[] creditos,byte[] cantidadHoras, float calificacion, String RN,int numGrupo,Profesor profesor, String medio){
        super(codigo, nombre, creditos, cantidadHoras, calificacion, RN,numGrupo, profesor);
        this.medio=medio;
        
    }
}
