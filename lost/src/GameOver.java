import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver {

    public GameOver(String imagePath){

        Rectangle rectangle = new Rectangle(0,0,600,900);
        rectangle.draw();
        Picture picture = new Picture(0,0, imagePath);
        picture.draw();
        init();
    }


    public void init(){
        Music music = new Music();
        music.startMusic("resources/gameover.wav");
    }

}
