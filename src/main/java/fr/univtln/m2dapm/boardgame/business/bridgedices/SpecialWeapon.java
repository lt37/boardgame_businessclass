package fr.univtln.m2dapm.boardgame.business.bridgedices;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.business.tokens.Ship;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SpecialWeapon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "special_id")
    private int id;

    @Enumerated(EnumType.STRING)
    private SpecialWeaponType type;

    @OneToOne // A voir
    private Ship ownerShip;

    @OneToOne
    private Player owner;

    @ManyToOne
    private Game game;


    public SpecialWeapon() {
    }

    public SpecialWeapon(SpecialWeaponType type) {
        this.type = type;
    }

    public SpecialWeapon(SpecialWeaponType type, Ship ownerShip, Player owner, Game game) {
        this.type = type;
        this.ownerShip = ownerShip;
        this.owner = owner;
        this.game = game;
    }

    public SpecialWeaponType getType() {
        return type;
    }

    public Ship getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(Ship ownerShip) {
        this.ownerShip = ownerShip;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
