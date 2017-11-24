package fr.univtln.m2dapm.boardgame.business.tokens;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import static fr.univtln.m2dapm.boardgame.business.tokens.ShipConstants.*;

//TODO: Unit testing
public class ShipFactory {

    public static Ship getShip(ShipType type, Player owner, Game game) throws IllegalArgumentException {
        Ship ship;
        switch(type) {
            case FREGATE:
                ship = new Ship(FREGATE_CLASS, FREGATE_ATK, FREGATE_HP, type, owner, game);
                break;
            case DESTROYER:
                ship = new Ship(DESTROYER_CLASS, DESTROYER_ATK, DESTROYER_HP, type, owner, game);
                break;
            case CUIRASSE:
                ship = new Ship(CUIRASSE_CLASS, CUIRASSE_ATK, CUIRASSE_HP, type, owner, game);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return ship;
    }
}
