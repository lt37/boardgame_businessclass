package fr.univtln.m2dapm.boardgame.business.gameinfos;

import fr.univtln.m2dapm.boardgame.business.tokens.Ship;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static fr.univtln.m2dapm.boardgame.business.gameinfos.Player.GET_ALL;


@Entity
@NamedQueries({
        @NamedQuery(name = GET_ALL,
        query = "SELECT p FROM Player AS p")
})
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Game> ongoingGames;

    private String loginName;
    private String encryptedPassword;
    private String email;

    private String displayedName;

    @Transient
    public static final String GET_ALL = "get_all_players";





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

    public void setId(int id) {
        this.id = id;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDisplayedName(String displayedName) {
        this.displayedName = displayedName;
    }

    public void setOngoingGames(List<Game> ongoingGames) {
        this.ongoingGames = ongoingGames;
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
