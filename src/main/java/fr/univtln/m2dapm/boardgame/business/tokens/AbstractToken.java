package fr.univtln.m2dapm.boardgame.business.tokens;

import fr.univtln.m2dapm.boardgame.business.board.Square;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractToken{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private int id;

    public abstract void setSquare(Square square);

    public abstract Square getSquare();
}
