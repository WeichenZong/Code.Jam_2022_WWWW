package Main_P;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
	private class CheckList{
		int min,max,taken;
		String list="";
		public CheckList(int min,int max,String list) {
			this.min=min;
			this.max=max;
			this.list=list;
			this.taken=0;
		}
		public void addTaken(int x) {this.taken+=x;}
	}
	ReadFiles rf=new ReadFiles();
	Queue<String> requirements;
	String[] piece,range;
	CheckList[] PList;
	String[][] CourseTable=new String[20][10];
	int cnt=0,semester=0,totalC=0,reqC,ccnt=0,ycnt=0,scredit=0;
	Graph courseDB;
	ArrayList<Course> PCourses=new ArrayList<Course>();
	static int MIN_CREDIT_PER_SEMESTER=12;
	static int MAX_CREDIT_PER_SEMESTER=17;
	public Program(String x) {
		requirements=rf.readFile(x+".csv");
		PList=new CheckList[requirements.size()];
		reqC=Integer.parseInt(requirements.poll());
		while(!requirements.isEmpty()) {
			String xx=requirements.poll();
			piece=Graph.split(xx,",");
			range=Graph.split(piece[0],"-");
			PList[cnt++]=new CheckList(Integer.parseInt(range[0]),Integer.parseInt(range[range.length-1]),piece[1]);
		}
	}
	public void GenerateTable() {
		Queue<Course> CList=new LinkedList<Course>();
		courseDB=new Graph();
		for(int i=0;i<PList.length;i++) {
			if(PList[i]!=null) {
				String[] courseL=Graph.split(PList[i].list,"|");
				for(int j=0;j<courseL.length;j++) {
					Course tempC=courseDB.searchCourse(courseL[j]);
					if(tempC!=null) PCourses.add(tempC);
					if(tempC!=null&&tempC.getInDegree()==0) CList.add(tempC);
				}
			}
		}
		while(!CList.isEmpty()) {
			Course check=CList.poll();
			if(!check.getChosen()) {
				if(check.getTY().contains((semester%2==0)?"F":"W")&&check.getTY().contains((ycnt%2==0)?"E":"O")&&scredit+check.getCredit()<=MAX_CREDIT_PER_SEMESTER) {
					CourseTable[semester][ccnt++]=check.getName();
					check.setChosen(true);
					Queue<Course> children=courseDB.maintainGraph(check.getName(),semester+1);
					while(!children.isEmpty()) {
						Course kid=children.poll();
						if(PCourses.contains(kid)) CList.add(kid);
					}
					totalC+=check.getCredit();
					scredit+=check.getCredit();
					if(totalC>=reqC) {
						printTable(CourseTable);
						return;
					}
					if(MAX_CREDIT_PER_SEMESTER-scredit<3) {
						semester++;
						if(semester%2==0) ycnt++;
						scredit=0;
						ccnt=0;
					}
				}else CList.add(check);
			}
			int fcnt=0,wcnt=0,thisyr=0;
			for(Iterator<Course> it=CList.iterator();it.hasNext();) {
				Course tc=it.next();
				if(tc.getTY().contains("F")) fcnt++;
				if(tc.getTY().contains("W")) wcnt++;
				if(tc.getYear()==semester) thisyr++;
			}
			if(fcnt==0&&semester%2==0) {
				semester++;
				if(semester%2==0) ycnt++;
				scredit=0;
				ccnt=0;
			}else if(wcnt==0&&semester%2==1) {
				semester++;
				if(semester%2==0) ycnt++;
				scredit=0;
				ccnt=0;
			}else if(thisyr==0) {
				semester++;
				if(semester%2==0) ycnt++;
				scredit=0;
				ccnt=0;
			}
		}
		if(MAX_CREDIT_PER_SEMESTER-scredit<3) {
			semester++;
			if(semester%2==0) ycnt++;
			scredit=0;
			ccnt=0;
		}
		for(int i=0;i<cnt;i++) {
			String[] tempL=Graph.split(PList[i].list,"|");
			for(int j=0;j<tempL.length;j++) {
				if(!courseDB.searchCourseStatus(tempL[j])) {
					PList[i].taken+=courseDB.searchCourseCredit(tempL[j]);
					if(PList[i].taken>=PList[i].min) break;
				}
			}
			if(PList[i].taken<PList[i].min) {
				for(int j=0;j<tempL.length;j++) {
					if(!courseDB.searchCourseStatus(tempL[j])) {
						CourseTable[semester][ccnt]=tempL[j];
						courseDB.setCourseStatus(tempL[j]);
						PList[i].taken+=courseDB.searchCourseCredit(tempL[j]);
						scredit+=courseDB.searchCourseCredit(tempL[j]);
						if(MAX_CREDIT_PER_SEMESTER-scredit<3) {
							semester++;
							if(semester%2==0) ycnt++;
							scredit=0;
							ccnt=0;
						}
						if(PList[i].taken>=PList[i].min) break;
					}
				}
			}
		}
		printTable(CourseTable);
	}
	void printTable(String[][] table) {
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table[i].length;j++) System.out.print(table[i][j]+" ");
			System.out.println();
		}
	}
}
