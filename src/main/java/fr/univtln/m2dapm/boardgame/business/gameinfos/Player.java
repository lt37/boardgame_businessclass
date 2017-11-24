package fr.univtln.m2dapm.boardgame.business.gameinfos;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int id;
    private String loginName;
    private String encryptedPassword;
    private String email;

    private String displayedName;

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
