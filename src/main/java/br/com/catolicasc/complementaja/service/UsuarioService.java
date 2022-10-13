package br.com.catolicasc.complementaja.service;

import br.com.catolicasc.complementaja.dto.CursoDTO;
import br.com.catolicasc.complementaja.dto.UsuarioDTO;
import br.com.catolicasc.complementaja.entity.Usuario;
import br.com.catolicasc.complementaja.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    public UsuarioDTO getUsuario(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setCpf(usuario.getCpf());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());
        dto.setCurso(new CursoService().findById(usuario.getCursoId()));
        dto.setHorasConcluidas(usuario.getHorasConcluidas());
        dto.setHorasNecessarias(usuario.getHorasNecessarias());

        return dto;
    }

    public UsuarioDTO findById(Long id) {
        return getUsuario(repo.findById(id).get());
    }
}
