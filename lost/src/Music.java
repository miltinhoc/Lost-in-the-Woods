import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


// Change this class to your liking, this is just a base example

public class Music {

    private Clip clip;

    public void stop(){
        clip.stop();
    }

    public void startMusic(String musicPath) {
        //String pathStr = "resources/menu.wav";
        String pathStr = musicPath;
        URL soundURL;
        AudioInputStream audioInputStream = null;
        try {
            soundURL = Main.class.getResource(pathStr);
            if (soundURL == null) {
                File file = new File(pathStr);
                soundURL = file.toURI().toURL();
            }
            audioInputStream = AudioSystem.getAudioInputStream(soundURL);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
