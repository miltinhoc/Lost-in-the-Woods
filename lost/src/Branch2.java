import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Branch2 {
    private int speed = 2;
    private Picture branch;
    private Rectangle rect;


    public Rectangle getRect(){return rect;}

    public int getX(){return branch.getX();}

    public int getY(){return branch.getY();}

    public Branch2(int x, int y, String picturePath){
        branch = new Picture(x,y,picturePath);
        branch.draw();
        rect = new Rectangle(x,y,branch.getWidth(),branch.getHeight());

    }
}
