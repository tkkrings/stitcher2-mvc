package stitchr.stitcher2mvc.models;

import java.util.ArrayList;

public class YarnData {

    static ArrayList<Yarn> yarns = new ArrayList<>();

    // get all
    public static ArrayList<Yarn> getAll() {
        return yarns;
    }

    // add
    public static void add(Yarn newYarn) {
        yarns.add(newYarn);
    }

    // remove
    public static void remove(int id) {
        Yarn yarnToRemove = getByID(id);
        yarns.remove(yarnToRemove);
    }

    // getByID
    public static Yarn getByID(int id) {

        Yarn theYarn = null;

        for (Yarn candidateYarn : yarns) {
            if (candidateYarn.getYarnID () == id) {
                theYarn = candidateYarn;
            }
        }

        return theYarn;

    }
}
