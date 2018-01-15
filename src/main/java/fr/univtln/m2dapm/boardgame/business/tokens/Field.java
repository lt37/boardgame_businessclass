package fr.univtln.m2dapm.boardgame.business.tokens;

import board.IPlaceable;
import board.PlaceableBehavior;
import board.Square;

import javax.persistence.*;

@Entity
public class Field implements IPlaceable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "field_id")
    private int id;

    @OneToMany
    private PlaceableBehavior placeableBehavior = new PlaceableBehavior();

    private FieldType type;

    public Field() {
    }
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
}
