package fr.univtln.m2dapm.boardgame.business.tokens;

import board.IPlaceable;
import board.PlaceableBehavior;
import board.Square;

public class Field implements IPlaceable {

    private PlaceableBehavior placeableBehavior = new PlaceableBehavior();
    private FieldType type;

    public Field(FieldType type) {
        this.type = type;
    }

    @Override
    public Square getSquare() {
        return placeableBehavior.getSquare();
    }

    @Override
    public void setSquare(Square square) {
        placeableBehavior.setSquare(square);
    }

    @Override
    public void changeSquare() {
        //TODO: delete this
    }
}
