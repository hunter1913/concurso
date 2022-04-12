package com.reto.concurso.servicio;

import java.sql.*;

public interface ICatalogoUsuarios {

    void agregarUsuario(String usuario) throws SQLException;

    void listarUsuario() throws SQLException;

    void borrarUsuario(int id) throws SQLException;

}
