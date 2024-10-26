package reyes.BuscandoLibros.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("id") Integer idLibro,
        @JsonAlias("title") String tituloLibro,
        @JsonAlias("authors") List<DatosAutores> datosAutor,
        @JsonAlias("languages") List<String> lenguajes,
        @JsonAlias("download_count") Integer numeroDescargas
        ) {
}
