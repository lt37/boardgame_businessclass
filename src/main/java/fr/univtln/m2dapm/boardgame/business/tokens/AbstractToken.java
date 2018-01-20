package fr.univtln.m2dapm.boardgame.business.tokens;

import fr.univtln.m2dapm.boardgame.business.board.Square;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractToken{
    public abstract void setSquare(Square square);

    public abstract Square getSquare();
}
