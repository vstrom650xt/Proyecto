package com.example.demo.controler;


import com.example.demo.repository.Oficio;
import com.example.demo.repository.Usuario;
import com.example.demo.service.OficioService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api") // a nivel de clase
public class OficioControler {
    @Autowired
    private OficioService oficioService;
//    public UsuarioController(UsuarioService usuarioService){
//        this.usuarioService = usuarioService;
//
//
//    }


    @GetMapping("/oficios/{id}")
    public List<Oficio> getOficios(@PathVariable("id") int id) throws SQLException {
    return  oficioService.getOficios(id);

    }


    @GetMapping("/oficios/img")
    public boolean getImg(@RequestBody Oficio oficio) throws SQLException {
        return true;

    }

}
