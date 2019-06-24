public class PlayerThread extends Thread{

    private ColisionDetecter colisionDetecter;
    private Player2 player2;
    private Branch2[] branch2s;
    private Squirrel squirrel;

    public PlayerThread(Branch2[] branch2s, Squirrel squirrel){
        this.branch2s = branch2s;
        this.squirrel = squirrel;
    }

    public void setSquirrel(Squirrel squirrel) {
        this.squirrel = squirrel;
    }

    public Player2 getPlayer2() {
        return player2;
    }

    @Override
    public void run() {
        player2 = new Player2();

        ColisionDetecter colisionDetecter = new ColisionDetecter(player2, branch2s, squirrel);
        while (!player2.isPlayerWon()){
            try {
                Thread.sleep(10);
            }catch (InterruptedException ex){

            }

            while (!colisionDetecter.checkColision()) {
                if (player2.getY() >= 820) {
                    break;
                }
                try {
                    Thread.sleep(5);
                }catch (InterruptedException ex){

                }

                player2.continuousFall();
            }
            try {
                Thread.sleep(10);
            }catch (InterruptedException ex){

            }
            if (player2.isJump()) {
                if (player2.isSide()) {
                    player2.setSide(false);
                }
                for (int i = 0; i < 50; i++) {
                    if (colisionDetecter.checkColision() && player2.isFall()) {
                        player2.setX(player2.getX());
                    }
                    try {
                        Thread.sleep(5);
                    }catch (InterruptedException ex){

                    }
                    player2.move();
                }

                for (int i = 0; i < 50; i++) {
                    if (colisionDetecter.checkColision() && player2.isFall()) {
                        player2.setX(player2.getX());
                        break;
                    }
                    try {
                        Thread.sleep(5);
                    }catch (InterruptedException ex){

                    }
                    player2.moveD();
                }
                player2.setJump(false);
            }

            if (player2.isLeft()) {
                while (player2.isLeft()) {
                    if (colisionDetecter.checkColision() && player2.isFall()) {
                        player2.setX(player2.getX());
                    }
                    player2.left();
                    try {
                        Thread.sleep(9);
                    }catch (InterruptedException ex){

                    }
                }
            }

            if (player2.isRight()) {
                while (player2.isRight()) {
                    if (colisionDetecter.checkColision() && player2.isFall()) {
                        player2.setX(player2.getX());
                    }
                    player2.right();
                    try {
                        Thread.sleep(9);
                    }catch (InterruptedException ex){

                    }
                }
            }

            if (player2.isJumpLeft()) {
                if (!player2.isSide()) {
                    player2.setSide(true);
                }
                for (int i = 0; i < 50; i++) {
                    if (colisionDetecter.checkColision() && player2.isFall()) {
                        player2.setX(player2.getX());
                    }
                    try {
                        Thread.sleep(5);
                    }catch (InterruptedException ex){

                    }
                    player2.moveL();
                }

                for (int i = 0; i < 50; i++) {
                    if (colisionDetecter.checkColision() && player2.isFall()) {
                        player2.setX(player2.getX());
                        break;
                    }
                    try {
                        Thread.sleep(5);
                    }catch (InterruptedException ex){

                    }
                    player2.moveDLeft();
                }
                player2.setJumpLeft(false);
            }
        }

    }

}
