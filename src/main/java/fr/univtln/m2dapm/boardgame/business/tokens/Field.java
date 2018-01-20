package fr.univtln.m2dapm.boardgame.business.tokens;

import fr.univtln.m2dapm.boardgame.business.board.PlaceableBehavior;
import fr.univtln.m2dapm.boardgame.business.board.Square;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AttributeOverride(name = "id", column = @Column(name = "field_id"))
public class Field implements Serializable {

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
}
