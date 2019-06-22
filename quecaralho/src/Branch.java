import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Branch {
    private int col;
    private int branchTouch = 30;
    private Picture branch;
    private int countNextBranch = 0;


    public Branch() {
        col = (int) (Math.random() * 600);
        branch = new Picture(col,   10, "resources/branch.png");
    }

    public int getCountNextBranch(){return countNextBranch;}


    public void gravatiy(){
        if (countNextBranch >= 51){
            countNextBranch = 0;
        }
        if (branch.getX() >= 600){
            branch.delete();
            countNextBranch ++;
        }
        countNextBranch ++;
        branchTouch += 30;
        branch.translate(0,3);
    }

    public void show(){branch.draw();}
}
