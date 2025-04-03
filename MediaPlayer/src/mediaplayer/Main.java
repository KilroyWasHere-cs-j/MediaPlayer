package mediaplayer;

public class Main {
    public static void main(String[] args) {
        String[] paths = { "nat_1.wav" };
        MediaController mediaController = new MediaController();
        mediaController.load_paths(paths);
        if (mediaController.paths.length <= 1) {
            System.out.print("Playing through audio");
            mediaController.play_through();
        } else {
            System.err.println("No audio loaded");
        }
    }
}