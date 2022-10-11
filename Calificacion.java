


public class Calificacion{
    private float nota;
    private Estudiante estudiante;
    private VirtualA grupoVA;
    private VirtualS grupoVS;
    private Presencial grupoP;

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
    public void setGrupoVA(VirtualA grupoVA) {
        this.grupoVA = grupoVA;
    }
   public void setGrupoVS(VirtualS grupoVS) {
       this.grupoVS = grupoVS;
   }
   public void setGrupoP(Presencial grupoP) {
       this.grupoP = grupoP;
   }
   

    //Metodos Gets
    public float getNota() {
        return nota;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public Presencial getGrupoP() {
        return grupoP;
    }
    public VirtualA getGrupoVA() {
        return grupoVA;
    }
    public VirtualS getGrupoVS() {
        return grupoVS;
    }

    
}