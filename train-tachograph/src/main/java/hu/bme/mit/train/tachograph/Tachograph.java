package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;

public class Tachograph {
	Table<Integer, Integer, Integer> coll=ArrayTable.create(null);
	
	public void record(long time, int pos, int speed){
		coll.put((int)time, pos, speed);
	}
	
	public int getSize(){
		return coll.size();
	}

}
