import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private final static int THRESHOLD = 900;
    private Menu menu;

    Game() {
        menu = new Menu();
        gamestart();
        Rectangle rectangle = new Rectangle(0, 0, 600, 900);
        rectangle.draw();
        Picture background = new Picture(0, 0, "background.jpg");
        background.draw();

    }


    public void gamestart(){
        Music music = new Music();
        music.startMusic("resources/menu.wav");

        while (!menu.isStartGame()){
            try {
                Thread.sleep(10);
            }catch (InterruptedException ex){

            }

            if (menu.isStartGame()){
                //System.out.println(menu.isStartGame());
                music.stop();
                return;
            }
        }
    }

    public void start() throws InterruptedException {


        Music music = new Music();

        music.startMusic("resources/game.wav");

        LevelFactory fac = new LevelFactory();
        Branch2[] branch2s = fac.getNewLevel();
        Squirrel squirrel = new Squirrel();
        PlayerThread playerThread = new PlayerThread(branch2s, squirrel);
        player = new Player();

        ColisionDetecter colisionDetecter = new ColisionDetecter(player, branch2s, squirrel);


        playerThread.start();

        while (!player.isPlayerWon()) {
            if (player.isPlayerWon()){
                return;
            }
            while (colisionDetecter.checkColision() == false) {
                if (player.getY() >= 820) {
                    break;
                }
                Thread.sleep(5);
                player.continuousFall();
            }
            Thread.sleep(10);
            if (player.isJump()) {
                if (player.isSide()) {
                    player.setSide(false);
                }
                for (int i = 0; i < 50; i++) {
                    if (colisionDetecter.checkColision() && player.isFall()) {
                        player.setX(player.getX());
                    }
                    Thread.sleep(5);
                    player.move();
                }

                for (int i = 0; i <50; i++) {
                    if (colisionDetecter.checkColision() && player.isFall()) {
                        player.setX(player.getX());
                        break;
                    }
                    Thread.sleep(5);
                    player.moveD();
                }
                player.setJump(false);
            }

            if (player.isLeft()) {
                while (player.isLeft()) {
                    if (colisionDetecter.checkColision() && player.isFall()) {
                        player.setX(player.getX());
                    }
                    player.left();
                    Thread.sleep(9);
                }
            }

            if (player.isRight()) {
                while (player.isRight()) {
                    if (colisionDetecter.checkColision() && player.isFall()) {
                        player.setX(player.getX());
                    }
                    player.right();
                    Thread.sleep(9);
                }
            }

            if (player.isJumpLeft()) {
                if (!player.isSide()) {
                    player.setSide(true);
                }
                for (int i = 0; i < 50; i++) {
                    if (colisionDetecter.checkColision() && player.isFall()) {
                        player.setX(player.getX());
                    }
                    Thread.sleep(5);
                    player.moveL();
                }

                for (int i = 0; i < 50; i++) {
                    if (colisionDetecter.checkColision() && player.isFall()) {
                        player.setX(player.getX());
                        break;
                    }
                    Thread.sleep(5);
                    player.moveDLeft();
                }
                player.setJumpLeft(false);
            }

        }
        music.stop();
    }


    //game over
}