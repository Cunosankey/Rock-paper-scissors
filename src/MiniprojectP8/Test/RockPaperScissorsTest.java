
package MiniprojectP8.Test;

import MiniprojectP8.RockPaperScissors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {

    @Test
    void testHandleButtonClick() {
        RockPaperScissorsTestable game = new RockPaperScissorsTestable();
        int initialScore = game.getUserScore(); // The initial score of the user
        game.handleButtonClick(RockPaperScissors.Choice.ROCK); // The user chooses ROCK
        int finalScore = game.getUserScore(); // The final score of the user
        assertEquals(initialScore + 1, finalScore); // The user should win the round and the score should be increased by 1
    }

    private static class RockPaperScissorsTestable extends RockPaperScissors {
        public RockPaperScissorsTestable() {
            this.getUser().setScore(0); // Set the initial score of the user to 0
            this.getComputer().setScore(0); // Set the initial score of the computer to 0
        }

        public void handleButtonClick(Choice userChoice) {
            super.handleButtonClick(userChoice); // Call the method in the superclass
        }

        public int getUserScore() {
            return getUser().getScore();
        }
    }
}