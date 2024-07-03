package MiniprojectP8.Test;
import MiniprojectP8.ComputerPlayer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    // Test the playTurn method
    @Test
    void testPlayTurn() {
        ComputerPlayer computerPlayer = new ComputerPlayer("Test");
        // The playTurn method should return a non-null value
        assertNotNull(computerPlayer.playTurn());
    }
}
