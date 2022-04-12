package com.reto.concurso.servicio;

import datos.*;
import dominio.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class CatalogoPreguntasImpl implements ICatalogoPreguntas {

    private final IPreguntaDao datos;
    private int contadorCategoria1 = 0;
    private int contadorCategoria2 = 0;
    private int contadorCategoria3 = 0;
    private int contadorCategoria4 = 0;
    private int contadorCategoria5 = 0;

    public CatalogoPreguntasImpl() {
        this.datos = new PreguntaDaoJdbc();

    }

    @Override
    public void agregarPregunta(int categoria, String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuestaCorrecta) throws SQLException {
        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        IPreguntaDao preguntaDao = new PreguntaDaoJdbc(conexion);
        List<CategoriaDTO> categorias = preguntaDao.select();
        if (contadorCategoria1 < 5 && categoria == 1) {
            for (CategoriaDTO categoria1 : categorias) {
                if (categoria1.getCategoria() == 1) {
                    contadorCategoria1++;
                }
            }
            if (contadorCategoria1 < 5) {
                CategoriaDTO nuevapregunta = new CategoriaDTO(categoria, pregunta, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta);
                preguntaDao.insert(nuevapregunta);

            } else {
                System.out.println("Se supero el numero de preguntas categoria1: ");
            }
        }
        if (contadorCategoria2 < 5 && categoria == 2) {
            for (CategoriaDTO categoria1 : categorias) {
                if (categoria1.getCategoria() == 1) {
                    contadorCategoria2++;
                }
            }
            if (contadorCategoria2 < 5) {
                CategoriaDTO nuevapregunta = new CategoriaDTO(categoria, pregunta, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta);
                preguntaDao.insert(nuevapregunta);

            } else {
                System.out.println("Se supero el numero de preguntas categoria 2: ");
            }
        }
        if (contadorCategoria3 < 5 && categoria == 3) {
            for (CategoriaDTO categoria1 : categorias) {
                if (categoria1.getCategoria() == 3) {
                    contadorCategoria2++;
                }
            }
            if (contadorCategoria3 < 5) {
                CategoriaDTO nuevapregunta = new CategoriaDTO(categoria, pregunta, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta);
                preguntaDao.insert(nuevapregunta);

            } else {
                System.out.println("Se supero el numero de preguntas categoria 3: ");
            }
        }

        if (contadorCategoria4 < 5 && categoria == 4) {
            for (CategoriaDTO categoria1 : categorias) {
                if (categoria1.getCategoria() == 4) {
                    contadorCategoria4++;
                }
            }
            if (contadorCategoria4 < 5) {
                CategoriaDTO nuevapregunta = new CategoriaDTO(categoria, pregunta, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta);
                preguntaDao.insert(nuevapregunta);

            } else {
                System.out.println("Se supero el numero de preguntas categoria 4: ");
            }
        }

        if (contadorCategoria5 < 5 && categoria == 5) {
            for (CategoriaDTO categoria1 : categorias) {
                if (categoria1.getCategoria() == 5) {
                    contadorCategoria5++;
                }
            }
            if (contadorCategoria5 < 5) {
                CategoriaDTO nuevapregunta = new CategoriaDTO(categoria, pregunta, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta);
                preguntaDao.insert(nuevapregunta);

            } else {
                System.out.println("Se supero el numero de preguntas categoria 5: ");
            }
        }

        conexion.commit();
        //System.out.println("Se guardo pregunta nueva ");
    }

    @Override
    public void listarPregunta() throws SQLException {
        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        IPreguntaDao preguntaDao = new PreguntaDaoJdbc(conexion);
        List<CategoriaDTO> preguntas = preguntaDao.select();

        for (CategoriaDTO pregunta : preguntas) {
            System.out.println(pregunta);
        }

        conexion.commit();
//        System.out.println("Se ha echo comit de la transaccion ");

    }

    @Override
    public void borrarPregunta(int id) throws SQLException {
        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }

        IPreguntaDao preguntaDao1 = new PreguntaDaoJdbc(conexion);
        PreguntaDTO eliminarpre = new PreguntaDTO(id);
        preguntaDao1.delete(eliminarpre);

        conexion.commit();

    }

}
