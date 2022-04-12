
package com.reto.consurso.datos;

import com.reto.consurso.dominio.PreguntaDTO;
import com.reto.consurso.dominio.CategoriaDTO;
import java.sql.SQLException;
import java.util.List;


public interface IPreguntaDao {
    
  
    
    public List<CategoriaDTO> select()throws SQLException;

    public int insert(CategoriaDTO pregunta)throws SQLException;

    public int update(CategoriaDTO pregunta)throws SQLException;

    public int delete(PreguntaDTO pregunta)throws SQLException;
    
 
    
        
    
}
