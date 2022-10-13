import java.util.Calendar;
import java.util.ArrayList;
/**
 * 
 * @param fecha fecha del registro del tramite
 * @param descripcion detalles sobre el tramite
 * @param est  estudiante al que se le asocia el tramite
 */
public abstract class Tramites{

    protected Calendar fecha;
    protected String descripcion;
    protected Estudiante estudiante;

    public Tramites( Calendar fecha,String descripcion, Estudiante est){
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estudiante = est;
    }
}


/**
@param justificacionEst  justificaion del porque el levantamiento de rquisitos
@param cursoLev  curso deseado a levantar
@param estado  estado del tramite 
 */
class LevRequisitos extends Tramites implements ITramites {

    private String justificacionEst;
    private String justificacionRechazo;
    private Curso cursoLev;
    private boolean estado;

    public LevRequisitos(String justifi,boolean estado,Curso cursoLev,Calendar fecha,String descripcion, Estudiante est )
    {
        super(fecha,descripcion,est);
        this.justificacionEst = justifi;
        this.cursoLev = cursoLev;
        this.estado = estado;
    }
    public LevRequisitos(String justifi,boolean estado,Curso cursoLev,Calendar fecha,String descripcion, Estudiante est ,String justificacionRechazo)
    {
        super(fecha,descripcion,est);
        this.justificacionEst = justifi;
        this.cursoLev = cursoLev;
        this.estado = estado;
        this.justificacionRechazo=justificacionRechazo;
    }
    public Curso getCursoLev() {
        return cursoLev;
    }
    public boolean getEstado() {
        return estado;
    }
    public String getJustificacion() {
        return justificacionEst;
    }
    public void setJustificacionRechazo(String justificacionRechazo) {
        this.justificacionRechazo = justificacionRechazo;
    }
    public String getJustificacionEst() {
        return justificacionEst;
    }
    public String getJustificacionRechazo() {
        return justificacionRechazo;
    }
    @Override
    public Estudiante gEstudiante() {
       
        return estudiante;
    }
    @Override
    public Curso getCurso() {
        // TODO Auto-generated method stub
        return cursoLev;
    }
}
/**
 * 
 * @param estado Estado del tramite
 * @param cursorn Curos reprobado
 * @param cursosPosiblesMatricular  lista de cursos posibles a matricular del estudiante
 */

class LevRN extends Tramites implements ITramites{
    private boolean estado;
    private Curso cursoRN;
    private ArrayList<Curso> cursosPosiblesMatricular;
    public LevRN( Curso cursorn,Calendar fecha,String descripcion, Estudiante est,boolean estado){
        super(fecha,descripcion,est);
        this.estado = estado;
        this.cursoRN = cursorn;
        this.cursosPosiblesMatricular = new ArrayList<>();
    }

    public Curso getCursoRN() {
        return cursoRN;
    }
    public boolean getEstado() {
        return estado;
    }
    public ArrayList<Curso> getCursosPosiblesMatricular() {
        return cursosPosiblesMatricular;
    }
        @Override
    public Estudiante gEstudiante() {
        // TODO Auto-generated method stub
        return estudiante;
    }
    @Override
    public Curso getCurso() {
        // TODO Auto-generated method stub
        return cursoRN;
    }
    @Override
    public String getJustificacion() {
        // TODO Auto-generated method stub
        return null;
    }

}
/**
@param tipo tipo de beca (prestamo o total)
@param periodoInicio periodo de tiempo al que se va aplicar la beca
 */
class SoliBeca extends Tramites implements ITramites{

    private String tipo;
    private Calendar periodoInicio;
    private Calendar periodoFin;

    public SoliBeca(String tipo, Calendar periodoInicio,Calendar fecha,String descripcion, Estudiante est, Calendar periodoFin )
    {
        super(fecha,descripcion,est);
        this.tipo = tipo;
        this.periodoInicio = periodoInicio;
        this.periodoFin=periodoFin;
    }
    public Calendar getPeriodoInicio() {
        return periodoInicio;
    }
    public String getTipo() {
        return tipo;
    }
    public Calendar getPeriodoFin() {
        return periodoFin;
    }

    //Metodos de la interfaz ITramites
    @Override
    public Estudiante gEstudiante() {
        // TODO Auto-generated method stub
        return estudiante;
    }
    @Override
    public Curso getCurso() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getJustificacion() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean getEstado() {
        // TODO Auto-generated method stub
        return false;
    }
}

/**
 * Clase Acompañamiento con sus atributos y metodos respectivos
 */
class Acompañamiento extends Tramites {
    private String tipoReporte;

    //metodo constructor de la clase
    public Acompañamiento( String tipoReporte,Calendar fecha,String descripcion, Estudiante est){
        super(fecha,descripcion,est);
        this.tipoReporte=tipoReporte;
   }
   
    //Metodo Get
    public String getTipoReporte() {
        return tipoReporte;
    }
}