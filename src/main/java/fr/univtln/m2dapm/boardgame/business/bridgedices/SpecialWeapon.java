package fr.univtln.m2dapm.boardgame.business.bridgedices;

import fr.univtln.m2dapm.boardgame.business.tokens.Ship;

public class SpecialWeapon {

    private int id;

    private SpecialWeaponType type;
    private Ship owner;

    public SpecialWeapon(SpecialWeaponType type) {
        this.type = type;
    }

    public SpecialWeapon(SpecialWeaponType type, Ship owner) {
        this.type = type;
        this.owner = owner;
    }

    public SpecialWeaponType getType() {
        return type;
    }

    public Ship getOwner() {
        return owner;
    }

    public void setOwner(Ship owner) {
        this.owner = owner;
    }
}
