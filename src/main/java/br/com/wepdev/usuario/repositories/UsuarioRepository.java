package br.com.wepdev.usuario.repositories;

import br.com.wepdev.usuario.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);
}
