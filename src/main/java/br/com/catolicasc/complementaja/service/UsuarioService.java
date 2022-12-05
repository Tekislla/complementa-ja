package br.com.catolicasc.complementaja.service;

import br.com.catolicasc.complementaja.dto.UsuarioDTO;
import br.com.catolicasc.complementaja.dto.UsuarioLoginDTO;
import br.com.catolicasc.complementaja.entity.Usuario;
import br.com.catolicasc.complementaja.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    @Autowired
    CursoService cursoService;

    @Autowired
    DocumentoService documentoService;

    public UsuarioDTO getUsuario(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setCpf(usuario.getCpf());
        dto.setEmail(usuario.getEmail());
        dto.setCurso(cursoService.findById(usuario.getCursoId()));
        dto.setHorasConcluidas(usuario.getHorasConcluidas());
        dto.setHorasNecessarias(usuario.getHorasNecessarias());
        dto.setDocumentos(documentoService.findByUsuarioId(usuario.getId()));

        return dto;
    }

    public UsuarioDTO findById(Long id) {
        return getUsuario(repo.findById(id).get());
    }

    public UsuarioDTO login(UsuarioLoginDTO dto) {
        Optional<Usuario> u = repo.findByEmailAndSenha(dto.getEmail(), dto.getSenha());
        if (u.isPresent()) {
            return getUsuario(u.get());
        } else {
            return null;
        }
    }
}
