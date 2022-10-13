package br.com.catolicasc.complementaja.service;

import br.com.catolicasc.complementaja.dto.CursoDTO;
import br.com.catolicasc.complementaja.entity.Curso;
import br.com.catolicasc.complementaja.enums.CursoEnum;
import br.com.catolicasc.complementaja.enums.ModalidadeEnum;
import br.com.catolicasc.complementaja.enums.PeriodoEnum;
import br.com.catolicasc.complementaja.enums.SemestreEnum;
import br.com.catolicasc.complementaja.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    CursoRepository repo;
    CursoEnum cursoEnum;
    PeriodoEnum periodoEnum;
    SemestreEnum semestreEnum;
    ModalidadeEnum modalidadeEnum;


    private CursoDTO getCurso(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setNomeCurso(cursoEnum.findCurso(curso.getCodCurso()).getDescricao());
        dto.setPeriodo(periodoEnum.findPeriodo(curso.getCodPeriodo()).getDescricao());
        dto.setSemestre(semestreEnum.findSemestre(curso.getCodSemestre()).getDescricao());
        dto.setModalidade(modalidadeEnum.findModalidade(curso.getCodModalidade()).getDescricao());

        return dto;
    }


}
