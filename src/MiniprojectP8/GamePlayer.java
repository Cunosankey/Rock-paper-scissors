package MiniprojectP8;

/**
 * Interface representing a game player in the Rock, Paper, Scissors game.
 */
public interface GamePlayer {

    /**
     * Plays a turn for the game player.
     *
     * @return the choice made by the game player
     */
    RockPaperScissors.Choice playTurn();
}
