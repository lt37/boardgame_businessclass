package fr.univtln.m2dapm.boardgame.business.tokens;

import static fr.univtln.m2dapm.boardgame.business.tokens.ShipConstants.*;

//TODO: Unit testing
public class ShipFactory {

    public static Ship getShip(ShipType type) throws IllegalArgumentException {
        Ship ship;
        switch(type) {
            case FREGATE:
                ship = new Ship(FREGATE_CLASS, FREGATE_ATK, FREGATE_HP, type);
                break;
            case DESTROYER:
                ship = new Ship(DESTROYER_CLASS, DESTROYER_ATK, DESTROYER_HP, type);
                break;
            case CUIRASSE:
                ship = new Ship(CUIRASSE_CLASS, CUIRASSE_ATK, CUIRASSE_HP, type);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return ship;
    }
}
