package br.com.catolicasc.complementaja.service;

import br.com.catolicasc.complementaja.dto.CursoDTO;
import br.com.catolicasc.complementaja.dto.DocumentoDTO;
import br.com.catolicasc.complementaja.dto.DocumentoEnvioDTO;
import br.com.catolicasc.complementaja.dto.DocumentoResponseDTO;
import br.com.catolicasc.complementaja.entity.Documento;
import br.com.catolicasc.complementaja.enums.TipoDocumentoEnum;
import br.com.catolicasc.complementaja.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentoService {
    @Autowired
    DocumentoRepository repo;

    @Autowired
    UsuarioService usuarioService;

    public DocumentoDTO getDocumento(Documento documento) {
        DocumentoDTO dto = new DocumentoDTO();
        dto.setUsuario(usuarioService.findById(documento.getUsuarioId()));
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
        dto.setUsuario(usuarioService.findById(documento.getUsuarioId()));
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

    public List<DocumentoDTO> findByUsuarioId(Long usuarioId) {
        List<DocumentoDTO> documentos = new ArrayList<>();
        repo.findAll().forEach(documento -> {
            documentos.add(getDocumento(documento));
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

    public void aceitarDocumento(Long id) {
        Documento documento = repo.findById(id).get();
        usuarioService.validaHoras(documento.getUsuarioId(), documento.getHorasValidas());
        documento.setAceito(true);

        repo.save(documento);
    }

    public void recusarDocumento(Long id) {
        Documento documento = repo.findById(id).get();
        documento.setAceito(false);

        repo.save(documento);
    }

}
