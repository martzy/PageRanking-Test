/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pagerank;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;


/**
 *
 * @author win7
 */
public class Studies {
	int id;
    int type;
    public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	String institution;

    public String toString() {
    	return institution;
    }

    public Studies(int id, int type,String institution) {
        this.id = id;
        this.type = type;
        this.institution = institution;
    }

    public Studies(ArrayList<String> s) {
        this.id = Integer.parseInt(s.get(0));
        this.type = Integer.parseInt(s.get(1));
        this.institution = s.get(2);
    }

}

