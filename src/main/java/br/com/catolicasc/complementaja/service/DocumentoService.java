package br.com.catolicasc.complementaja.service;

import br.com.catolicasc.complementaja.entity.Documento;
import br.com.catolicasc.complementaja.entity.Usuario;
import br.com.catolicasc.complementaja.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {
    @Autowired
    DocumentoRepository repo;

    @Autowired
    UsuarioService usuarioService;

    public List<Documento> findByUsuarioId(Long usuarioId) {
        return repo.findByUsuarioId(usuarioId);
    }

    public List<Documento> findDocumentosAceitosByUsuarioId(Long usuarioId) {
        return repo.findByUsuarioIdAndAceito(usuarioId, true);
    }

    public List<Documento> findDocumentosPendentesByUsuarioId(Long usuarioId) {
        return repo.findByUsuarioIdAndAceito(usuarioId, false);
    }

    public Documento enviarDocumento(Documento documento) {
        documento.setDataEnvio(new java.util.Date());
        return repo.save(documento);
    }

    public void aceitarDocumento(Long id) {
        Documento documento = repo.findById(id).get();
        usuarioService.validaHoras(documento.getUsuarioId(), documento.getHorasValidas());
        documento.setAceito(true);

        repo.save(documento);
    }
}
