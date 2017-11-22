package fr.univtln.m2dapm.boardgame.business.bridgedices;

import dices.Dice;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private int id;

    private List<Dice> reserveDices;
    private List<Dice> specialDices;

    private SpecialWeapon specialWeapon;


    public Bridge(SpecialWeapon specialWeapon) {
        reserveDices = new ArrayList<>();
        specialDices = new ArrayList<>();
        this.specialWeapon = specialWeapon;
    }

    public void addReserveDice(Dice dice) {
        reserveDices.add(dice);
    }

    public void addSpecialDice(Dice dice) {
        specialDices.add(dice);
    }

    public void removeReserveDice(Dice dice) {
        reserveDices.remove(dice);
    }

    public void removeSpecialDice(Dice dice) {
        specialDices.remove(dice);
    }

    public List<Dice> getReserveDices() {
        return reserveDices;
    }

    public List<Dice> getSpecialDices() {
        return specialDices;
    }
}
