package com.reto.concurso.servicio;

import com.reto.consurso.dominio.UsuarioDTO;
import com.reto.consurso.datos.IUsuarioDao;
import com.reto.consurso.datos.Conexion;
import com.reto.consurso.datos.UsuarioDaoJdbc;
import java.sql.*;
import java.util.*;

public class CatalogoUsuariosImpl implements ICatalogoUsuarios {

    private final IUsuarioDao datos;

    public CatalogoUsuariosImpl() {
        this.datos = new UsuarioDaoJdbc();
    }

    @Override
    public void agregarUsuario(String usuario) throws SQLException {
        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        IUsuarioDao usuarioDao = new UsuarioDaoJdbc();
        UsuarioDTO nuevoUsuario = new UsuarioDTO(usuario);
        usuarioDao.insert(nuevoUsuario);
        conexion.commit();
    }

    @Override
    public void listarUsuario() throws SQLException {
        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        IUsuarioDao usuarioDao = new UsuarioDaoJdbc(conexion);
        List<UsuarioDTO> usuarios = usuarioDao.select();
        for (UsuarioDTO usuario : usuarios) {
            System.out.println(usuario);
        }
        conexion.commit();
    }

    @Override
    public void borrarUsuario(int id) throws SQLException {
        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        IUsuarioDao usuarioDao = new UsuarioDaoJdbc(conexion);
        UsuarioDTO eliminarpre = new UsuarioDTO(id);
        usuarioDao.delete(eliminarpre);
        conexion.commit();
    }

    @Override
    public void actualizarUsuario(String nombreUsuario, int puntaje, int respuestas_correctas) throws SQLException {
        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        IUsuarioDao usuarioDao = new UsuarioDaoJdbc(conexion);
        UsuarioDTO nuevoUsuario = new UsuarioDTO(nombreUsuario, puntaje, respuestas_correctas);
        usuarioDao.update(nuevoUsuario);
        
        
        
        conexion.commit();
    }

}
