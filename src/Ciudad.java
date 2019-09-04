/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */
public enum Ciudad {

    A("Arad", "A"), B("Bucharest", "B"), C("Craiova", "C"), D("Drobeta", "D"),
    E("Eforie", "E"), F("Fagaras", "F"), G("Giurgin", "G"), H("Hirsova", "H"),
    I("Iasi", "I"), L("Lugoj", "L"), M("Mehadia", "M"), N("Neamt", "N"),
    O("Oradea", "O"), P("Pitesti", "P"), R("Rinnieu Vilcea", "R"), S("Sibiu", "S"),
    T("Timisoara", "T"), U("Urziceni", "U"), V("Vaslui", "V"), Z("Zerind", "Z");

    private Ciudad(String nombre, String letra) {
        this.nombre = nombre;
        this.letra = letra;
    }

    private final String nombre;
    private final String letra;

    public String getNombre() {
        return nombre;
    }

    public String getLetra() {
        return letra;
    }
}
