/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pagerank;

import java.util.ArrayList;

/**
 *
 * @author martzy
 */
public class Database {
    public static Database Instance = new  Database();
    static ArrayList<CV> CVss;
    private static int nrCV = 0;

    Database() {
        CVss = new ArrayList<CV>();
        CVss.add(new CV());
        nrCV++;
        CVss.add(new CV());
        nrCV++;
        CVss.add(new CV());
        nrCV++;
        CVss.add(new CV());
        nrCV++;
        CVss.add(new CV());
        nrCV++;
        CVss.add(new CV());
        nrCV++;
        CVss.add(new CV());
        nrCV++;
        CVss.add(new CV());
        nrCV++;
        CVss.add(new CV());
        nrCV++;
    }

    static ArrayList<CV> getAllCVs() {
        return CVss;
    }

    static int getNumberofCVs() {
        return nrCV;
    }

    CV getCV(int id_cv) {
        for(int i = 0; i < CVss.size(); i++)
            if (CVss.get(i).getId() == id_cv)
                return CVss.get(i);

        System.out.println("eroare");
        return new CV();
    }

}
