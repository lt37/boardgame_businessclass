package fr.univtln.m2dapm.boardgame.business.tokens;

import board.IPlaceable;
import board.PlaceableBehavior;
import board.Square;


public class Ship implements IPlaceable {

    protected int id;

    protected int shipClass;
    protected int attackPower;
    protected int healthPoints;
    protected ShipType type;

    protected PlaceableBehavior placeableBehavior = new PlaceableBehavior();


    public Ship() {
    }

    /**
     * Constructor (explicit)
     * @param shipClass
     * @param attackPower
     * @param healthPoints
     * @param type
     */
    public Ship(int shipClass, int attackPower, int healthPoints, ShipType type) {
        this.shipClass = shipClass;
        this.attackPower = attackPower;
        this.healthPoints = healthPoints;
        this.type = type;
    }


    /*
    Interface methods (delegated to placeableBehavior)
     */
    @Override
    public Square getSquare() {
        return placeableBehavior.getSquare();
    }

    @Override
    public void setSquare(Square square) {
        placeableBehavior.setSquare(square);
    }

    //TODO: remove from interface
    @Override
    public void changeSquare() {
    }


    public int getShipClass() {
        return shipClass;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public ShipType getType() {
        return type;
    }
}
