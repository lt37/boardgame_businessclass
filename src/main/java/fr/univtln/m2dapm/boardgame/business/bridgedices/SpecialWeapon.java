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

    @OneToOne(mappedBy = "specialWeapon")
    private Bridge bridge;


    public SpecialWeapon() {
    }

    public SpecialWeapon(SpecialWeaponType type) {
        this.type = type;
    }

    public SpecialWeapon(SpecialWeaponType type, Bridge bridge) {
        this.type = type;
        this.bridge = bridge;
    }

    public SpecialWeaponType getType() {
        return type;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }
}
