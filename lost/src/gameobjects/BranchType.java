package gameobjects;

public enum BranchType {
    LEFT("branchL.png"),
    RIGHT("branchR.png"),
    MIDDLE("branchM.png");

    private String imagePath;

    BranchType(String imagePath){
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
