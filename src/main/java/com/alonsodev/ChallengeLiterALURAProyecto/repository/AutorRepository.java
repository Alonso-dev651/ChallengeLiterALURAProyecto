package com.alonsodev.ChallengeLiterALURAProyecto.repository;

import com.alonsodev.ChallengeLiterALURAProyecto.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreContainsIgnoreCase(String nombreAutor);
}
