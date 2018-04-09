package stitchr.stitcher2mvc.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Yarn {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, message = "You must provide a name for your yarn")
    private String name;

    private String colorway;
    private String weight;
    private String details;
    private String projects;

    public Yarn(String name, String colorway, String weight, String details, String projects) {
        this.name = name;
        this.colorway = colorway;
        this.weight = weight;
        this.details = details;
        this.projects = projects;
    }

    public Yarn() { }

    public int getId() {
        return id;
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

}
