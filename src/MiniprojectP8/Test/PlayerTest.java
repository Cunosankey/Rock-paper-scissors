package MiniprojectP8.Test;
import MiniprojectP8.Player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testScore() { // Test the getScore and setScore methods
        Player player = new Player("Test");
        player.setScore(5);
        assertEquals(5, player.getScore());
    }

    @Test
    void testPlayTurn() { // Test the playTurn method in the Player class
        Player player = new Player("Test");
        assertNull(player.playTurn()); // The playTurn method should return null
    }
}
