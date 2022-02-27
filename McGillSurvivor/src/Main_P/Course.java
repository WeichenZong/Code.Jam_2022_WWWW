package Main_P;

import java.util.ArrayList;

public class Course {
	String name="",TY="";
	int credit=0,level=0,inD=0,year;
	boolean chosen;
	ArrayList<String> restriction=new ArrayList<String>();
	ArrayList<String> prereq=new ArrayList<String>();
	public Course(String name,String level,String credit,String TY,String restriction) {
		if(name!=null) this.name=name;
		if(level!=null) this.level=Integer.parseInt(level);
		if(credit!=null) this.credit=Integer.parseInt(credit);
		if(TY!=null) this.TY=TY;
		this.chosen=false;
		this.year=0;
		if(restriction!=null) {
			String[] ts=restriction.split("/");
			for(int i=0;i<ts.length;i++) this.restriction.add(ts[i]);
		}
	}
	void setName(String name) {this.name=name;return;}
	void setTY(String TY) {this.TY=TY;return;}
	void setCredit(String credit) {this.credit=Integer.parseInt(credit);return;}
	void setLevel(String level) {this.level=Integer.parseInt(level);return;}
	void setRestriction(String restriction) {
		if(restriction!=null) {
			String[] ts=restriction.split("/");
			for(int i=0;i<ts.length;i++) this.restriction.add(ts[i]);
		}
		return;
	}
	void setPre(String pre) {if(prereq.indexOf(pre)==-1) prereq.add(pre);return;}
	void addInDegree(int x) {this.inD+=x;}
	void setChosen(boolean chosen) {this.chosen=chosen;return;}
	void setYear(int year) {this.year=year;}
	String getName() {return this.name;}
	String getTY() {return this.TY;}
	int getCredit() {return this.credit;}
	int getLevel() {return this.level;}
	ArrayList<String> getRestriction() {return this.restriction;}
	int getHash() {return name.hashCode();}
	boolean getChosen() {return this.chosen;}
	int getInDegree() {return this.inD;}
	int getYear() {return year;}
	public String toString() {
		String res="";
		res+=name+" ";
		res+=TY+"\n"+"Preq: ";
		for(int i=0;i<prereq.size();i++) res+=prereq.get(i)+" ";
		res+="\n";
		return res;
	}
	boolean findAsPreq(String name) {
		if(prereq==null||prereq.size()==0||inD<=0) return false;
		for(int i=0;i<prereq.size();i++) {
			if(prereq.get(i).contains(name)) {
				prereq.remove(i);
				return true;
			}
		}
		return false;
	}
}
