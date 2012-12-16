/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pagerank;

import java.util.ArrayList;

/**
 *
 * @author win7
 */
public class Hobby {
    int id_cv;
    int HOBBY_XML_ID;

    public Hobby(int id_cv,int HOBBY_XML_ID){
    	this.id_cv = id_cv;
    	this.HOBBY_XML_ID = HOBBY_XML_ID;
    }

    public Hobby(ArrayList<String> s){
    	this.id_cv = Integer.parseInt(s.get(0));
    	this.HOBBY_XML_ID = Integer.parseInt(s.get(1));
    }
}

