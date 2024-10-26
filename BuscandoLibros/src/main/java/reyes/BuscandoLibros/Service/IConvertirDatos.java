package reyes.BuscandoLibros.Service;

public interface IConvertirDatos {
    <T> T obtenerDatos(String datos, Class<T> clase);
}
