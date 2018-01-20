package fr.univtln.m2dapm.boardgame.business.tokens;

import fr.univtln.m2dapm.boardgame.business.board.PlaceableBehavior;
import fr.univtln.m2dapm.boardgame.business.board.Square;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "field_id"))
public class Field extends AbstractToken implements Serializable {

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
