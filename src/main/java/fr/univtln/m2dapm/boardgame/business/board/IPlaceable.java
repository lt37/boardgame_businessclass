package fr.univtln.m2dapm.boardgame.business.board;

import javax.persistence.Entity;

@Entity
public interface IPlaceable {

    public Square getSquare();
    public  void setSquare(Square newSquare);

}

