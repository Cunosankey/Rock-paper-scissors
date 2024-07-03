package MiniprojectP8;

/**
 * Represents a player in the Rock, Paper, Scissors game.
 */
public class Player implements GamePlayer {
    private String name; // It is only used in the constructor. This field could be removed for my current implementation. But it is kept, if the player name is needed in the future.
    private int score;

    /**
     * Constructor to create a player with the given name.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }


    /**
     * Gets the score of the player.
     *
     * @return the score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the player.
     *
     * @param score the score of the player
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Plays a turn for the player.
     * For a human player, this method could return the choice made by the user through the GUI.
     *
     * @return the choice made by the player
     */
    @Override
    public RockPaperScissors.Choice playTurn() {
        return null;
    }
}