//package test;
//
//import datos.Conexion;
//import datos.*;
//import dominio.*;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//public class ManejoPreguntas {
//    public static void main(String[] args) {
//         Connection conexion = null;
//        try {
//            conexion = Conexion.getConnection();
//            if (conexion.getAutoCommit()) {
//                conexion.setAutoCommit(false);
//            }
//            
//            
//            PreguntaDao preguntaDao = new PreguntaDaoJdbc(conexion);
//            
////           PreguntaDTO nuevapregunta = new PreguntaDTO(1, "¿ Que es 78 ","a", "b", "c", "d", "b");
////          
////          PreguntaDTO actpregunta = new PreguntaDTO(1, 1, "¿ QUE ES 78", "A", "B", "C", "D", "B");
////          preguntaDao.update(actpregunta);
//            
//            PreguntaDTO eliminarpre = new PreguntaDTO(10);
//            preguntaDao.delete(eliminarpre);
//        
//            List<PreguntaDTO> preguntas = preguntaDao.select();
//            
//            for(PreguntaDTO pregunta: preguntas){
//                System.out.println("Preguntas DTO " + pregunta);
//            }
//            
//            
//            conexion.commit();
//            System.out.println("Se ha echo comit de la transaccion ");
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//            System.out.println("Entramos al ROLLBACK ");
//            try {
//                conexion.rollback();
//            } catch (SQLException ex1) {
//                ex1.printStackTrace(System.out);
//
//            }
//        }
//    }
//    }
//    
//
