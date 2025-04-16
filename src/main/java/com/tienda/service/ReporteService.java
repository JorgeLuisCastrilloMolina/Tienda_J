package com.tienda.service;
import java.io.IOExeption;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import java.util.Map;

public interface ReporteService {
    public ResponseEntity<Resource> generaResporte(
            String reporte,
            map<String,object> parametros,
            String tipo
             )
            throws IOException;

}
