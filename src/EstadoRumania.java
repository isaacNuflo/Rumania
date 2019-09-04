
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author isaac
 */
public class EstadoRumania implements Estado {

    private final Ciudad META = Ciudad.B;

    private Ciudad ciudadActual;
    
    private int heuristica = 0;

    private double costo;

    public EstadoRumania(Ciudad ciudad) {
        this.ciudadActual = ciudad;
    }

    public EstadoRumania(Ciudad ciudad, double costo) {
        this.ciudadActual = ciudad;
        this.costo = costo;
    }
    
    public int getHeuristica(){
        return this.heuristica;
    }
    
    public Ciudad getCiudadActual(){
        return this.ciudadActual;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    private void imprimirsucesores(ArrayList<Estado> sucesores) {
        System.out.println("Genera los siguientes sucesores:");
        for (Estado sucesor : sucesores) {
            sucesor.mostrarEstado();
        }
    }

    private void viajar(ArrayList<Estado> s) {
        switch (this.ciudadActual.getLetra()) {
            case "A":
                s.add(new EstadoRumania(Ciudad.S, 140.0));
                s.add(new EstadoRumania(Ciudad.T, 118.0));
                s.add(new EstadoRumania(Ciudad.Z, 75.0));
                break;
            case "B":
                s.add(new EstadoRumania(Ciudad.F, 211.0));
                s.add(new EstadoRumania(Ciudad.G, 90.0));
                s.add(new EstadoRumania(Ciudad.P, 101.0));
                s.add(new EstadoRumania(Ciudad.U, 85.0));
                break;
            case "C":
                s.add(new EstadoRumania(Ciudad.D, 120.0));
                s.add(new EstadoRumania(Ciudad.P, 138.0));
                s.add(new EstadoRumania(Ciudad.R, 146.0));
                break;
            case "D":
                s.add(new EstadoRumania(Ciudad.C, 120.0));
                s.add(new EstadoRumania(Ciudad.M, 75.0));
                break;
            case "E":
                s.add(new EstadoRumania(Ciudad.H, 86.0));
                break;
            case "F":
                s.add(new EstadoRumania(Ciudad.B, 211.0));
                s.add(new EstadoRumania(Ciudad.S, 99.0));
                break;
            case "G":
                s.add(new EstadoRumania(Ciudad.B, 90.0));
                break;
            case "H":
                s.add(new EstadoRumania(Ciudad.E, 86.0));
                s.add(new EstadoRumania(Ciudad.U, 98.0));
                break;
            case "I":
                s.add(new EstadoRumania(Ciudad.N, 87.0));
                s.add(new EstadoRumania(Ciudad.V, 92.0));
                break;
            case "L":
                s.add(new EstadoRumania(Ciudad.M, 70.0));
                s.add(new EstadoRumania(Ciudad.T, 111.0));
                break;
            case "M":
                s.add(new EstadoRumania(Ciudad.D, 75.0));
                s.add(new EstadoRumania(Ciudad.L, 70.0));
                break;
            case "N":
                s.add(new EstadoRumania(Ciudad.I, 87.0));
                break;
            case "O":
                s.add(new EstadoRumania(Ciudad.S, 151.0));
                s.add(new EstadoRumania(Ciudad.Z, 71.0));
                break;
            case "P":
                s.add(new EstadoRumania(Ciudad.B, 101.0));
                s.add(new EstadoRumania(Ciudad.C, 138.0));
                s.add(new EstadoRumania(Ciudad.R, 97.0));
                break;
            case "R":
                s.add(new EstadoRumania(Ciudad.C, 146.0));
                s.add(new EstadoRumania(Ciudad.P, 97.0));
                s.add(new EstadoRumania(Ciudad.S, 80.0));
                break;
            case "S":
                s.add(new EstadoRumania(Ciudad.A, 140.0));
                s.add(new EstadoRumania(Ciudad.F, 99.0));
                s.add(new EstadoRumania(Ciudad.O, 151.0));
                s.add(new EstadoRumania(Ciudad.R, 80.0));
                break;
            case "T":
                s.add(new EstadoRumania(Ciudad.A, 118.0));
                s.add(new EstadoRumania(Ciudad.L, 111.0));
                break;
            case "U":
                s.add(new EstadoRumania(Ciudad.B, 85.0));
                s.add(new EstadoRumania(Ciudad.H, 98.0));
                s.add(new EstadoRumania(Ciudad.V, 142.0));
                break;
            case "V":
                s.add(new EstadoRumania(Ciudad.I, 92.0));
                s.add(new EstadoRumania(Ciudad.U, 142.0));
                break;
            case "Z":
                s.add(new EstadoRumania(Ciudad.A, 75.0));
                s.add(new EstadoRumania(Ciudad.O, 71.0));
                break;
        }
    }

    @Override
    public boolean esMeta() {
        return ciudadActual.equals(META);
    }

    @Override
    public ArrayList<Estado> generarSucesores() {
        ArrayList<Estado> sucesores = new ArrayList<>();
        this.viajar(sucesores);
        this.imprimirsucesores(sucesores);
        return sucesores;
    }

    @Override
    public double determinarCosto() {
        return this.costo;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Ciudad Actual: " + ciudadActual.getNombre());
    }

    @Override
    public boolean igual(Estado s) {
        return ciudadActual.equals(((EstadoRumania) s).getCiudadActual());
    }

}
