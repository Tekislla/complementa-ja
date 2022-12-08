package br.com.catolicasc.complementaja.controller;

import br.com.catolicasc.complementaja.dto.DocumentoDTO;
import br.com.catolicasc.complementaja.dto.DocumentoEnvioDTO;
import br.com.catolicasc.complementaja.dto.DocumentoResponseDTO;
import br.com.catolicasc.complementaja.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value = "/documento")
public class DocumentoController {
    @Autowired
    DocumentoService service;

    @PostMapping(value = "/enviar")
    public ResponseEntity<DocumentoDTO> enviarDocumento(@RequestParam String usuarioId, @RequestParam MultipartFile arquivo, @RequestParam String nomeDocumento, @RequestParam String codTipoDocumento, @RequestParam String horasValidas, @RequestParam String dataEmissao, @RequestParam String instituicaoEmissora) throws IOException, ParseException {
        DocumentoEnvioDTO doc = new DocumentoEnvioDTO(Long.parseLong(usuarioId), arquivo.getBytes(), nomeDocumento, Integer.parseInt(codTipoDocumento), Integer.parseInt(horasValidas), dataEmissao, instituicaoEmissora);
        return ResponseEntity.ok().body(service.enviarDocumento(doc));
    }

    @GetMapping(value = "/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) throws IOException {
        DocumentoDTO doc = service.findById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getNomeDocumento() + ".pdf\"")
                .body(doc.getArquivo());
    }

    @GetMapping(value = "/pendentes/{usuarioId}")
    public ResponseEntity<List<DocumentoResponseDTO>> findDocumentosPendentesByUsuarioId(@PathVariable Long usuarioId) {
        List<DocumentoResponseDTO> files = service.findDocumentosPendentesByUsuarioId(usuarioId).stream().map(documento -> {
            String urlDownload = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documento/download/")
                    .path(documento.getId().toString())
                    .toUriString();

            documento.setUrlDownload(urlDownload);
            return documento;
        }).collect(Collectors.toList());

        if (!files.isEmpty() || files != null) {
            return ResponseEntity.status(HttpStatus.OK).body(files);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(files);
        }
    }

    @GetMapping(value = "/aceitos/{usuarioId}")
    public ResponseEntity<List<DocumentoResponseDTO>> findDocumentosAceitosByUsuarioId(@PathVariable Long usuarioId) {
        List<DocumentoResponseDTO> files = service.findDocumentosAceitosByUsuarioId(usuarioId).stream().map(documento -> {
            String urlDownload = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documento/download/")
                    .path(documento.getId().toString())
                    .toUriString();

            documento.setUrlDownload(urlDownload);
            return documento;
        }).collect(Collectors.toList());

        if (!files.isEmpty() || files != null) {
            return ResponseEntity.status(HttpStatus.OK).body(files);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(files);
        }

    }

    @GetMapping(value = "/recusados/{usuarioId}")
    public ResponseEntity<List<DocumentoResponseDTO>> findDocumentosRecusadosByUsuarioId(@PathVariable Long usuarioId) {
        List<DocumentoResponseDTO> files = service.findDocumentosRecusadosByUsuarioId(usuarioId).stream().map(documento -> {
            String urlDownload = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documento/download/")
                    .path(documento.getId().toString())
                    .toUriString();

            documento.setUrlDownload(urlDownload);
            return documento;
        }).collect(Collectors.toList());

        if (!files.isEmpty() || files != null) {
            return ResponseEntity.status(HttpStatus.OK).body(files);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(files);
        }
    }

    @PostMapping(value = "/aceitar/{userId}/{docId}")
    public ResponseEntity aceitarDocumento(@PathVariable(name = "userId") Long userId, @PathVariable(name = "docId") Long docId) {
        service.aceitarDocumento(userId, docId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/recusar/{userId}/{docId}")
    public ResponseEntity recusarDocumento(@PathVariable(name = "userId") Long userId, @PathVariable(name = "docId") Long docId) {
        service.recusarDocumento(userId, docId);
        return ResponseEntity.ok().build();
    }

}
