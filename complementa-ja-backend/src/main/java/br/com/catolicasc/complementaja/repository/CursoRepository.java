package br.com.catolicasc.complementaja.repository;

import br.com.catolicasc.complementaja.entity.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CursoRepository extends CrudRepository<Curso, Long> {
    Optional<Curso> findByCodCursoAndCodPeriodoAndCodSemestreAndCodModalidade(Integer codCurso, Integer codPeriodo, Integer codSemestre, Integer codModalidade);

}