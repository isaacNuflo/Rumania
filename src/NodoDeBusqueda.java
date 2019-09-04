/**
 * Clase para representar un NodoDeBusqueda. Esta será una envoltura para un
 * Estado, y rastreara el costo para encontra ese estado y el nodo padre.
 */

/**
 *
 * @author isaac
 */
public class NodoDeBusqueda implements Comparable<NodoDeBusqueda>{

    private Estado estadoActual;
    private NodoDeBusqueda padre;
    private double costo; // costo para llegar a este estado
    private double costoHeu; // costo heurístico
    private double costoF; // costo f(n)

    /**
     * Constructor para la raíz NodoDeBusqueda
     *
     * @param e el estado pasado
     */
    public NodoDeBusqueda(Estado e) {
        estadoActual = e;
        padre = null;
        costo = 0;
        costoHeu = 0;
        costoF = 0;
    }

    /**
     * Constructor para todos los otros NodoDeBusqueda
     *
     * @param prev el nodo padre
     * @param e el estado
     * @param c el costo g(n) para llegar a este nodo
     * @param h el costo h(n) para obtener este nodo
     */
    public NodoDeBusqueda(NodoDeBusqueda prev, Estado e, double c, double h) {
        padre = prev;
        estadoActual = e;
        costo = c;
        costoHeu = h;
        costoF = costo + costoHeu;
    }

    /**
     * @return el estadoActual
     */
    public Estado getEstadoActual() {
        return estadoActual;
    }

    /**
     * @return el padre
     */
    public NodoDeBusqueda getPadre() {
        return padre;
    }

    /**
     * @return el costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     *
     * @return el costo heurístico
     */
    public double getCostoHeu() {
        return costoHeu;
    }

    /**
     *
     * @return el costo f(n) para A*
     */
    public double getCostoF() {
        return costoF;
    }

    @Override
    public int compareTo(NodoDeBusqueda y) {
//        NodoDeBusqueda y = (NodoDeBusqueda) otro;
        if (this.costo > y.costo) {
            return 1;
        } else if (this.costo < y.costo) {
            return -1;
        } else {
            return 0;
        }
    }
}
