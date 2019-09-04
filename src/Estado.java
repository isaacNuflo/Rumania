
import java.util.ArrayList;

/**
 * Interfaz Estado desde el cual el estado del problema hereda. Define un método
 * para revisar si el estado actual es una meta, generar sucesores, y encontrar
 * el costo para llegar al estado actual.
 */
/**
 *
 * @author isaac
 */
public interface Estado {
    // determina si el estado actual es una meta

    boolean esMeta();

    // generar sucesores para el estado actual
    ArrayList<Estado> generarSucesores();

    // determinar el costo desde el estado inicial hasta ESTE estado
    double determinarCosto();

    // mostrar el estado actual
    public void mostrarEstado();

    // comparar los datos del estado actual
    public boolean igual(Estado s);
}
