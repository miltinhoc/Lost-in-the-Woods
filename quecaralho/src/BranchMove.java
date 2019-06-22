public class BranchMove {
    private int numBranch = 0;
    private Branch[] branch = new Branch[200];

    public void createFirstBranch(){
        branch[numBranch]=new Branch();
        branch[numBranch].show();
    }



    public void move() throws InterruptedException {

        if (branch[numBranch].getCountNextBranch() > 50) {
            numBranch++;
            branch[numBranch] = new Branch();
            branch[numBranch].show();
        }

        for (int i = 0; i <= numBranch; i++) {
            if (branch[i] == null) {
                continue;
            }

            Thread.sleep(5);
            branch[i].gravatiy();
        }

    }
}
