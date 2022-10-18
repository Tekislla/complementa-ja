package br.com.catolicasc.complementaja.controller;

import br.com.catolicasc.complementaja.dto.CursoConsultaDTO;
import br.com.catolicasc.complementaja.dto.CursoDTO;
import br.com.catolicasc.complementaja.entity.Curso;
import br.com.catolicasc.complementaja.service.CursoService;
import br.com.catolicasc.complementaja.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/curso")
public class CursoController {
    @Autowired
    CursoService service;

    @GetMapping(value = "/")
    public List<CursoDTO> listAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public CursoDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/detalhe")
    public CursoDTO getCursoDetalhe(@RequestBody CursoConsultaDTO dto) {
        Curso curso = service.findByCodCursoAndCodPeriodoAndCodSemestreAndCodModalidade(dto.getCodCurso(), dto.getCodPeriodo(), dto.getCodSemestre(), dto.getCodModalidade());
        return service.getCurso(curso);
    }
}
