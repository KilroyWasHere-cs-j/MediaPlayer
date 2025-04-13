package mediaplayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


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
        mediaPlayer.fast_backward();
    }

    public void backward() {
        mediaPlayer.fast_backward();
    }

    public void start(Stage s) 
    { 
               // Set title for the stage
        s.setTitle("Media Player");

        // Create buttons
        Button b = new Button("play");
        Button c = new Button("pause");
        Button d = new Button("forward");
        Button e = new Button("backward");

        // Create HBox layout for buttons to be placed side by side
        HBox hbox = new HBox(10); // 10 is the spacing between buttons

        // Event handlers for buttons
        EventHandler<ActionEvent> bevent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                playaudio();
            }
        };

        EventHandler<ActionEvent> cevent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                pauseaudio();
            }
        };

        EventHandler<ActionEvent> devent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                forward();
            }
        };

        EventHandler<ActionEvent> eevent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                backward();
            }
        };

        // Set actions for buttons
        b.setOnAction(bevent);
        c.setOnAction(cevent);
        d.setOnAction(devent);
        e.setOnAction(eevent);

        // Add buttons to HBox
        hbox.getChildren().addAll(b, c, d, e);

        // Create a scene with the HBox layout
        Scene sc = new Scene(hbox, 400, 100); // Increased width for the buttons to fit
        s.setScene(sc);

        // Show the stage
        s.show();
    }

    public static void main(String args[]) 
    { 
        String path = "nat_1.wav";
        mediaPlayer = new MediaPlayer();
        mediaPlayer.load("C:\\Users\\Gabriel\\Documents\\Git\\MediaPlayer\\MediaPlayer\\src\\mediaplayer\\n" + //
                        "at_1.wav");
        max_frame_position = mediaPlayer.getFrameLength();
        launch(args); 
    } 
}