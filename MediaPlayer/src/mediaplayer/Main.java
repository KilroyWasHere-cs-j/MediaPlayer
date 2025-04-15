package mediaplayer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;

public class Main extends Application {
    private static MediaPlayer mediaPlayer;
    private static double frame_position;
    private static double max_frame_position;

    public void playaudio() {
        mediaPlayer.play();
    }

    public void pauseaudio() {
        mediaPlayer.stop();
    }

    public void forward() {
        mediaPlayer.fast_forward();
    }

    public void backward() {
        mediaPlayer.fast_backward();
    }

    public void start(Stage s) {
        // Set title for the stage
        s.setTitle("Media Player");

        // Create buttons with improved styling
        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button forwardButton = new Button("Forward");
        Button backwardButton = new Button("Backward");

        // Define button colors
        Color playColor = Color.web("#4CAF50"); // Green
        Color pauseColor = Color.web("#f44336"); // Red
        Color controlColor = Color.web("#2196F3"); // Blue

        // Apply styled to buttons
        String buttonBaseStyle = "-fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 2, 2);";

        playButton.setStyle(buttonBaseStyle + String.format("-fx-background-color: %s;", toRgbString(playColor)));
        pauseButton.setStyle(buttonBaseStyle + String.format("-fx-background-color: %s;", toRgbString(pauseColor)));
        forwardButton.setStyle(buttonBaseStyle + String.format("-fx-background-color: %s;", toRgbString(controlColor)));
        backwardButton.setStyle(buttonBaseStyle + String.format("-fx-background-color: %s;", toRgbString(controlColor)));

        // Create HBox layout for buttons
        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));
        hbox.setStyle("-fx-background-color: #f0f0f0;");

        // Event handlers for buttons
        EventHandler<ActionEvent> playEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                playaudio();
            }
        };

        EventHandler<ActionEvent> pauseEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                pauseaudio();
            }
        };

        EventHandler<ActionEvent> forwardEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                forward();
            }
        };

        EventHandler<ActionEvent> backwardEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                backward();
            }
        };

        // Set actions for buttons
        playButton.setOnAction(playEvent);
        pauseButton.setOnAction(pauseEvent);
        forwardButton.setOnAction(forwardEvent);
        backwardButton.setOnAction(backwardEvent);

        // Add buttons to HBox
        hbox.getChildren().addAll(backwardButton, playButton, pauseButton, forwardButton);

        // Create a scene with the HBox layout
        Scene sc = new Scene(hbox, 500, 150);
        s.setScene(sc);

        // Show the stage
        s.show();
    }

    // Helper function to convert Color to an RGB string for CSS
    private String toRgbString(Color c) {
        return String.format("rgb(%.0f, %.0f, %.0f)", c.getRed() * 255, c.getGreen() * 255, c.getBlue() * 255);
    }

    public static void main(String args[]) {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.load("C:\\Users\\Gabriel\\Documents\\Git\\MediaPlayer\\MediaPlayer\\src\\mediaplayer\\nat_1.wav");
        max_frame_position = mediaPlayer.getFrameLength();
        launch(args);
    }
}