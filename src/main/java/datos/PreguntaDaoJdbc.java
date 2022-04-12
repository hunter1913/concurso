package datos;

import static datos.Conexion.close;
import dominio.*;
import java.sql.*;
import java.util.*;

public class PreguntaDaoJdbc implements IPreguntaDao {

    private Connection conexionTransacional;

    private static final String SQL_SELECT = "SELECT id_pregunta, categoria, pregunta, respuesta1, respuesta2, respuesta3, respuesta4, rcorrecta FROM preguntas";
    private static final String SQL_INSERT = "INSERT INTO preguntas(categoria, pregunta, respuesta1, respuesta2, respuesta3, respuesta4, rcorrecta) VALUES(?, ?, ? ,?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE preguntas SET categoria= ?, pregunta= ?, respuesta1= ?, respuesta2= ?, respuesta3= ?, respuesta4 =?, rcorrecta=? WHERE id_pregunta= ?";
    private static final String SQL_DELETE = "DELETE FROM preguntas WHERE id_pregunta=?";

    public PreguntaDaoJdbc() {
    }

    public PreguntaDaoJdbc(Connection conexionTransacional) {
        this.conexionTransacional = conexionTransacional;
    }

    public List<CategoriaDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CategoriaDTO pregunta = null;
        CategoriaDTO contadorCategoria = null;
        List<CategoriaDTO> preguntas = new ArrayList<>();
        List<CategoriaDTO> categorias = new ArrayList<>();

        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPregunta = rs.getInt("id_pregunta");
                int categoriaCont = rs.getInt("categoria");
                String preguntad = rs.getString("pregunta");
                String respuesta1 = rs.getString("respuesta1");
                String respuesta2 = rs.getString("respuesta2");
                String respuesta3 = rs.getString("respuesta3");
                String respuesta4 = rs.getString("respuesta4");
                String respuestaCorrecta = rs.getString("rcorrecta");

                pregunta = new CategoriaDTO(categoriaCont, preguntad, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta, idPregunta);
                preguntas.add(pregunta);

                contadorCategoria = new CategoriaDTO(categoriaCont);
                categorias.add(contadorCategoria);
            }

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }
        }
        return preguntas;

    }

    public int insert(CategoriaDTO pregunta) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, pregunta.getCategoria());
            stmt.setString(2, pregunta.getPregunta());
            stmt.setString(3, pregunta.getRespuesta1());
            stmt.setString(4, pregunta.getRespuesta2());
            stmt.setString(5, pregunta.getRespuesta3());
            stmt.setString(6, pregunta.getRespuesta4());
            stmt.setString(7, pregunta.getRespuestaCorrecta());

            registros = stmt.executeUpdate();

            System.out.println("Registrso afectados = " + registros);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }
        }

        return registros;
    }

    public int update(CategoriaDTO pregunta) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setInt(1, pregunta.getCategoria());
            stmt.setString(2, pregunta.getPregunta());
            stmt.setString(3, pregunta.getRespuesta1());
            stmt.setString(4, pregunta.getRespuesta2());
            stmt.setString(5, pregunta.getRespuesta3());
            stmt.setString(6, pregunta.getRespuesta4());
            stmt.setString(7, pregunta.getRespuestaCorrecta());
            stmt.setInt(8, pregunta.getIdPregunta());

            registros = stmt.executeUpdate();
            System.out.println("Regitros actualizados = ");
        } finally {
            Conexion.close(stmt);

            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }

        }
        return registros;
    }

    public int delete(PreguntaDTO pregunta) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pregunta.getIdPregunta());

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

}
