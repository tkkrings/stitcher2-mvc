package stitchr.stitcher2mvc.models;

public class Yarn {

    private String name;
    private String colorway;
    private String weight;
    private String details;
    private String projects;

    private int yarnID;

    private static int nextID = 1;

    public Yarn(String name, String colorway, String weight, String details, String projects) {
        this();
        this.name = name;
        this.colorway = colorway;
        this.weight = weight;
        this.details = details;
        this.projects = projects;
    }

    public Yarn() {
        yarnID = nextID;
        nextID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorway() {
        return colorway;
    }

    public void setColorway(String colorway) {
        this.colorway = colorway;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public int getYarnID() {
        return yarnID;
    }

    public void setYarnID(int yarnID) {
        this.yarnID = yarnID;
    }
}
