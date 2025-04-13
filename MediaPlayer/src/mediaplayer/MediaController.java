package mediaplayer;

import java.util.Arrays;

/**
 * Manages a playlist of audio files using a MediaPlayer.
 * Provides methods for loading, adding, and playing audio paths.
 */
public class MediaController {

    private MediaPlayer mediaPlayer;
    public String[] paths;

    /**
     * Constructs a MediaController and initializes a MediaPlayer.
     */
    public MediaController() {
        mediaPlayer = new MediaPlayer();
    }

    /**
     * Loads an array of audio file paths into the controller's playlist.
     *
     * @param paths An array of String paths to audio files.
     */
    public void load_paths(String[] paths) {
        this.paths = paths;
    }

    /**
     * Adds a single audio file path to the controller's playlist.
     *
     * @param path The String path to the audio file to add.
     */
    public void add_path(String path) {
        this.paths = addStringToArray(this.paths, path);
    }

    /**
     * Plays all audio files in the playlist sequentially.
     * Loads and plays each file with a 10-second delay between tracks.
     * If the playlist is empty or null, an error message is printed.
     */
    public void play_through() {
        if (this.paths != null) {
            for (int i = 0; i < this.paths.length; i++) {
                mediaPlayer.load(this.paths[i]);
                mediaPlayer.play();
                try {
                    Thread.sleep(10000); // 10 second delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("No paths loaded. Call load_paths() first.");
        }
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void fast_forward() {
        mediaPlayer.fast_forward();
    }

    public void fast_backward() {
        mediaPlayer.fast_backward();
    }
    
    /**
     * Adds a String to a String array, returning a new array with the added element.
     *
     * @param originalArray The original String array.
     * @param newString     The String to add to the array.
     * @return A new String array with the added element, or a new array containing
     * only the new String if the original array is null.
     */
    private static String[] addStringToArray(String[] originalArray, String newString) {
        if (originalArray == null) {
            return new String[] {newString};
        }

        String[] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);
        newArray[originalArray.length] = newString;
        return newArray;
    }
}