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
public class Language {
    String name;
    int id;
    int rol;
    int level;

    public String getName() {
    	return name;
    }

    public String toString() {
    	switch(this.level){
    	case 1:
    		return name+" "+"incepator";
    	case 2:
    		return name+" "+"mediu";
    	case 3:
    		return name+" "+"avansat";
    	case 4:
    		return name+" "+"expert";
    	default:
    		return name+" "+"-";
    	}

    }


    public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Language(String LANGUAGE_XML_ID, int id, int rol, int level) {
        this.name = LANGUAGE_XML_ID;
        this.id = id;
        this.rol = rol;
        this.level = level;
    }

    public Language(ArrayList<String> s) {
        this.name =  s.get(0);
        this.id = Integer.parseInt(s.get(1));
        this.rol = Integer.parseInt(s.get(2));
        this.level = Integer.parseInt(s.get(3));
    }
}
