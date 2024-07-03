package MiniprojectP8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control; // The Control class is the base class for all user interface controls in JavaFX. It is used to set the preferred width of the HBoxes.
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Main class for the Rock, Paper, Scissors game application.
 */
public class RockPaperScissors extends Application {
    private Label playerNameLabel;
    private Label computerNameLabel;
    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;
    private Label playerScoreLabel;
    private Label playerScoreCountLabel;
    private Label computerScoreLabel;
    private Label computerScoreCountLabel;
    private ImageView playerChoiceImageView = new ImageView();
    private ImageView computerChoiceImageView = new ImageView();
    private Map<Choice, Image> choiceImages = new HashMap<>();
    private Player user;
    private ComputerPlayer computer;
    private ArrayList<Choice> playerChoices = new ArrayList<>();
    private ArrayList<Choice> computerChoices = new ArrayList<>();

    /**
     * Enum representing the choices in the game: ROCK, PAPER, SCISSORS.
     */
    public enum Choice { // Enum is used here, because the choices are limited to these three options (fixed constants)
        ROCK, PAPER, SCISSORS
    }

    public Player getUser() {
        return user;
    }
    public ComputerPlayer getComputer() {
        return computer;
    }

    /**
     * Main method to launch the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Start method to set up the JavaFX stage and scene.
     *
     * @param stage the primary stage for this application
     */
    @Override
    public void start(Stage stage) {
        this.user = new Player("User"); // Call the constructor of the Player class to create a player with the name "User"
        this.computer = new ComputerPlayer("Computer");
        stage.setTitle("Rock, Paper, Scissors");

        // Top
        playerNameLabel = new Label("Player");
        // Settings for the player name label
        playerNameLabel.setFont(Font.font("System", FontWeight.BOLD, 16));
        playerChoiceImageView.setFitWidth(90);
        playerChoiceImageView.setFitHeight(75);
        // Create a VBox to hold the player name and image view
        VBox vbLeftTop = new VBox(playerNameLabel, playerChoiceImageView);
        vbLeftTop.setAlignment(Pos.CENTER);

        // Create a placeholder pane to center the top elements
        Pane panePlaceHolder = new Pane();
        HBox.setHgrow(panePlaceHolder, Priority.ALWAYS);

        // Computer label at the top
        computerNameLabel = new Label("Computer");
        // Settings for the computer name label
        computerNameLabel.setFont(Font.font("System", FontWeight.BOLD, 16));
        computerChoiceImageView.setFitWidth(90);
        computerChoiceImageView.setFitHeight(75);

        // Create a VBox to hold the computer name and image view
        VBox vbRightTop = new VBox(computerNameLabel, computerChoiceImageView);
        vbRightTop.setAlignment(Pos.CENTER);

        // hbTopRoot is the first child of the VBox
        // Create an HBox to create space between the two vertical boxes. (It is added into the middle of them so they are pushed out to the sides of the hBox).
        HBox hbTopRoot = new HBox(vbLeftTop, panePlaceHolder, vbRightTop);
        VBox.setMargin(hbTopRoot, new Insets(10, 10, 0, 10));

        // Center
        Pane panePlaceHolderTwo = new Pane();
        // Create buttons for the user to select a choice
        rockButton = new Button("Rock");
        paperButton = new Button("Paper");
        scissorsButton = new Button("Scissors");
        // Settings for the buttons
        rockButton.setPrefSize(90, 75);
        paperButton.setPrefSize(90, 75);
        scissorsButton.setPrefSize(90, 75);

        // Set actions for the buttons to handle clicks, invoking the handleButtonClick method with the corresponding Choice
        // The setOnAction() method is used to register an event handler for the onAction event, which is triggered when the button is clicked.
        //e -> handleButtonClick(Choice.ROCK"): This lambda expression creates an event handler for the rockButton.
        //When the rockButton is clicked, the lambda expression is executed, and the handleButtonClick method is called with the Choice.ROCK argument.
        rockButton.setOnAction(e -> handleButtonClick(Choice.ROCK));
        paperButton.setOnAction(e -> handleButtonClick(Choice.PAPER));
        scissorsButton.setOnAction(e -> handleButtonClick(Choice.SCISSORS));
        // Placeholder pane to center the buttons and create spacing between them and set the placeholder panes to grow horizontally
        Pane panePlaceHolderThree = new Pane();
        HBox.setHgrow(panePlaceHolderTwo, Priority.ALWAYS);
        HBox.setHgrow(panePlaceHolderThree, Priority.ALWAYS);

        // HbCenterRoot is the second child of the VBox
        // Create an HBox for the center section containing the placeholder panes and buttons, and set its margins
        HBox hbCenterRoot = new HBox(panePlaceHolderTwo, rockButton, paperButton, scissorsButton, panePlaceHolderThree);
        VBox.setMargin(hbCenterRoot, new Insets(20, 10, 0, 10));

        // Bottom
        playerScoreLabel = new Label("Player Score:");
        playerScoreCountLabel = new Label("0");
        // Settings for the player score labels
        playerScoreLabel.setFont(Font.font("System", FontWeight.NORMAL, 24));
        playerScoreCountLabel.setFont(Font.font("System", FontWeight.NORMAL, 24));
        // Create an HBox to display the player's score with a label and count, setting my preferred width and spacing for a clean and neat layout
        HBox hbOne = new HBox(playerScoreLabel, playerScoreCountLabel);
        hbOne.setMaxWidth(Control.USE_PREF_SIZE);
        hbOne.setSpacing(5);

        // Computer score label and count
        computerScoreLabel = new Label("Computer Score:");
        computerScoreCountLabel = new Label("0");
        // Settings for the computer score labels
        computerScoreLabel.setFont(Font.font("System", FontWeight.NORMAL, 24));
        computerScoreCountLabel.setFont(Font.font("System", FontWeight.NORMAL, 24));

        // Create an HBox to display the computer's score with a label and count, setting my preferred width and spacing for a clean and neat layout
        HBox hbTwo = new HBox(computerScoreLabel, computerScoreCountLabel);
        hbTwo.setMaxWidth(Control.USE_PREF_SIZE);
        hbTwo.setSpacing(5);

        // vbBottomRoot is the third child of the VBox
        // Create a VBox to hold the two HBoxes for the scores of the Player and Computer
        VBox vbBottomRoot = new VBox(hbOne, hbTwo);
        // Settings for the VBox. Aligning them to the top of the VBox
        vbBottomRoot.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(vbBottomRoot, Priority.ALWAYS);
        vbBottomRoot.setPadding(new Insets(20, 0, 0, 0));

        // Create the root layout and scene
        VBox root = new VBox(hbTopRoot, hbCenterRoot, vbBottomRoot);
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show(); // Display the stage

        // If the images are not found at the specified location, an exception will be thrown.
        // The choiceImages map is declared as a HashMap where the key is of type Choice (an enum representing ROCK, PAPER, SCISSORS), and the value is of type Image.
        try {
            choiceImages.put(Choice.ROCK, new Image(getClass().getResource("/MiniprojectP8/Images/rock.png").toExternalForm()));
            choiceImages.put(Choice.PAPER, new Image(getClass().getResource("/MiniprojectP8/Images/paper.png").toExternalForm()));
            choiceImages.put(Choice.SCISSORS, new Image(getClass().getResource("/MiniprojectP8/Images/scissors.png").toExternalForm()));
        } catch (Exception e) {
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    /**
     * Handles the button click event to play a turn of the game.
     *
     * @param userChoice the choice made by the user
     */
    protected void handleButtonClick(Choice userChoice) {
        Choice computerChoice = computer.playTurn(); // Get the choice made by the computer

        // Add choices to the lists
        playerChoices.add(userChoice);
        computerChoices.add(computerChoice);

        // Set images based on choices
        playerChoiceImageView.setImage(choiceImages.get(userChoice));
        computerChoiceImageView.setImage(choiceImages.get(computerChoice));

        // Determine the result of the game (else-if is basically just that if any of these choices happens, the user wins, else computer wins)
        if (userChoice == computerChoice) { // It's a tie
        } else if ((userChoice == Choice.ROCK && computerChoice == Choice.SCISSORS)
                || (userChoice == Choice.PAPER && computerChoice == Choice.ROCK)
                || (userChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)) {
            user.setScore(user.getScore() + 1);
        } else {
            computer.setScore(computer.getScore() + 1);
        }

        
        // Update the score labels
        playerScoreCountLabel.setText(String.valueOf(user.getScore()));
        computerScoreCountLabel.setText(String.valueOf(computer.getScore()));

        // Print the match history
        printMatchHistory();
    }

    /**
     * Prints the history of choices made by the user and the computer in the last match.
     */
    public void printMatchHistory() {
        System.out.println("Match History:");
        for (int i = 0; i < playerChoices.size(); i++) {
            System.out.println("Turn " + (i + 1) + ": Player chose " + playerChoices.get(i) + ", Computer chose " + computerChoices.get(i));
        }
    }


}
