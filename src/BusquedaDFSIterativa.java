
import java.util.ArrayList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author isaac
 */
public class BusquedaDFSIterativa {

    public static int profundidad = 0;

    public static void setProfundidad(int profundidad) {
        BusquedaDFSIterativa.profundidad = profundidad;
    }

    public static void addProfundidad() {
        BusquedaDFSIterativa.profundidad++;
    }

    public static void printProfundidad() {
        System.out.println("PROFUNDIDAD: " + BusquedaDFSIterativa.profundidad);

    }

    /**
     * Funcion de inicialización
     *
     * @param ciudad
     * @param d
     */
    public static void buscar(Ciudad ciudad, boolean d) {
        Stack<NodoDeBusqueda> pila;
        do {
            NodoDeBusqueda raiz = new NodoDeBusqueda(new EstadoRumania(ciudad));
            pila = new Stack<>();
            pila.add(raiz);
            addProfundidad();
        } while (realizarBusqueda(pila, d));

    }

    /*
     * Método de ayuda para revisar si un NodoDeBusqueda ya fue evaluado.
     * Returns true si ya fue evaluado, false en caso contrario.
     */
    private static boolean revisarRepetidosYProfundidad(NodoDeBusqueda nodo) {
        boolean resultado = false;
        NodoDeBusqueda nodoRevisado = nodo;
        int profundidad = 0;
        // Mientras el padre de n no sea nulo, revisar si es igual al nodo
        // que estamos buscando.
        while (nodo.getPadre() != null && !resultado) {
            profundidad++;
            if (nodo.getPadre().getEstadoActual().igual(nodoRevisado.getEstadoActual())) {
                System.out.print("Nodo repetido: ");
                nodoRevisado.getEstadoActual().mostrarEstado();
                resultado = true;
            }
            if (profundidad > BusquedaDFSIterativa.profundidad) {
                System.out.println("profundidad superada");
                resultado = true;
            }
            nodo = nodo.getPadre();
        }

        return resultado;
    }

    /**
     * Realiza la Busqueda DFS usando pila como el espacio a buscar
     *
     * @param pila
     * @param d
     * @return
     */
    public static boolean realizarBusqueda(Stack<NodoDeBusqueda> pila, boolean d) {
        int contadorBusqueda = 1; // contador para el número de iteraciones

        System.out.println("--------INICIO DE LA BUSQUEDA---------");
        printProfundidad();

        while (!pila.isEmpty()) // mientras la pila no este vacía
        {
            System.out.println("-----------------");
            System.out.print("Sale de la pila: ");
            NodoDeBusqueda nodoTemp = (NodoDeBusqueda) pila.pop();
            nodoTemp.getEstadoActual().mostrarEstado();
            // si el nodoTemp no es el estado meta
            if (!nodoTemp.getEstadoActual().esMeta()) {
                // generar los sucesores inmediatos a nodoTemp
                ArrayList<Estado> sucesoresTemp = nodoTemp.getEstadoActual()
                        .generarSucesores();

                /*
                 * Iterar a través de los sucesores, envolverlo en un 
                 * NodoDeBusqueda, revisar si ya fue evaluado, y si no
                 * agregarlo a la cola.
                 */
                for (int i = sucesoresTemp.size() - 1; i >= 0; i--) {
                    // segundo parametro que suma el costo del nuevo nodo al 
                    // costo total actual en el NodoDeBusqueda
                    NodoDeBusqueda nuevoNodo = new NodoDeBusqueda(nodoTemp,
                            sucesoresTemp.get(i), nodoTemp.getCosto()
                            + sucesoresTemp.get(i).determinarCosto(), 0);

                    if (!revisarRepetidosYProfundidad(nuevoNodo)) {
                        pila.add(nuevoNodo);
                    }
                }
                contadorBusqueda++;
            } else // El estado meta se encontro. Imprimir el camino que lleva a este
            {
                System.out.println("---ES META!---");
                System.out.println("");
                // Use una pila para seguir el camino desde el estado inicial
                // al estado meta
                Stack<NodoDeBusqueda> caminoSolucion = new Stack<>();
                caminoSolucion.push(nodoTemp);
                nodoTemp = nodoTemp.getPadre();

                while (nodoTemp.getPadre() != null) {
                    caminoSolucion.push(nodoTemp);
                    nodoTemp = nodoTemp.getPadre();
                }
                caminoSolucion.push(nodoTemp);

                // El tamaño de la pila antes de iterarla y vaciarla.
                int iteraciones = caminoSolucion.size();

                System.out.println("----CAMINO DE LA SOLUCION----");

                for (int i = 0; i < iteraciones; i++) {
                    nodoTemp = caminoSolucion.pop();
                    nodoTemp.getEstadoActual().mostrarEstado();
                    System.out.println();
                    System.out.println();
                }
                System.out.println("El costo fue: " + nodoTemp.getCosto());
                printProfundidad();
                if (d) {
                    System.out.println("El número de nodos examinados: "
                            + contadorBusqueda);
                }

                System.exit(0);
            }
        }

        // No debería ocurrir nunca.
        System.out.println("Error! Solución no encontrada!");
        return true;
    }
}
