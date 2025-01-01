package com.alonsodev.ChallengeLiterALURAProyecto.repository;

import com.alonsodev.ChallengeLiterALURAProyecto.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    boolean existsByTitulo(String tituloLibro);
}
