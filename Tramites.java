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
@param justificacion  justificaion del porque el levantamiento de rquisitos
@param cursoLev  curso deseado a levantar
@param estado  estado del tramite 
 */
class LevRequisitos extends Tramites {

    private String justificacion;
    private Curso cursoLev;
    private String estado;

    public LevRequisitos(String justifi,Curso cursoLev,Calendar fecha,String descripcion, Estudiante est )
    {
        super(fecha,descripcion,est);
        this.justificacion = justifi;
        this.cursoLev = cursoLev;
        this.estado = "";
    }
}
/**
 * 
 * @param estado Estado del tramite
 * @param cursorn Curos reprobado
 * @param cursosPosiblesMatricular  lista de cursos posibles a matricular del estudiante
 */

class LevRN extends Tramites{
    private String estado;
    private Curso cursoRN;
    private ArrayList<Curso> cursosPosiblesMatricular;

    public LevRN( Curso cursorn,Calendar fecha,String descripcion, Estudiante est){
        super(fecha,descripcion,est);
        this.estado = "";
        this.cursoRN = cursorn;
        this.cursosPosiblesMatricular = new ArrayList<>();
    }

}
/**
@param tipo tipo de beca (prestamo o total)
@param periodo periodo de tiempo al que se va aplicar la beca
 */
class SoliBeca extends Tramites {

    private String tipo;
    private Calendar periodo;

    public SoliBeca(String tipo, Calendar periodo,Calendar fecha,String descripcion, Estudiante est )
    {
        super(fecha,descripcion,est);
        this.tipo = tipo;
        this.periodo = periodo;
    }
}

class Acompañamiento extends Tramites {
    private String tipoReporte;

    public Acompañamiento( String tipoReporte,Calendar fecha,String descripcion, Estudiante est){
        super(fecha,descripcion,est);
        this.tipoReporte=tipoReporte;
   }
   

}