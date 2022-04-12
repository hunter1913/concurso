package dominio;

public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private int puntaje;
    private int respuestasCorretas;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDTO(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    

    public UsuarioDTO(String nombreUsuario, int puntaje, int respuestasCorretas) {
        this.nombreUsuario = nombreUsuario;
        this.puntaje = puntaje;
        this.respuestasCorretas = respuestasCorretas;
    }

    public UsuarioDTO(int idUsuario, String nombreUsuario, int puntaje, int respuestasCorretas) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.puntaje = puntaje;
        this.respuestasCorretas = respuestasCorretas;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getRespuestasCorretas() {
        return respuestasCorretas;
    }

    public void setRespuestasCorretas(int respuestasCorretas) {
        this.respuestasCorretas = respuestasCorretas;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", puntaje=" + puntaje + ", respuestasCorretas=" + respuestasCorretas + '}';
    }
    
    
    
    
    
    
}
