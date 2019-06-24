import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Player2 implements KeyboardHandler {

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
    private final static int HORIZONTAL_SPEED = 4;
    private final static int VERTICAL_SPEED = 3;
    private boolean playerWon;

    Player2(){
        picture = new Picture(100,900-78,"elf2.png");
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
    private void init() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftUp = new KeyboardEvent();
        leftUp.setKey(KeyboardEvent.KEY_A);
        leftUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightUp = new KeyboardEvent();
        rightUp.setKey(KeyboardEvent.KEY_D);
        rightUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        // BigJump
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(leftUp);
        keyboard.addEventListener(rightUp);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
    }


    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    void playeyActions(){

        try {
            Thread.sleep(10);
        }catch (InterruptedException ex){

        }
        if (isJump()){
            if (isSide()){
                rotateRight();
                setSide(false);

            }
            for (int i=0;i<50;i++){
                try {
                    Thread.sleep(5);
                }catch (InterruptedException ex){

                }
                move();
            }

            for (int i=0;i<50;i++){
                try {
                    Thread.sleep(5);
                }catch (InterruptedException ex){

                }
                moveD();
            }
            setJump(false);
        }

        if (isLeft()){

            while (isLeft()){
                left();
                try {
                    Thread.sleep(5);
                }catch (InterruptedException ex){

                }
            }
        }

        if (isRight()){
            while (isRight()){
                right();
                try {
                    Thread.sleep(5);
                }catch (InterruptedException ex){

                }
            }
        }

        if (isJumpLeft()){
            if (!isSide()){
                rotateLeft();
                setSide(true);
            }
            for (int i=0;i<50;i++){
                try {
                    Thread.sleep(5);
                }catch (InterruptedException ex){

                }
                moveL();
            }

            for (int i=0;i<50;i++){
                try {
                    Thread.sleep(5);
                }catch (InterruptedException ex){

                }
                moveDLeft();
            }

            setJumpLeft(false);
        }
    }

    private void rotateLeft(){
        picture.load("elf2L.png");
    }

    private void rotateRight(){
        picture.load("elf2.png");
    }

    public void setSide(boolean side) {
        this.side = side;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                if (!side){
                    jump = true;
                    break;
                }
                jumpLeft = true;
                break;
            case KeyboardEvent.KEY_D:
                if (side){
                    picture.load("resources/elf2.png");
                    side = false;
                }
                right = true;
                break;
            case KeyboardEvent.KEY_A:
                if (!side){
                    picture.load("resources/elf2L.png");
                    side = true;
                }
                left = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key){
            case 65:
                this.left = false;
                break;
            case 68:
                this.right = false;
                break;
            case 32:
                this.salto = false;
        }
    }
}
