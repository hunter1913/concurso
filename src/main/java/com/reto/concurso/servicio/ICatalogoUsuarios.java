package com.reto.concurso.servicio;

import com.reto.consurso.dominio.*;
import java.sql.*;

public interface ICatalogoUsuarios {

    void agregarUsuario(String usuario) throws SQLException;

    void listarUsuario() throws SQLException;

    void borrarUsuario(int id) throws SQLException;
    
    void actualizarUsuario(String nombreUsuario, int puntaje, int respuestas_correctas) throws SQLException;

}
