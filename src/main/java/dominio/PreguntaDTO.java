package dominio;

public class PreguntaDTO {

    protected int idPregunta;

    public PreguntaDTO() {
    }

    public PreguntaDTO(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public String toString() {
        return "idPregunta=" + idPregunta + '}';
    }
   
    
    
    
    
    
    
}
