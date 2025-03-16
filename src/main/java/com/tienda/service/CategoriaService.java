package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface CategoriaService {
    
    // Se obtiene listado de la BD /read
    public List<Categoria> getCategorias (boolean activos); // metodo lista
    
    // Se obtiene un Categoria, a partir del id de un categoria
    public Categoria getCategoria(Categoria categoria); // actualizacion
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Categoria categoria); // guardar la categoria
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Categoria categoria); //eliminar la categoria
   

}
