package com.reto.consurso.datos;

import static com.reto.consurso.datos.Conexion.close;
import com.reto.consurso.dominio.CategoriaDTO;
import com.reto.consurso.dominio.UsuarioDTO;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class UsuarioDaoJdbc implements IUsuarioDao {

    private Connection conexionTransacional;

    private static final String SQL_SELECT = "SELECT id_usuario, nombre_usuario, puntaje, respuestas_correctas FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(nombre_usuario) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE preguntas SET nombre_usuario= ?, puntaje=?, respuestas_correctas=?  WHERE id_usuario= ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";

    public UsuarioDaoJdbc(Connection conexionTransacional) {
        this.conexionTransacional = conexionTransacional;
    }

    public UsuarioDaoJdbc() {
    }

    @Override
    public int insert(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombreUsuario());

            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }
        }

        return registros;

    }

    @Override
    public int update(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setInt(2, usuario.getPuntaje());
            stmt.setInt(3, usuario.getRespuestasCorretas());
            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }
        }

        return registros;

    }

    @Override
    public int delete(UsuarioDTO usuario) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());

            registros = stmt.executeUpdate();
            System.out.println("Regitros borrado ");
        } finally {
            Conexion.close(stmt);

            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }
            return registros;
        }

    }

    @Override
    public List<UsuarioDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuario = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();

        conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while (rs.next()) {
            int idUsuario = rs.getInt("id_usuario");
            String nombreUsuario = rs.getString("nombre_usuario");
            int puntaje = rs.getInt("puntaje");
            int respuestasCorrectas = rs.getInt("respuestas_correctas");

            usuario = new UsuarioDTO(idUsuario, nombreUsuario, puntaje, respuestasCorrectas);
            usuarios.add(usuario);
        }

        close(rs);
        Conexion.close(stmt);
        if (this.conexionTransacional == null) {
            Conexion.close(conn);
        }

        return usuarios;
    }
}
