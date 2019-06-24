import gameobjects.BranchType;

public class LevelFactory {
    private static Branch2[] branch2s;

    public static Branch2[] getBranch2s() {
        return branch2s;
    }

    public Branch2[] getNewLevel() {
        branch2s = new Branch2[7];
        for (int i = 0; i < 1; i++) {

            branch2s[0] = new Branch2(0, 900-80,"resources/branchL.png");
            branch2s[1] = new Branch2(600-176, 900-210,"resources/branchR.png");
            branch2s[2] = new Branch2(0, 900-300, "resources/branchL.png");
            branch2s[3] = new Branch2(600-176, 900-400, "resources/branchR.png");
            branch2s[4] = new Branch2(20, 900-500, "resources/branchM.png");
            branch2s[5] = new Branch2(600-176, 900-600, "resources/branchR.png");
            branch2s[6] = new Branch2(0, 900-700, "resources/branchL.png");

        }

        return branch2s;

    }


}
