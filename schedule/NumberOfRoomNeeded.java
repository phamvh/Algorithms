package schedule;

public class NumberOfRoomNeeded {
	public int minRooms(Interval[] intervals){
		int min = intervals.length;
		for(int i=0;i<intervals.length;i++){
			int rooms = 1;
			for(int j=0; j<intervals.length;j++){
				if(i==j)
					continue;
				if(areIntersecting(intervals[i], intervals[j]))
					rooms++;
			}
			if (min > rooms)
				min=rooms;
		}
		return min;
	}
	
	public boolean areIntersecting(Interval i1, Interval i2){
		if(i1.start>=i2.start && i1.end<=i2.end)
			return true;
		if(i1.start<=i2.start && i1.end>=i2.end)
			return true;
		if(i1.start<=i2.start && i1.end>=i2.start)
			return true;
		if(i1.start>=i2.start && i1.start<=i2.end)
			return true;
		return false;
		
	}
}

class Interval{
	public int start;
	public int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end=end;
		// TODO Auto-generated constructor stub
	}
}
