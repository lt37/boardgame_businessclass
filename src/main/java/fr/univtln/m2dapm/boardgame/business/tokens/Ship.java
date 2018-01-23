package fr.univtln.m2dapm.boardgame.business.tokens;

import fr.univtln.m2dapm.boardgame.business.board.PlaceableBehavior;
import fr.univtln.m2dapm.boardgame.business.board.Square;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Ship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ship_id")
    private int id;

    protected int shipClass;
    protected int attackPower;
    protected int healthPoints;

    @Enumerated(EnumType.STRING)
    protected ShipType type;

    @OneToOne
    protected Player owner;

    @ManyToOne
    protected Game game;

    @OneToOne
    protected PlaceableBehavior placeableBehavior = new PlaceableBehavior();


    public Ship() {
    }

    /**
     * Constructor (explicit)
     * @param shipClass
     * @param attackPower
     * @param healthPoints
     * @param type
     * @param owner
     */
    public Ship(int shipClass, int attackPower, int healthPoints, ShipType type, Player owner, Game game) {
        this.shipClass = shipClass;
        this.attackPower = attackPower;
        this.healthPoints = healthPoints;
        this.type = type;
        this.owner = owner;
        this.game = game;
    }


    /*
    Interface methods (delegated to placeableBehavior)
     */
    public Square getSquare() {
        return placeableBehavior.getSquare();
    }

    public void setSquare(Square square) {
        placeableBehavior.setSquare(square);
    }

    public int getShipClass() {
        return shipClass;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public ShipType getType() {
        return type;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShipClass(int shipClass) {
        this.shipClass = shipClass;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public PlaceableBehavior getPlaceableBehavior() {
        return placeableBehavior;
    }

    public void setPlaceableBehavior(PlaceableBehavior placeableBehavior) {
        this.placeableBehavior = placeableBehavior;
    }
}
