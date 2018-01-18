package fr.univtln.m2dapm.boardgame.business.bridgedices;

import fr.univtln.m2dapm.boardgame.business.dices.Dice;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bridge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bridge_id")
    private int id;

    @OneToMany
    private List<Dice> reserveDices;

    @OneToMany
    private List<Dice> specialDices;

    @OneToOne
    private SpecialWeapon specialWeapon;

    @ManyToOne
    private Player owner;

    @ManyToOne
    private Game game;


    public Bridge() {
        reserveDices = new ArrayList<>();
        specialDices = new ArrayList<>();
    }

    public Bridge(SpecialWeapon specialWeapon, Player owner, Game game) {
        reserveDices = new ArrayList<>();
        specialDices = new ArrayList<>();
        this.specialWeapon = specialWeapon;
        this.owner = owner;
        this.game = game;
    }

    public void addReserveDice(Dice dice) {
        reserveDices.add(dice);
    }

    public void addSpecialDice(Dice dice) {
        specialDices.add(dice);
    }

    public void removeReserveDice(Dice dice) {
        reserveDices.remove(dice);
    }

    public void removeSpecialDice(Dice dice) {
        specialDices.remove(dice);
    }

    public List<Dice> getReserveDices() {
        return reserveDices;
    }

    public List<Dice> getSpecialDices() {
        return specialDices;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
