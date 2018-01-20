package fr.univtln.m2dapm.boardgame.business.gameinfos;

import fr.univtln.m2dapm.boardgame.business.board.Board;
import fr.univtln.m2dapm.boardgame.business.bridgedices.Bridge;
import fr.univtln.m2dapm.boardgame.business.tokens.Ship;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private int id;

    @OneToOne(mappedBy = "game")
    private Board board;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Player> players;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Ship> ships;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Bridge> bridges;

    private String name;
    private String password;
    private boolean aPrivate;

    private int maxPlayers;
    private int maxArmyClassValue;



    public Game() {
        players = new ArrayList<>();
    }

    private Game(Builder builder) {
            this.id = builder.id;

        this.name = builder.name;
        this.password = builder.password;
        this.aPrivate = builder.aPrivate;

        this.maxPlayers = builder.maxPlayers;
        this.maxArmyClassValue = builder.maxArmyClassValue;

        this.players = builder.players;
        this.board = builder.board;
        this.bridges = builder.bridges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isaPrivate() {
        return aPrivate;
    }

    public void setaPrivate(boolean aPrivate) {
        this.aPrivate = aPrivate;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMaxArmyClassValue() {
        return maxArmyClassValue;
    }

    public void setMaxArmyClassValue(int maxArmyClassValue) {
        this.maxArmyClassValue = maxArmyClassValue;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) { players.add(player); }

    public void removePlayer(Player player) { players.remove(player); }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    public static class Builder {
        private int id;

        private String name;
        private String password;
        private boolean aPrivate;

        private int maxPlayers;
        private int maxArmyClassValue;

        private List<Player> players;
        private Board board;

        private List<Bridge> bridges;


        public Game build() {
            this.setId(id);
            this.setName(name);
            this.setPassword(password);
            this.setaPrivate(aPrivate);
            this.setMaxPlayers(maxPlayers);
            this.setMaxArmyClassValue(maxArmyClassValue);
            this.setPlayers(players);
            this.setBoard(board);
            this.setBridge(bridges);

            return new Game(this);
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setaPrivate(boolean aPrivate) {
            this.aPrivate = aPrivate;
            return this;
        }

        public Builder setMaxPlayers(int maxPlayers) {
            this.maxPlayers = maxPlayers;
            return this;
        }

        public Builder setMaxArmyClassValue(int maxArmyClassValue) {
            this.maxArmyClassValue = maxArmyClassValue;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setBridge(List<Bridge> bridges){
            this.bridges = bridges;
            return this;
        }
    }
}
