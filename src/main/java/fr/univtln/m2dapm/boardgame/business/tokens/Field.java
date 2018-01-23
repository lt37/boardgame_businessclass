package fr.univtln.m2dapm.boardgame.business.tokens;

import fr.univtln.m2dapm.boardgame.business.board.PlaceableBehavior;
import fr.univtln.m2dapm.boardgame.business.board.Square;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Field implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "field_id")
    private int id;

    @OneToOne
    private PlaceableBehavior placeableBehavior = new PlaceableBehavior();

    @Enumerated(EnumType.STRING)
    private FieldType type;

    public Field() {
    }
    public Field(FieldType type) {
        this.type = type;
    }

    public Square getSquare() {
        return placeableBehavior.getSquare();
    }

    public void setSquare(Square square) {
        placeableBehavior.setSquare(square);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlaceableBehavior getPlaceableBehavior() {
        return placeableBehavior;
    }

    public void setPlaceableBehavior(PlaceableBehavior placeableBehavior) {
        this.placeableBehavior = placeableBehavior;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }
}
