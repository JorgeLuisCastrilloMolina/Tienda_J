package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="categoria")
/*
implements : implementar una libreria en esta clase
long : cuando es un dato premitivo de java ya viene directamnete de una libreria , no permite numero nulos
Long : permite numeros nulos y tambien a niveles de atributos o tipo de dato
diferencia de Long y interger : Long permite presentar numeros enteros mas largos(obtener especacio para almacenar mas informacion ) ,
interger mas limitado de capacidad de datos(Mas pequeño pero con limite de memoria)
*/
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id_categoria")
    private Long idCategoria; 
    
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name = "id_categoria", updatable = false)
    List<Producto> productos;
    
    public Categoria() {
    }

    public Categoria(String categoria, boolean activo) {
        this.descripcion = categoria;
        this.activo = activo;
    }   
}
