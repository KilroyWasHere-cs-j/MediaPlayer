package mediaplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private static MediaController mediaController;

    public void playaudio() {
        if (mediaController.paths.length <= 1) {
            System.out.print("Playing through audio");
            mediaController.play_through();
        } else {
            System.err.println("No audio loaded");
        }
    }

    public void pauseaudio() {
        mediaController.stop();
    }

    public void forward() {
        mediaController.fast_forward();
    }

    public void backward() {
        mediaController.fast_backward();
    }

    public void start(Stage s) 
    { 
        // set title for the stage 
        s.setTitle("creating buttons"); 
  
        // create a button 
        Button b = new Button("play"); 
        Button c = new Button("pause"); 
        Button d = new Button("forward");
        Button e = new Button("backward");
  
        // create a stack pane 
      StackPane r = new StackPane(); 
  


        EventHandler<ActionEvent> bevent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                playaudio();
            } 
        }; 

        EventHandler<ActionEvent> cevent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                pauseaudio();
            } 
        }; 

        EventHandler<ActionEvent> devent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                forward();
            } 
        }; 

        EventHandler<ActionEvent> eevent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                backward();
            } 
        }; 

        b.setOnAction(bevent); 
        c.setOnAction(cevent);
        d.setOnAction(devent);
        e.setOnAction(eevent);
        r.getChildren().add(b); 
        r.getChildren().add(c);
        r.getChildren().add(d);
        r.getChildren().add(e);
  
        // create a scene 
        Scene sc = new Scene(r, 200, 200); 
  
        // set the scene 
        s.setScene(sc); 
  
        s.show(); 
    }

    public static void main(String args[]) 
    { 
        String[] paths = { "nat_1.wav" };
        mediaController = new MediaController();
        mediaController.load_paths(paths);
        // launch the application 
        launch(args); 
    } 
}