package fr.univtln.m2dapm.boardgame.business.gameinfos;

import board.Board;
import fr.univtln.m2dapm.boardgame.business.bridgedices.Bridge;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int id;

    private String name;
    private String password;
    private boolean aPrivate;

    private int maxPlayers;
    private int maxArmyClassValue;

    private List<Player> players;
    private Board board;


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


        public Game build() {
            this.setId(id);
            this.setName(name);
            this.setPassword(password);
            this.setaPrivate(aPrivate);
            this.setMaxPlayers(maxPlayers);
            this.setMaxArmyClassValue(maxArmyClassValue);
            this.setPlayers(players);
            this.setBoard(board);

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
    }
}
