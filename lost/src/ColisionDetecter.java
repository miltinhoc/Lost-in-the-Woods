import java.awt.*;

public class ColisionDetecter {
    private Player player;
    private Player2 player2;
    private LevelFactory fac;
    private Branch2[] branch2s;
    private Rectangle rectPlayer;
    private Rectangle rectBranch;
    private Squirrel squirrel;

    public ColisionDetecter(Player player, Branch2[] branch2s, Squirrel squirrel) {
        this.player = player;
        this.branch2s = branch2s;
        this.squirrel = squirrel;
    }

    public ColisionDetecter(Player2 player2, Branch2[] branch2s, Squirrel squirrel){
        this.player2 = player2;
        this.branch2s = branch2s;
        this.squirrel = squirrel;
    }

    public boolean checkColision() {

        if (player != null){
            if (player.getRect().intersects(squirrel.getHitbox())){
                player.setPlayerWon(true);
                GameOver gameOver = new GameOver("resources/gameover1.png");

            }

            for (int i = 0; i < branch2s.length; i++) {

                if (player.getRect().intersects(branch2s[i].getRect())) {
                    if (player.isFall()) {
                        player.setX(branch2s[i].getX());
                        return true;
                    }
                }
            }
            return false;
        }

        if (player2 != null){
            if (player2.getRect().intersects(squirrel.getHitbox())){
                player2.setPlayerWon(true);
                GameOver gameOver = new GameOver("resources/gameover2.png");
            }
            for (int i = 0; i < branch2s.length; i++) {

                if (player2.getRect().intersects(branch2s[i].getRect())) {
                    if (player2.isFall()) {
                        player2.setX(branch2s[i].getX());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}