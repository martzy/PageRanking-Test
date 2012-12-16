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
public class Experience {
    int EXPERIENCE_XML_ID;
    int JOB_XML_ID;
    int period;
    int DOMAIN_XML_ID;
    int ID;
    int role;

    public Experience(int EXPERIENCE_XML_ID, int JOB_XML_ID, int period, int DOMAIN_XML_ID, int ID,int role) {
        this.EXPERIENCE_XML_ID = EXPERIENCE_XML_ID;
        this.JOB_XML_ID = JOB_XML_ID;
        this.period = period;
        this.DOMAIN_XML_ID = DOMAIN_XML_ID;
        this.ID = ID;
        this.role = role;
    }

    public Experience(ArrayList<String> s){
    	EXPERIENCE_XML_ID = Integer.parseInt(s.get(0));
        this.JOB_XML_ID = Integer.parseInt(s.get(1));
        this.period = Integer.parseInt(s.get(2));
        this.DOMAIN_XML_ID = Integer.parseInt(s.get(3));
        this.ID = Integer.parseInt(s.get(4));
        this.role = Integer.parseInt(s.get(5));
    }

}
