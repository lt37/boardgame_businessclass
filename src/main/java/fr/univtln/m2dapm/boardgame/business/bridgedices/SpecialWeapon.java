package fr.univtln.m2dapm.boardgame.business.bridgedices;

public class SpecialWeapon {

    private SpecialWeaponType type;

    public SpecialWeapon(SpecialWeaponType type) {
        this.type = type;
    }

    public SpecialWeaponType getType() {
        return type;
    }
}
