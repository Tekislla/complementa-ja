package br.com.catolicasc.complementaja.service;

import br.com.catolicasc.complementaja.dto.DocumentoDTO;
import br.com.catolicasc.complementaja.dto.DocumentoEnvioDTO;
import br.com.catolicasc.complementaja.dto.DocumentoResponseDTO;
import br.com.catolicasc.complementaja.dto.DocumentoUsuarioDetalheDTO;
import br.com.catolicasc.complementaja.entity.Documento;
import br.com.catolicasc.complementaja.entity.Usuario;
import br.com.catolicasc.complementaja.enums.TipoDocumentoEnum;
import br.com.catolicasc.complementaja.repository.DocumentoRepository;
import br.com.catolicasc.complementaja.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentoService {
    @Autowired
    DocumentoRepository repo;

    @Autowired
    UsuarioRepository usuarioRepository;

    public DocumentoDTO getDocumento(Documento documento) {
        DocumentoDTO dto = new DocumentoDTO();
        dto.setUsuario(usuarioRepository.findById(documento.getUsuarioId()).get());
        dto.setArquivo(documento.getArquivo());
        dto.setNomeDocumento(documento.getNomeDocumento());
        dto.setTipoDocumento(TipoDocumentoEnum.findTipoDocumento(documento.getCodTipoDocumento()).getDescricao());
        dto.setHorasValidas(documento.getHorasValidas());
        dto.setDataEmissao(documento.getDataEmissao());
        dto.setDataEnvio(documento.getDataEnvio());
        dto.setInstituicaoEmissora(documento.getInstituicaoEmissora());
        dto.setAceito(documento.getAceito());

        return dto;
    }

    public DocumentoResponseDTO getDocumentoResponse(Documento documento) {
        DocumentoResponseDTO dto = new DocumentoResponseDTO();
        dto.setId(documento.getId());
        dto.setUsuario(usuarioRepository.findById(documento.getUsuarioId()).get());
        dto.setUrlDownload(null);
        dto.setNomeDocumento(documento.getNomeDocumento());
        dto.setTipoDocumento(TipoDocumentoEnum.findTipoDocumento(documento.getCodTipoDocumento()).getDescricao());
        dto.setHorasValidas(documento.getHorasValidas());
        dto.setDataEmissao(documento.getDataEmissao());
        dto.setDataEnvio(documento.getDataEnvio());
        dto.setInstituicaoEmissora(documento.getInstituicaoEmissora());
        dto.setAceito(documento.getAceito());

        return dto;
    }

    public DocumentoUsuarioDetalheDTO getDocumentoUsuarioDetalhe(Documento documento) {
        DocumentoUsuarioDetalheDTO dto = new DocumentoUsuarioDetalheDTO();
        dto.setNomeDocumento(documento.getNomeDocumento());
        dto.setTipoDocumento(TipoDocumentoEnum.findTipoDocumento(documento.getCodTipoDocumento()).getDescricao());
        dto.setHorasValidas(documento.getHorasValidas());
        dto.setDataEmissao(documento.getDataEmissao());
        dto.setDataEnvio(documento.getDataEnvio());
        dto.setInstituicaoEmissora(documento.getInstituicaoEmissora());
        dto.setAceito(documento.getAceito());
        dto.setArquivo(documento.getArquivo());

        return dto;
    }

    public List<DocumentoUsuarioDetalheDTO> findByUsuarioId(Long usuarioId) {
        List<DocumentoUsuarioDetalheDTO> documentos = new ArrayList<>();
        repo.findByUsuarioId(usuarioId).forEach(documento -> {
            documentos.add(getDocumentoUsuarioDetalhe(documento));
        });
        return documentos;
    }

    public DocumentoDTO findById(Long id) {
        return getDocumento(repo.findById(id).get());
    }

    public List<DocumentoResponseDTO> findDocumentosPendentesByUsuarioId(Long usuarioId) {
        List<DocumentoResponseDTO> documentos = new ArrayList<>();
        repo.findByUsuarioIdAndAceito(usuarioId, null).forEach(documento -> {
            documentos.add(getDocumentoResponse(documento));
        });
        return documentos;
    }

    public List<DocumentoResponseDTO> findDocumentosAceitosByUsuarioId(Long usuarioId) {
        List<DocumentoResponseDTO> documentos = new ArrayList<>();
        repo.findByUsuarioIdAndAceito(usuarioId, true).forEach(documento -> {
            documentos.add(getDocumentoResponse(documento));
        });
        return documentos;
    }

    public List<DocumentoResponseDTO> findDocumentosRecusadosByUsuarioId(Long usuarioId) {
        List<DocumentoResponseDTO> documentos = new ArrayList<>();
        repo.findByUsuarioIdAndAceito(usuarioId, false).forEach(documento -> {
            documentos.add(getDocumentoResponse(documento));
        });
        return documentos;
    }

    public DocumentoDTO enviarDocumento(DocumentoEnvioDTO dto) throws ParseException {
        Documento doc = new Documento();

        doc.setUsuarioId(dto.getUsuarioId());
        doc.setArquivo(dto.getArquivo());
        doc.setNomeDocumento(dto.getNomeDocumento());
        doc.setCodTipoDocumento(dto.getCodTipoDocumento());
        doc.setHorasValidas(dto.getHorasValidas());
        doc.setDataEmissao(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDataEmissao()));
        doc.setDataEnvio(new java.util.Date());
        doc.setInstituicaoEmissora(dto.getInstituicaoEmissora());
        doc.setAceito(null);
        repo.save(doc);

        return getDocumento(doc);
    }

    public void aceitarDocumento(Long userId, Long docId) {
        Documento documento = repo.findById(docId).get();

        if (documento.getAceito() == null || !documento.getAceito()) {
            Usuario usuario = usuarioRepository.findById(userId).get();
            usuario.setHorasConcluidas(usuario.getHorasConcluidas() + documento.getHorasValidas());
            documento.setAceito(true);
            usuarioRepository.save(usuario);
            repo.save(documento);
        }
    }

    public void recusarDocumento(Long userId, Long docId) {
        Documento documento = repo.findById(docId).get();
        if (documento.getAceito() == null) {
            documento.setAceito(false);
        } else if (documento.getAceito()) {
            Usuario usuario = usuarioRepository.findById(userId).get();
            usuario.setHorasConcluidas(usuario.getHorasConcluidas() - documento.getHorasValidas());
            usuarioRepository.save(usuario);
            documento.setAceito(false);
        } else {
            documento.setAceito(false);
        }

        repo.save(documento);
    }

}
