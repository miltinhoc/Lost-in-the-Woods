import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    BranchMove branchMove = new BranchMove();
    private Player player;

    Game(){
        Rectangle rectangle = new Rectangle(0,0,600,900);
        rectangle.draw();
        Picture background = new Picture(0,0,"resources/background.png");
        background.draw();
    }

    public void start() throws InterruptedException {
        player = new Player();
        branchMove.createFirstBranch();
        while (true){
            branchMove.move();
            Thread.sleep(10);
            if (player.isJump()){
                if (player.isSide()){
                    player.rotateRight();
                    player.setSide(false);

                }
                for (int i=0;i<50;i++){
                    Thread.sleep(5);
                    player.move();
                }

                for (int i=0;i<50;i++){
                    Thread.sleep(5);
                    player.moveD();
                }
                player.setJump(false);
            }

            if (player.isSalto()){
                for (int i=0;i<70;i++){
                    Thread.sleep(5);
                    player.up();
                }

                for (int i=0;i<70;i++){
                    Thread.sleep(5);
                    player.down();
                }
                player.setSalto(false);
            }

            if (player.isLeft()){

                while (player.isLeft()){
                    player.left();
                    Thread.sleep(9);
                }
            }

            if (player.isRight()){
                while (player.isRight()){
                    player.right();
                    Thread.sleep(9);
                }
            }

            if (player.isJumpLeft()){
                if (!player.isSide()){
                    player.rotateLeft();
                    player.setSide(true);
                }
                for (int i=0;i<50;i++){
                    Thread.sleep(5);
                    player.moveL();
                }

                for (int i=0;i<50;i++){
                    Thread.sleep(5);
                    player.moveDLeft();
                }

                player.setJumpLeft(false);
            }

        }
    }
}
