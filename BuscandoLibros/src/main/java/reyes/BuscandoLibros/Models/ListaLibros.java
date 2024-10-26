package reyes.BuscandoLibros.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaLibros(
        @JsonAlias("count") Integer numeroLibro,
        @JsonAlias("results") List<DatosLibros> libros) {
}
