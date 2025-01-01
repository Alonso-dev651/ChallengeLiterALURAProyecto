package com.alonsodev.ChallengeLiterALURAProyecto.principal;

import com.alonsodev.ChallengeLiterALURAProyecto.model.Autor;
import com.alonsodev.ChallengeLiterALURAProyecto.model.Datos;
import com.alonsodev.ChallengeLiterALURAProyecto.model.DatosLibro;
import com.alonsodev.ChallengeLiterALURAProyecto.model.Libro;
import com.alonsodev.ChallengeLiterALURAProyecto.repository.AutorRepository;
import com.alonsodev.ChallengeLiterALURAProyecto.repository.LibroRepository;
import com.alonsodev.ChallengeLiterALURAProyecto.service.ConsumoAPI;
import com.alonsodev.ChallengeLiterALURAProyecto.service.ConvierteDatos;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorioLibro;
    private AutorRepository repositorioAutor;
    private int opcion = -1;

    public Principal(LibroRepository repoLibro, AutorRepository repoAutor) {
        this.repositorioLibro = repoLibro;
        this.repositorioAutor = repoAutor;
    }

    public void iniciar() {
        while (opcion != 0) {
            mostrarMenu();

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                teclado.nextLine();
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 0:
                    System.out.println("Finalizó el programa. ¡Gracias por usar la aplicacion!");
                    break;
                default:
                    System.out.println("Eliga una opcion valida");
                    break;
            }

        }
    }

    private void mostrarMenu() {
        System.out.println("""
                *****************************************
                *           Bienvenido a la             *
                *          Librería LiterALURA          *
                *---------------------------------------*
                *        Challenge realizado por        *
                *              AlonsoDev                *
                *****************************************
                | Por favor, seleccione una opción:     |
                |---------------------------------------|
                | 1. Buscar libro por título            |
                | 2. Listar libros registrados          |
                | 3. Listar autores registrados         |
                | 4. Listar autores vivos en un año     |
                | 5. Listar libros por idioma           |
                | 0. Salir de la aplicación             |
                *****************************************
                """);
    }

    private Datos getDatosLibros() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine().toLowerCase().replace(" ", "%20");
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreLibro);
        System.out.println(json);
        return conversor.obtenerDatos(json, Datos.class);
    }

    private void buscarLibro() {
        Datos datos = getDatosLibros();

        Optional<DatosLibro> newLibro = datos.resultados().stream()
                .findFirst();

        if (newLibro.isPresent()) {
            Libro libro = new Libro(newLibro.get());
            Autor autor = new Autor(newLibro.get().autor().getFirst());

            if (repositorioLibro.existsByTitulo(libro.getTitulo())) {
                System.out.println("Este libro ya se encuentra en la base de datos");
            } else {
                var autorExistente = repositorioAutor.findByNombreContainsIgnoreCase(autor.getNombre());
                if (autorExistente.isPresent()) {
                    var autorDelLibro = autorExistente.get();
                    libro.setAutor(autorDelLibro);
                    repositorioLibro.save(libro);
                } else {
                    autor.setListaLibros(libro);
                    repositorioAutor.save(autor);
                    repositorioLibro.save(libro);
                }
                System.out.println(libro);
                System.out.println("Se ingreso libro");
            }
        } else {
            System.out.println("No se encontro un libro");
        }
    }
}
