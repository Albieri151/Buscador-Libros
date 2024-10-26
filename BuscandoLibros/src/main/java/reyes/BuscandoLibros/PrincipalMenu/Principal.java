package reyes.BuscandoLibros.PrincipalMenu;

import reyes.BuscandoLibros.Models.DatosLibros;
import reyes.BuscandoLibros.Models.ListaLibros;
import reyes.BuscandoLibros.Service.ConsumoApi;
import reyes.BuscandoLibros.Service.ConvertirDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private String URL = "http://gutendex.com/books/";
    private ConvertirDatos convertirDatos = new ConvertirDatos();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu(){

        var datos = convertirDatos.obtenerDatos(ConsumoApi.obtenerDatos(URL), ListaLibros.class);
        System.out.println(datos);

        List<DatosLibros> informacionLibros = new ArrayList<>(datos.libros());

        System.out.println("----LIBROS MAS VENDIDOS----");
        informacionLibros.forEach(datosLibros -> System.out.println(datosLibros.tituloLibro()));

        System.out.println("---TOP 5 MEJORES---");
        informacionLibros.stream().limit(5).forEach(d -> System.out.println(d.tituloLibro()+" "+d.numeroDescargas()));

        System.out.print("Ingrese el libro que desea buscar: ");
        var nombreLibro = sc.next();
        var busquedaLibro = convertirDatos.obtenerDatos(ConsumoApi.obtenerDatos(URL + "?search="+nombreLibro), ListaLibros.class);

        Optional<DatosLibros> libros = busquedaLibro.libros().stream().filter(e -> e.tituloLibro().toUpperCase()
                .contains(nombreLibro.toUpperCase())).findFirst();
        if(libros.isPresent()){
            System.out.println(libros);
        }

        IntSummaryStatistics est = informacionLibros.stream().collect(Collectors.summarizingInt(DatosLibros::numeroDescargas));
        System.out.println("Libro con mayores descargas: " + est.getMax());
        System.out.println("Libro con menores descargas: " + est.getMin());
        System.out.println("Promedio de descargar entre los libros: " + est.getAverage());
    }
}
