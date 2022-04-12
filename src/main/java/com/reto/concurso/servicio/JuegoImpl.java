package com.reto.concurso.servicio;

import com.reto.consurso.dominio.CategoriaDTO;
import com.reto.consurso.datos.PreguntaDaoJdbc;
import com.reto.consurso.datos.IPreguntaDao;
import com.reto.consurso.datos.Conexion;
import java.sql.*;
import java.util.*;

public class JuegoImpl implements IJuego {

    private final IPreguntaDao datos;
    private int idPregunta;
    private String respuesta2;
    ICatalogoUsuarios catalogo2 = new CatalogoUsuariosImpl();

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
            if (pregunta.getCategoria() == 1) {
                seleccion = pregunta;
                respuesta2 = pregunta.getRespuestaCorrecta();
            }
        }
        System.out.println("Pregunta = " + seleccion);
        idPregunta = seleccion.getIdPregunta();
        conexion.commit();

    }

    @Override
    public void comparaRespuesta(String respuesta, String nombreUsuario) throws SQLException {
        int acomuladorPuntos= 0;
        int acomuladorRespuestas=0;
        if(respuesta.equals(respuesta2)  ){
            System.out.println("Ganaste 10 puntos: ");
            acomuladorPuntos=acomuladorPuntos+10;
            acomuladorRespuestas++;
            catalogo2.actualizarUsuario(nombreUsuario, idPregunta, acomuladorPuntos);
        }
    }
    
}
