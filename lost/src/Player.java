import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Player implements KeyboardHandler {

    private boolean jump;
    private Picture picture;
    private Keyboard keyboard;
    private boolean salto;
    private boolean right;
    private boolean left;
    private boolean side;
    private int picWidth;
    private boolean jumpLeft;
    private int picHeight;
    private int x, y;
    private Rectangle rect;
    private boolean fall;
    private ColisionDetecter colisionDetecter;
    private boolean playerWon;

    private final static int HORIZONTAL_SPEED = 4;
    private final static int VERTICAL_SPEED = 3;

    Player() {
        picture = new Picture(300, 900 - 78, "elfeR.png");
        picture.draw();
        picHeight = picture.getHeight();
        picWidth = picture.getWidth();
        keyboard = new Keyboard(this);
        this.x = picture.getX();
        this.y = picture.getY();
        rect = new Rectangle(getX(), getY(), picWidth, picHeight);
        init();

    }

    public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }

    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public void setX(int i){this.x = i;}

    public void setY(int y) {
        this.y = y;
    }

    public boolean isFall() {
        return fall;
    }

    public Rectangle getRect() {
        return rect;
    }

    public int getPicWidth() {
        return picWidth;
    }

    public int getPicHeight() {
        return picHeight;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isSalto() {
        return salto;
    }

    public void setSalto(boolean salto) {
        this.salto = salto;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public boolean isJump() {
        return jump;
    }

    public void continuousFall(){
        rect.translate(0,VERTICAL_SPEED);
        picture.translate(0,VERTICAL_SPEED);}


    void left() {
        rect.translate(-HORIZONTAL_SPEED, 0);
        picture.translate(-HORIZONTAL_SPEED, 0);
    }

    void move() {
        fall = false;
        rect.translate(0, -VERTICAL_SPEED);
        rect.translate(HORIZONTAL_SPEED, 0);
        picture.translate(0, -VERTICAL_SPEED);

        picture.translate(HORIZONTAL_SPEED, 0);
    }

    void up() {
        rect.translate(0, -VERTICAL_SPEED);
        picture.translate(0, -VERTICAL_SPEED);
    }

    void down() {
        fall = true;
        rect.translate(0, VERTICAL_SPEED);
        picture.translate(0, VERTICAL_SPEED);
    }

    void right() {
        rect.translate(HORIZONTAL_SPEED, 0);
        picture.translate(HORIZONTAL_SPEED, 0);
    }

    void moveD() {
        fall = true;
        rect.translate(0, VERTICAL_SPEED);
        rect.translate(HORIZONTAL_SPEED, 0);
        picture.translate(0, VERTICAL_SPEED);
        picture.translate(HORIZONTAL_SPEED, 0);
    }

    public boolean isJumpLeft() {
        return jumpLeft;
    }

    public void setJumpLeft(boolean jumpLeft) {
        this.jumpLeft = jumpLeft;
    }

    void moveL() {
        rect.translate(0, -VERTICAL_SPEED);
        rect.translate(-HORIZONTAL_SPEED, 0);
        picture.translate(0, -VERTICAL_SPEED);
        picture.translate(-HORIZONTAL_SPEED, 0);
    }

    public boolean isSide() {
        return side;
    }

    void moveDLeft() {
        fall = true;
        rect.translate(0, VERTICAL_SPEED);
        rect.translate(-HORIZONTAL_SPEED, 0);
        picture.translate(0, VERTICAL_SPEED);
        picture.translate(-HORIZONTAL_SPEED, 0);
    }

    public void init() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftUp = new KeyboardEvent();
        leftUp.setKey(KeyboardEvent.KEY_LEFT);
        leftUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightUp = new KeyboardEvent();
        rightUp.setKey(KeyboardEvent.KEY_RIGHT);
        rightUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        // Jump Right
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        keyboard.addEventListener(leftUp);
        keyboard.addEventListener(rightUp);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);

        keyboard.addEventListener(up);
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (!side){
                    jump = true;
                    break;
                }
                jumpLeft = true;
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (side) {
                    picture.load("elfeR.png");
                    side = false;
                }
                right = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                if (!side) {
                    picture.load("elfeL.png");
                    side = true;
                }
                left = true;
                //gg
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key) {
            case 37:
                this.left = false;
                break;
            case 39:
                this.right = false;
                break;
            case 32:
                this.salto = false;
        }
    }
}
