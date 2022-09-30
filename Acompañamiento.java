import java.util.Calendar;

public class Acompañamiento {
     private Calendar fecha;
     private String tipoReporte;
     private String descripcion;
     private Estudiante estudiante;

     public Acompañamiento(Calendar fecha, String tipoReporte,String descripcion, Estudiante estudiante){
        	this. fecha=fecha;
            this.tipoReporte=tipoReporte;
            this.descripcion=descripcion;
            this.estudiante=estudiante;
    }
    

}
