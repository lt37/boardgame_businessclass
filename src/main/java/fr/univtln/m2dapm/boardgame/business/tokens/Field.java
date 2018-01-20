package fr.univtln.m2dapm.boardgame.business.tokens;

import fr.univtln.m2dapm.boardgame.business.board.IPlaceable;
import fr.univtln.m2dapm.boardgame.business.board.PlaceableBehavior;
import fr.univtln.m2dapm.boardgame.business.board.Square;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Field implements IPlaceable, Serializable {


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

    @Override
    public Square getSquare() {
        return placeableBehavior.getSquare();
    }

    @Override
    public void setSquare(Square square) {
        placeableBehavior.setSquare(square);
    }
}
