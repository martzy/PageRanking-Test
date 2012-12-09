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
    static ArrayList<CV> CVss;
    static int nrCV;

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

}
