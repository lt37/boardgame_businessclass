package fr.univtln.m2dapm.boardgame.business.board;

import fr.univtln.m2dapm.boardgame.business.tokens.Field;
import fr.univtln.m2dapm.boardgame.business.tokens.Ship;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Square implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Board board;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ship> ships = new ArrayList<>();

    @OneToOne
    private Field field;

    private int[] coordinates;

    public Square(){}

    public Square(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> tokens) {
        for(Ship ship : this.ships) {
            ship.setSquare(null);
        }
        this.ships = tokens;
        for(Ship ship : this.ships) {
            ship.setSquare(this);
        }
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void addShip(Ship ship){
        ships.add(ship);
        ship.setSquare(this);
    }

    public void addShips(List<Ship> shipList){
        ships.addAll(shipList);
        for (Ship ship : shipList){
            ship.setSquare(this);
        }
    }

    public void removeShip(Ship ship){
        ships.remove(ship);
        ship.setSquare(null);

    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void removeAllShip(){
        ships.clear();
        for (Ship ship : ships){
            ship.setSquare(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square aSquare = (Square) o;

        if (ships != null ? !ships.equals(aSquare.ships) : aSquare.ships != null) return false;
        return Arrays.equals(coordinates, aSquare.coordinates);
    }

    @Override
    public int hashCode() {
        int result = ships != null ? ships.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(coordinates);
        return result;
    }
}
