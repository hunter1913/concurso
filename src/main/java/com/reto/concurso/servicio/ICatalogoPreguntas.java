package com.reto.concurso.servicio;

import java.sql.*;

public interface ICatalogoPreguntas {

    void agregarPregunta(int categoria, String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuestaCorrecta)throws SQLException;

    void listarPregunta()throws SQLException;

    void borrarPregunta(int id)throws SQLException;
    
   


}
