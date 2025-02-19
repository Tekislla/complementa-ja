package br.com.catolicasc.complementaja.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.catolicasc.complementaja.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
