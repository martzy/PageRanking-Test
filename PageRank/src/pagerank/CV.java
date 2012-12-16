/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pagerank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author martzy
 */
class CV {
    int id;
    static int currentid=22;
    float Rank;
    public static int indexCV = 0;
    public int id_cv;
    public int id_user;
    public String nume;
    public  String prenume;
    public String domain;
    public int domain_id;
    public String job;
    public String skils;

    public ArrayList<Experience> experiences;
    public int experience;

    public ArrayList<Language> languages ;
    public String language;

    public ArrayList<Hobby> hobbies;
    public ArrayList<Studies> studies;
    public ArrayList<Skills> skills;


    CV() {
        this.id = ++currentid;
        //this.Rank = (float) Math.sqrt(currentid/2);
        double x = Math.random() * 10;
        this.experience = (int)x;
        if (x > 6)
            degree = "Licenta";
        else if (x < 4)
            degree = "Masterat";
        else
            degree = "Doctorat";
        this.languages = new ArrayList<Language>();
        this.languages.add(new Language("engleza", 1, 2, (int)(x * x / 2)%4 +1));
        this.languages.add(new Language("chineza", 1, 2, (int)(x / 2)%4 +1));
        this.languages.add(new Language("rusa", 1, 2, (int)(x * x * x / 4)%4 +1));
        this.languages.add(new Language("franceza", 1, 2, (int)(x/ 2)%4 + 1));
    }

    int getId() {
        return this.id;
    }

    float getRank() {
        return this.Rank;
    }

    public ArrayList<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public String degree;

    public boolean selected;

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public ArrayList<Skills> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skills> skills) {
		this.skills = skills;
	}

	public ArrayList<Language> getLanguage() {
		return languages;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSkils() {
		return skils;
	}
	public void setSkils(String skils) {
		this.skils = skils;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public void setRank(float rank) {
		this.Rank = rank;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isSelected() {
		return selected;
	}

	static int currentId = 2332;

    public CV(int id_cv, int id_user, String nume,
    		String prenume, String domain, ArrayList<Experience> experiences,
    		ArrayList<Language> languages, ArrayList<Hobby> hobbies, String degree) {
        this.id_cv = id_cv;
        this.id_user = id_user;
        this.nume = nume;
        this.prenume = prenume;
        this.domain = domain;
        this.experiences = experiences;
        this.languages = languages;
        this.hobbies = hobbies;
        this.degree = degree;
    }

    
    public CV(ArrayList<String> a, ArrayList<Experience> experiences,
    		ArrayList<Language> languages, ArrayList<Hobby> hobbies,
    		ArrayList<Studies> studies, ArrayList<Skills> skills){
    	this.id_cv = Integer.parseInt((String)a.get(0));
        this.id_user = Integer.parseInt((String)a.get(1));;
        this.nume = (String)a.get(2);
        this.prenume = (String)a.get(3);
        this.domain_id = Integer.parseInt(a.get(5));
        this.experiences = experiences;
        this.languages = languages;
        this.hobbies = hobbies;
        this.degree = studies.toString();
        this.studies = studies;
        this.skills = skills;
    }
	
}
