package com.company.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class ElementosRepositorio {

    List<Elemento> elementos = new ArrayList<>();

    ElementosRepositorio(){
        elementos.add(new Elemento("Inpulsa", "Shock Chest"));
        elementos.add(new Elemento("Kaom's", "Fire Chest"));
        elementos.add(new Elemento("Shavrrone's Wrappings" , "Chaos Innoculation Chest"));
        elementos.add(new Elemento("Headhunter", "Belt God"));
        elementos.add(new Elemento("Brutus Sprinkler", "Strength Stacking Mace"));
        elementos.add(new Elemento("Skyforth", "Boots"));
        elementos.add(new Elemento("Victario's Flight", "Boots"));
        elementos.add(new Elemento("Pledge of Hands", "Spell Staff"));
        elementos.add(new Elemento("Indigon", "Mana Helmet"));

    }
}
