package fr.univtln.m2dapm.boardgame.business.board;


import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Board implements Serializable {

    private static Logger logger = Logger.getLogger(Board.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private int id;

    @OneToMany
    private List<Square> squares = new ArrayList<>();


    private int lines;
    private int columns;
    private String name;


    public Board(String name,int lines, int column) {
        this.lines = lines;
        this.columns = column;
        this.name = name;
        for(int i=0;i<column*lines;i++){
            int[] coord = new int[2];
            coord[0]=i%column;
            coord[1]=((i-i%column)/column);
            squares.add(new Square(coord));
        }
    }

    public Board(String name, List<Square> squares, int column, int lines){
        this.name = name;
        this.squares = squares;
        this.columns = column;
        this.lines = lines;
    }
    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public Square getSquareOnCoord(int x , int y){
        return this.squares.get(y*this.columns + x);
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumn() {
        return columns;
    }

    public void setColumn(int column) {
        this.columns = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;

        Board board = (Board) o;

        if (lines != board.lines) return false;
        if (columns != board.columns) return false;
        if (squares != null ? !squares.equals(board.squares) : board.squares != null) return false;
        return name != null ? name.equals(board.name) : board.name == null;
    }

    @Override
    public int hashCode() {
        int result = squares != null ? squares.hashCode() : 0;
        result = 31 * result + lines;
        result = 31 * result + columns;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    /**
     * Move token  to nbCase in direction.
     * @param token
     * @param direction 1 (default) :TOP 2:TOP/RIGHT 3:RIGHT 4:BOTTOM/RIGHT 5:BOTTOM 6:BOTTOM/LEFT 7:LEFT 8: (default) TOP/LEFT
     * @param nbSquare
     */

    public void movement(IPlaceable token, int direction, int nbSquare){

        int[] initialCoordonate = token.getSquare().getCoordinates();
        token.getSquare().removeToken(token);
        int tabPlacment = this.columns*initialCoordonate[1]+initialCoordonate[0];

        Square newSquare = null;

        try{
        switch(direction) {
            case 1: newSquare = this.squares.get(tabPlacment-(this.columns*nbSquare));
            break;
            case 2: newSquare = this.squares.get(tabPlacment-(this.columns*nbSquare)+nbSquare);
            break;
            case 3: newSquare = this.squares.get(tabPlacment+nbSquare);
            break;
            case 4: newSquare = this.squares.get(tabPlacment+(this.columns*nbSquare)+nbSquare);
            break;
            case 5: newSquare = this.squares.get(tabPlacment+(this.columns*nbSquare));
            break;
            case 6: newSquare = this.squares.get(tabPlacment+(this.columns*nbSquare)-nbSquare);
            break;
            case 7: newSquare =  this.squares.get(tabPlacment-nbSquare);
            break;
            case 8: newSquare = this.squares.get(tabPlacment-(this.columns*nbSquare)-nbSquare);
            break;
            default: newSquare = token.getSquare();
            break;
            }

            newSquare.addToken(token);
        } catch (Exception e){
          logger.error("Error on movement: "+e);
        }

    }

    /**
     *  Place  Iplaceable "token" in the square that have coordonate x and y
     * @param token
     * @param x
     * @param y
     */
    public void putTokenOn(IPlaceable token,int x, int y ){

        if(x < this.columns && y < this.lines && x>=0 && y>=0){
            this.squares.get(convertCoordToIndex(x,y)).addToken(token);
        }
        //Exception a rajouter
    }

    public int convertCoordToIndex(int x, int y){
        return y*this.columns+x;
    }

}