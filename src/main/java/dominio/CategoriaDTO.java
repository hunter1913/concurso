package dominio;

public class CategoriaDTO extends PreguntaDTO{
    private int categoria;
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private String respuestaCorrecta;

    public CategoriaDTO() {
    }

    public CategoriaDTO(int categoria) {
        this.categoria = categoria;
    }

    public CategoriaDTO(int categoria, String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuestaCorrecta) {
        this.categoria = categoria;
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public CategoriaDTO(int categoria, String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuestaCorrecta, int idPregunta) {
        super(idPregunta);
        this.categoria = categoria;
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public String toString() {
        return " " + "Categoria: " + categoria + "\n"+"Pregunta: "+"\n" +"\n" + pregunta + "\n"+ "Respuesta A: " + respuesta1 + "\n"+"Respuesta B: " + respuesta2 + "\n"+"Respuesta C: " + respuesta3 +"\n"+ "Respuesta D: " + respuesta4 + "\n";
    }

   
    
    
}
