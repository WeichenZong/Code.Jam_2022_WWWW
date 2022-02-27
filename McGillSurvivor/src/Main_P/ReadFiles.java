package Main_P;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class ReadFiles {
	String db="E:\\Things\\codejam\\Code.Jam_2022_WWWW\\DataBase\\";
	BufferedReader br=null;
	String line="";
	String split=",";
	public Queue<String> readFile(String x) {
		Queue<String> courses=new LinkedList<String>();
		try {
			br=new BufferedReader(new FileReader(db+x));
			while((line=br.readLine())!=null) courses.add(line);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null) {
				try {
					br.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return courses;
	}
}
