package Main_P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph {
	int cnt=0,linecnt=0;
	int[] ne;
	String lastCourse="";
	Queue<String> infos;
	Course[] courses;
	Map<String,Integer> CourseDict=new HashMap<String,Integer>(); 
	private class Edge{
		int from,to,next;
		public Edge(int from,int to,int cnt) {
			this.from=from;
			this.to=to;
			this.next=ne[from];
			ne[from]=cnt;
		}
	}
	Edge[] edge;
	static String[] split(String origin,String regex) {
		String temp="";
		String[] output;
		ArrayList<String> res=new ArrayList<String>();
		for(int i=0;i<origin.length();i++) {
			if(regex.indexOf(origin.charAt(i))!=-1) {
				res.add(temp);
				temp="";
				continue;
			}
			temp+=origin.charAt(i);
		}
		res.add(temp);
		output=new String[res.size()];
		for(int i=0;i<res.size();i++) {
			String t=res.get(i);
			if(t=="") output[i]=null;
			else output[i]=t;
		}
		return output;
	}
	public Graph() {
		ReadFiles rf=new ReadFiles();
		infos=rf.readFile("Course List - Sheet1.csv");
		ne=new int[2*infos.size()+5];
		edge=new Edge[2*infos.size()+5];
		courses=new Course[2*infos.size()+5];
		infos.poll();
		while(!infos.isEmpty()) {
			String[] temp=split(infos.poll(),",");
			if(temp[0]!=null) lastCourse=temp[0];
			if(!CourseDict.containsKey(lastCourse)) {
				courses[cnt]=new Course(lastCourse,temp[1],temp[2],temp[3],temp[6]);
				CourseDict.put(lastCourse,cnt++);
			}else if(courses[CourseDict.get(lastCourse)]==null) courses[CourseDict.get(lastCourse)]=new Course(lastCourse,temp[1],temp[2],temp[3],temp[6]);
			if(temp[4]!=null) {
				String[] preq=split(temp[4],"|");
				for(int i=0;i<preq.length;i++) {
					if(!CourseDict.containsKey(preq[i])) CourseDict.put(preq[i],cnt);
					edge[linecnt]=new Edge(CourseDict.get(preq[i]).intValue(),CourseDict.get(lastCourse).intValue(),linecnt);
					courses[CourseDict.get(lastCourse)].setPre(preq[i]);
					linecnt++;cnt++;
				}
				courses[CourseDict.get(lastCourse)].addInDegree(1);
			}
		}
	}
	Course searchCourse(String name) {
		Integer index=CourseDict.get(name);
		if(index!=null) return courses[CourseDict.get(name)];
		return null;
	}
	int searchCourseIndex(String name) {return CourseDict.get(name);}
	Queue<Course> maintainGraph(String name,int yr) {
		Queue<Course> res=new LinkedList<Course>();
		for(int i=ne.length-1;i>=0;i--) {
			if(edge[ne[i]].from==searchCourseIndex(name)) {
				for(int j=ne[i];j!=0;j=edge[j].next) {
					int index=edge[j].to;
					if(courses[index].findAsPreq(courses[edge[j].from].getName())) {
						courses[index].inD--;
						courses[index].setYear(yr);
						if(courses[index].inD<=0) res.add(courses[index]);
					}
				}
				return res;
			}
		}
		return res;
	}
	boolean searchCourseStatus(String name) {
		Integer index=CourseDict.get(name);
		return index==null||courses[index].getChosen();
	}
	int searchCourseCredit(String name) {return courses[CourseDict.get(name)].getCredit();}
	void setCourseStatus(String name) {courses[CourseDict.get(name)].setChosen(true);}
	void viewCourses() {for(int i=0;i<cnt;i++) if(courses[i]!=null) System.out.print(courses[i].toString());}
}
