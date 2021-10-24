package br.com.wepdev.usuario.repositories;

import br.com.wepdev.usuario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Usuario findByEmail(String email);
}
