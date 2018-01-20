package fr.univtln.m2dapm.boardgame.business.board;

import fr.univtln.m2dapm.boardgame.business.tokens.AbstractToken;

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
    private List<AbstractToken> tokens = new ArrayList<>();

    private int[] coordinates;

    public Square(){}

    public Square(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public List<AbstractToken> getTokens() {
        return tokens;
    }

    public void setTokens(List<AbstractToken> tokens) {
        for(AbstractToken token : this.tokens) {
            token.setSquare(null);
        }
        this.tokens = tokens;
        for(AbstractToken token : this.tokens) {
            token.setSquare(this);
        }
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void addToken(AbstractToken token){
        tokens.add(token);
        token.setSquare(this);
    }

    public void addTokens(List<AbstractToken> tokenList){
        tokens.addAll(tokenList);
        for (AbstractToken token : tokenList){
            token.setSquare(this);
        }
    }

    public void removeToken(AbstractToken token){
        tokens.remove(token);
        token.setSquare(null);

    }

    public void removeAllToken(){
        tokens.clear();
        for (AbstractToken token : tokens){
            token.setSquare(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square aSquare = (Square) o;

        if (tokens != null ? !tokens.equals(aSquare.tokens) : aSquare.tokens != null) return false;
        return Arrays.equals(coordinates, aSquare.coordinates);
    }

    @Override
    public int hashCode() {
        int result = tokens != null ? tokens.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(coordinates);
        return result;
    }
}
