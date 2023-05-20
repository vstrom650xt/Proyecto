package com.example.demo.controler;

import com.example.demo.repository.Usuario;
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
public class UsuarioControler {
    @Autowired
    private UsuarioService usuarioService;
//    public UsuarioController(UsuarioService usuarioService){
//        this.usuarioService = usuarioService;
//
//
//    }


    @GetMapping("/usuarios/")
    public ResponseEntity<?>  getUsuarios( ){
        try {
            return new ResponseEntity<>(usuarioService.getUsuarios(), HttpStatus.OK);
        } catch(SQLException e){
            Map<String,Object> response = new HashMap<>();
            response.put("code",e.getErrorCode());
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }    }


    @PostMapping("/usuarios/")
    public boolean addUsuario(@RequestBody Usuario usuario) throws SQLException {
        return usuarioService.addUsuario(usuario);

    }
    @PutMapping("/usuarios/")
    public Usuario updateUsuario(@RequestBody Usuario usuario)throws SQLException{
        return  usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/usuarios/")
    public boolean deleteUsuario(@PathVariable("id") int id){
        return  usuarioService.deleteUsuario(id);

    }

}
