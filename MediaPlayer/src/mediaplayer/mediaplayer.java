package mediaplayer;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * A simple audio player class that uses the Java Sound API to play WAV files.
 * Provides basic playback control, including loading, playing, stopping,
 * fast-forwarding, fast-backwarding, and volume adjustment.
 */
public class MediaPlayer {

    private Clip audioClip;
    // private FloatControl gainControl;
    // private float volMax;
    // private float volMin;
    // private float volume;

    /**
     * Loads an audio file from the specified file path.
     *
     * @param filePath The path to the audio file (WAV).
     */
    public void load(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
            // volMax = gainControl.getMaximum();
            // volMin = gainControl.getMinimum();
            // setVolume((float) 20.0); // Force to float, initial volume setting.
        } catch (Exception e) {
            System.err.println("Error loading audio: " + e.getMessage());
            e.printStackTrace();
            audioClip = null;
        }
    }

    /**
     * Starts playing the loaded audio file from the beginning.
     * If no audio is loaded, an error message is printed.
     */
    public void play() {
        if (audioClip != null) {
            audioClip.setFramePosition(0);
            audioClip.start();
        } else {
            System.err.println("Audio not loaded. Call load() first.");
        }
    }

    /**
     * Stops the currently playing audio file.
     * If no audio is loaded, an error message is printed.
     */
    public void stop() {
        if (audioClip != null) {
            audioClip.stop();
        } else {
            System.err.println("Audio not loaded. Call load() first.");
        }
    }

    /**
     * Fast-forwards the audio playback by 10 frames.
     * If no audio is loaded, an error message is printed.
     */
    public void fast_forward() {
        if (audioClip != null) {
            int frame_position = audioClip.getFramePosition();
            audioClip.setFramePosition(frame_position += 10);
        } else {
            System.err.println("Audio not loaded. Call load() first.");
        }
    }

    /**
     * Fast-backwards the audio playback by 10 frames.
     * If no audio is loaded, an error message is printed.
     */
    public void fast_backward() {
        if (audioClip != null) {
            int frame_position = audioClip.getFramePosition();
            audioClip.setFramePosition(frame_position -= 10);
        } else {
            System.err.println("Audio not loaded. Call load() first.");
        }
    }

    /**
     * Sets the volume of the audio playback.
     *
     * @param n_volume The desired volume level.
     */
    public void setVolume(float n_volume) {
        // if (audioClip != null && gainControl != null) {
        //     volume = ((volMax - volMin) * n_volume + volMin);
        //     gainControl.setValue((float) volume); // Set the volume, force to float
        // }
    }
}