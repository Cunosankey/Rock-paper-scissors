package MiniprojectP8;

import java.util.Random;

/**
 * Represents the computer player in the Rock, Paper, Scissors game.
 */
public class ComputerPlayer extends Player {

    /**
     * Constructor to create a computer player with the given name.
     *
     * @param name the name of the computer player
     */
    public ComputerPlayer(String name) {
        super(name); // Call the constructor of the superclass to set the name of the computer player
    }

    /**
     * Plays a turn for the computer player, randomly selecting a choice.
     *
     * @return the choice made by the computer player
     */
    @Override
    public RockPaperScissors.Choice playTurn() { // Implement the abstract method from the GamePlayer interface
        return RockPaperScissors.Choice.values()[new Random().nextInt(RockPaperScissors.Choice.values().length)]; // Randomly select a choice
    }
}
