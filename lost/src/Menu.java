import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    Keyboard keyboard;
    private boolean startGame;

    public Menu(){
        keyboard = new Keyboard(this);
        Rectangle rectangle = new Rectangle(0,0,600,900);
        rectangle.draw();
        Picture picture = new Picture(0,0,"resources/start_menu.jpg");
        picture.draw();
        init();
    }

    public boolean isStartGame() {
        return startGame;
    }

    private void init(){
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_ENTER);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(keyboardEvent);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_ENTER:
                System.out.println("key pressed");
                startGame = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
