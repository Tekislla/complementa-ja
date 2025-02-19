package br.com.catolicasc.complementaja.repository;

import br.com.catolicasc.complementaja.entity.Documento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentoRepository extends CrudRepository<Documento, Long> {
    List<Documento> findByUsuarioId(Long usuarioId);
    List<Documento> findByUsuarioIdAndAceito(Long usuarioId, Boolean aceito);

}
