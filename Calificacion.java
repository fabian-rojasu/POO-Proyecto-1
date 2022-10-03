import java.util.ArrayList;


public class Calificacion{
    private float nota;
    private Estudiante estudiante;
    private int RN;
    private ArrayList<VirtualA> grupoVA;
    private ArrayList<VirtualS> grupoVS;
    private ArrayList<Presencial> grupoP;
    public Calificacion(float nota, Estudiante estudiante){
        this.nota=nota;
        this.estudiante=estudiante;
        
        
       
    }

    //Metodos Sets
    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public void setGrupoVA(VirtualA tipoGrupo){
        grupoVA =new ArrayList<>();
        grupoVA.add(tipoGrupo);
    }
    public void setGrupoVS(VirtualS tipoGrupo){
        grupoVS =new ArrayList<>();
        grupoVS.add(tipoGrupo);
    }
    public void setGrupoP(Presencial tipoGrupo){
        grupoP =new ArrayList<>();
        grupoP.add(tipoGrupo);
    }
    public void setRN(int rN) {
        RN = rN;
    }

    //Metodos Gets
    public float getNota() {
        return nota;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public int getRN() {
        return RN;
    }
    
}