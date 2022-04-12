package com.reto.consurso.test;

import com.reto.concurso.servicio.*;
import java.sql.SQLException;
import java.util.*;

public class ManejoPreguntasPresentacion {

    public static void main(String[] args) throws SQLException {

        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPreguntas catalogo = new CatalogoPreguntasImpl();
        ICatalogoUsuarios catalogo2 = new CatalogoUsuariosImpl();
        IJuego juego = new JuegoImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n"
                    + "1. Configurar Juego\n"
                    + "2. Usuarios\n"
                    + "3. Jugar\n"
                    + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
            if (opcion == 1) {
                while (opcion != 4) {
                    System.out.println("Elige una opcion: \n"
                            + "1. Agregar Pregunta\n"
                            + "2. Listar Preguntas\n"
                            + "3. Borra Pregunta\n"
                            + "4. Menu Anterior");
                    opcion = Integer.parseInt(scanner.nextLine());
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingresa la categoria");
                            var categoria = Integer.parseInt(scanner.nextLine());
                            System.out.println("Ingresa la pregunta");
                            var pregunta = scanner.nextLine();
                            System.out.println("Ingresa la Respuesta A");
                            var respuesta1 = scanner.nextLine();
                            System.out.println("Ingresa la Respuesta B");
                            var respuesta2 = scanner.nextLine();
                            System.out.println("Ingresa la Respuesta C");
                            var respuesta3 = scanner.nextLine();
                            System.out.println("Ingresa la Respuesta D");
                            var respuesta4 = scanner.nextLine();
                            System.out.println("Indique la letra de la respuesta correcta: ");
                            var respuestaCorrecta = scanner.nextLine();
                            catalogo.agregarPregunta(categoria, pregunta, respuesta1, respuesta2, respuesta3, respuesta4, respuestaCorrecta);
                            break;
                        case 2:
                            catalogo.listarPregunta();
                            break;
                        case 3:
                            System.out.println("Ingrese el ID a eliminar");
                            var id = Integer.parseInt(scanner.nextLine());
                            catalogo.borrarPregunta(id);
                            break;
                        case 0:
                            System.out.println("Hasta pronto ! ");
                            break;
                        default:
                            System.out.println("Opcion no reconocida");
                            break;
                    }
                }
            }
            if (opcion == 2) {
                while (opcion != 4) {
                    System.out.println("Elige una opcion: \n"
                            + "1. Agregar Usuario\n"
                            + "2. Listar Usuarios\n"
                            + "3. Borra Usuarios\n"
                            + "4. Menu Anterior");
                    opcion = Integer.parseInt(scanner.nextLine());
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nombre de usuario");
                            var nombreUsuario = scanner.nextLine();
                            catalogo2.agregarUsuario(nombreUsuario);
                            break;
                        case 2:
                            catalogo2.listarUsuario();
                            break;
                        case 3:
                            System.out.println("Ingrese el ID usuario a eliminar");
                            var id = Integer.parseInt(scanner.nextLine());
                            catalogo2.borrarUsuario(id);
                            break;
                        default:
                            System.out.println("Opcion no reconocida");
                            break;
                    }
                }
            }
            if (opcion == 3) {
                System.out.println("Ingrese el nombre de usuario");
                var nombreUsuario = scanner.nextLine();
                catalogo2.agregarUsuario(nombreUsuario);
                juego.listarCategoria1();
                System.out.println("Digite la opcion correcta ");
                var respuesta = scanner.nextLine();
                juego.comparaRespuesta(respuesta, nombreUsuario);
                catalogo2.actualizarUsuario(nombreUsuario, opcion, opcion);
            }
        }
    }
}
