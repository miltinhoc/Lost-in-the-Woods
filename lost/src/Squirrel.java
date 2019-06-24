import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Squirrel {

    Picture picture;
    Rectangle hitbox;

    public Squirrel(){
        picture = new Picture(40,900-732, "resources/squirrel.png");
        picture.draw();
        hitbox = new Rectangle(picture.getX(), picture.getY(), picture.getWidth(), picture.getHeight());

    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
