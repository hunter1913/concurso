package com.reto.concurso.servicio;

import java.sql.SQLException;

public interface IJuego {
    
    void listarCategoria1()throws SQLException;
    void comparaRespuesta(String respuesta)throws SQLException;
    
}
