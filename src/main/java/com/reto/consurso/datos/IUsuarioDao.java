package com.reto.consurso.datos;

import com.reto.consurso.dominio.UsuarioDTO;
import java.sql.*;
import java.util.*;

public interface IUsuarioDao {

    public List<UsuarioDTO> select() throws SQLException;

    public int insert(UsuarioDTO usuario) throws SQLException;

    public int update(UsuarioDTO usuario) throws SQLException;

    public int delete(UsuarioDTO usuario) throws SQLException;

}
