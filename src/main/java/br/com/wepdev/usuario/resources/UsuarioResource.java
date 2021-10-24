package br.com.wepdev.usuario.resources;

import br.com.wepdev.usuario.entities.Usuario;
import br.com.wepdev.usuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {


    @Autowired
    private UsuarioRepository usuarioRepository;


    /**
     * @PathVariable Long id -> parametro de url obrigatorio ser passado
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findbyId(@PathVariable Long id){

        Usuario obj = usuarioRepository.findById(id).get();

        return ResponseEntity.ok(obj);
    }


    /**
     * O parametro passado na URL é opicional.
     *
     * O parametro passado ficara mais ou menos assim : /search?email=nina@gmail.com
     */
    @GetMapping(value = "/search")
    public ResponseEntity<Usuario> findbyEmail(@RequestParam String email){

        Usuario obj = usuarioRepository.findByEmail(email);

        return ResponseEntity.ok(obj);
    }
}
