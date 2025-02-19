package br.com.catolicasc.complementaja.controller;

import br.com.catolicasc.complementaja.dto.CursoConsultaDTO;
import br.com.catolicasc.complementaja.dto.CursoDTO;
import br.com.catolicasc.complementaja.entity.Curso;
import br.com.catolicasc.complementaja.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/curso")
public class CursoController {
    @Autowired
    CursoService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<CursoDTO>> listAll() {
         return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable Long id) {
        CursoDTO c = service.findById(id);
        if (c != null) {
            return ResponseEntity.ok(c);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/detalhe")
    public ResponseEntity<CursoDTO> getCursoDetalhe(@RequestBody CursoConsultaDTO dto) {
        Curso curso = service.findByCodCursoAndCodPeriodoAndCodSemestreAndCodModalidade(dto.getCodCurso(), dto.getCodPeriodo(), dto.getCodSemestre(), dto.getCodModalidade());
        CursoDTO c = service.getCurso(curso);
        if (c != null) {
            return ResponseEntity.ok(c);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}