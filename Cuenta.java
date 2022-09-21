/**
 * Clase donde se describe los datos que tendran los perfiles de Profesor y Coordinador
 * @author Fabian Rojas, Geancarlo Oviedo, Jeison Blanco
 */
public class Cuenta {
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String[] telefonos;
    protected String correo;
    protected String usuario;
    protected String contrasena;
    
    //Metodo constructor de la clase cuenta
    public Cuenta(String nombre,String apellido1,String apellido2,String telefono,String correo,String usuario,String contrasena){
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.telefonos[0]=telefono;
        this.correo=correo;
        this.usuario=usuario;
        this.contrasena=contrasena;
    }

    //Metodos Sets
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public void setTelefonos(String telefono, byte pos) {
        this.telefonos[pos] = telefono;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;                   //////////////////
    }

    //Metodos Gets
    public String getNombre() {
        return nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public String getTelefonos(byte pos) {
        return telefonos[pos];
    }
    public String getCorreo() {
        return correo;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getContrasena() {
        return contrasena;                      /////////////////////
    }
}
