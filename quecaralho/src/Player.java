import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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

    Player(){
        picture = new Picture(100,100,"resources/elf2.png");
        picture.draw();
        picHeight = picture.getHeight();
        picWidth = picture.getWidth();
        keyboard = new Keyboard(this);
        init();
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

    void left(){
        picture.translate(-1,0);
    }

    void move(){
        picture.translate(0,-2);
        picture.translate(1,0);
    }

    void up(){
        picture.translate(0,-1);
    }

    void down(){
        picture.translate(0,1);
    }

    void right(){
        picture.translate(1,0);
    }

    void moveD(){
        picture.translate(0,2);
        picture.translate(1,0);
    }

    public boolean isJumpLeft() {
        return jumpLeft;
    }

    public void setJumpLeft(boolean jumpLeft) {
        this.jumpLeft = jumpLeft;
    }

    void moveL(){
        picture.translate(0,-2);
        picture.translate(-1,0);
    }

    public boolean isSide() {
        return side;
    }

    void moveDLeft(){
        picture.translate(0,2);
        picture.translate(-1,0);
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
        up.setKey(KeyboardEvent.KEY_D);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        //Jump Left
        KeyboardEvent upLeft = new KeyboardEvent();
        upLeft.setKey(KeyboardEvent.KEY_A);
        upLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spaceUp = new KeyboardEvent();
        spaceUp.setKey(KeyboardEvent.KEY_SPACE);
        spaceUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(leftUp);
        keyboard.addEventListener(rightUp);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(space);
        keyboard.addEventListener(spaceUp);
        keyboard.addEventListener(up);
        keyboard.addEventListener(upLeft);

    }

    void rotateLeft(){
        picture.grow(-picWidth,0);
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    void rotateRight(){
        picture.grow(picWidth,0);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D:
                jump = true;
                break;
            case KeyboardEvent.KEY_A:
                jumpLeft = true;
                break;
            case KeyboardEvent.KEY_SPACE:
                salto = true;
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (side){
                    picture.grow(picWidth,0);
                    side = false;
                }
                right = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                if (!side){
                    picture.grow(-picWidth,0);
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
