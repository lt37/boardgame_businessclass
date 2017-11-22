package fr.univtln.m2dapm.boardgame;

import dices.Dice;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import org.apache.log4j.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * Hello world!
 */
public class App {
    @SuppressWarnings("unused")
    private static final Class[] shadeHack = {org.apache.log4j.RollingFileAppender.class,
            org.apache.log4j.ConsoleAppender.class,
            PatternLayout.class};

    //Set the logger with the real class name.
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        logger.info("App started.");
        logger.debug("About to talk :");
        System.out.println("Hello world !");


        Game game = new Game.Builder().setName("Clément").setPassword("est gay").setId(69).build();
    }
}
