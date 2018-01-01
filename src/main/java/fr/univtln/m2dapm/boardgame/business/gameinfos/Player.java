package fr.univtln.m2dapm.boardgame.business.gameinfos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private int id;

    private String loginName;
    private String encryptedPassword;
    private String email;

    private String displayedName;

    @OneToMany
    private List<Game> ongoingGames;


    public Player() {
        ongoingGames = new ArrayList<>();
    }

    public void addGame(Game game) {
        ongoingGames.add(game);
    }

    public void removeGame(Game game) {
        ongoingGames.remove(game);
    }


    public int getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayedName() {
        return displayedName;
    }

    public List<Game> getOngoingGames() {
        return ongoingGames;
    }
}
