package mediaplayer;

import java.util.Arrays;

public class MediaController {

    private MediaPlayer mediaPlayer;
    public String[] paths;

    public MediaController() {
        mediaPlayer = new MediaPlayer();
    }

    public void load_paths(String[] paths) {
        this.paths = paths;
    }

    public void add_path(String path) {
        this.paths = addStringToArray(this.paths, path);
    }

    public void play_through() {
        if (this.paths != null) {
            for (int i = 0; i < this.paths.length; i++) { // Corrected loop condition
                mediaPlayer.load(this.paths[i]);
                mediaPlayer.play();
                // Add a small delay between tracks if needed.
                try {
                    Thread.sleep(10000); // 1 second delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("No paths loaded. Call load_paths() first.");
        }
    }

    private static String[] addStringToArray(String[] originalArray, String newString) {
        if (originalArray == null) {
            return new String[] {newString};
        }

        String[] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);
        newArray[originalArray.length] = newString;
        return newArray;
    }
}