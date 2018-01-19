package fr.univtln.m2dapm.boardgame.business.dices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents the concept of a dice that contains a list of sides and can be rolled.
 */

@Entity
public class Dice  implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    int id;

    protected int nbSides;


    /**
     * Rolls the dice once
     * @return a random value from "sides"
     */
    public int roll() {
        return new Random().nextInt(nbSides);
    }


    /**
     * Rolls the dice "nbRolls" times
     * @param nbRolls the amount of times to roll the dice
     * @return a list of random values from "sides"
     */
    public List roll(int nbRolls) {
        List results = new ArrayList<>();
        for(int i = 0; i < nbRolls; i++)
            results.add(roll());
        return results;
    }

    /**
     * Constructor
     * @param sides : The list containing all of the dice's sides
     * @param nbSides : The amount of sides
     */
    public Dice(List sides, int nbSides) {
        this.nbSides = nbSides;
    }

    /**
     * Constructor
     * @param nbSides : The amount of sides
     */
    public Dice(int nbSides) {
        this.nbSides = nbSides;
    }

    /**
     * Constructor
     */
    public Dice() {
        this.nbSides = 0;
    }


    public int getNbSides() {
        return nbSides;
    }

    public void setNbSides(int nbSides) {
        this.nbSides = nbSides;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "id=" + id +
                ", nbSides=" + nbSides +
                '}';
    }
}
