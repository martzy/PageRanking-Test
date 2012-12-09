/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pagerank;

/**
 *
 * @author martzy
 */
class CV {
    int id;
    static int currentid=22;
    float Rank;

    CV() {
        this.id = ++currentid;
        this.Rank = (float) Math.sqrt(currentid/2);
    }

    int getId() {
        return this.id;
    }

    float getRank() {
        return this.Rank;
    }
}
