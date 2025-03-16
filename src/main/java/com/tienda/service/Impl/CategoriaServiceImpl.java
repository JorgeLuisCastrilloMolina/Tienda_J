package com.tienda.service.Impl;

import com.tienda.dao.CategoriaDao; 
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService
{
/*
    @Autowired : inyectar dependendecias automaticamente a nivel de spring , utilizar informacion  JpaRepository
    en de  los datos 
    
     @Override : modificando
     @Transactional(readOnly=true): va hacer a nivel de base de datos sera simplemente va leer
     var lista=categoriaDao.findAll(); :  va ir a categoriaDao y va a buscar a todos y lo de  .findAll()
    traer  toda la informacion de la lista de las categorias y lo va 
    devolver y ademas finALL viene por que esta utulizando  JpaRepository
    
    (activos) : el parametro activos si es verdadero va fichar las categorias que solo esten activas y si no estuviese activas
    va como removerlas y no lo va retornar en la lista
*/
     @Autowired
    private CategoriaDao categoriaDao;

     @Override
     @Transactional(readOnly=true)
     public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
     /* @Transactional(readOnly = true) : traernos el id , es un metodo de transaccion que va ir a la base
     de datos para traernos el id */
     @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
