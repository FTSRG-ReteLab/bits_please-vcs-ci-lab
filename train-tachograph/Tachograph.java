import com.google.common.collect.Table;

public class Tachograph {
	Table<Integer, Integer, Integer> coll=new Table<Integer, Integer, Integer>();
	
	public void record(int time, int pos, int speed){
		coll.add(time, pos, speed);
	}

}
