package com.reto.concurso.servicio;

import datos.*;
import dominio.*;
import java.sql.*;
import java.util.*;

public class JuegoImpl implements IJuego {

    private final IPreguntaDao datos;

    public JuegoImpl() {
        this.datos = new PreguntaDaoJdbc();
    }

    @Override
    public void listarCategoria1() throws SQLException {
        Connection conexion = null;
        conexion = Conexion.getConnection();
        CategoriaDTO seleccion = null;
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }

        IPreguntaDao preguntaDao = new PreguntaDaoJdbc(conexion);
        List<CategoriaDTO> preguntas = preguntaDao.select();
        List<CategoriaDTO> categorias = preguntaDao.select();

        for (CategoriaDTO pregunta : preguntas) {
            if(pregunta.getCategoria()==1)
                seleccion = pregunta;
        }
        System.out.println("Pregunta = " + seleccion);
        

        conexion.commit();

    }

}
