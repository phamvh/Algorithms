package greedy;

public class Scheduling {
	
	/**
	 * Return the max number of events that do not overlap.
	 * This is a greedy algorithm (non-weighted events) because each event counts once.
	 * (Note that if each event has a weight, we need to use dynamic programming)
	 * @param events
	 * @return
	 */
	public int maxEvents(Range[] events){
		for(int i=0; i<events.length-1;i++){
			for(int j=i+1;j<events.length;j++){
				if(events[i].end > events[j].end){
					Range temp = events[i];
					events[i]=events[j];
					events[j]=temp;
				}
			}
		}
		int OPT=0;
		int i=0;
		Range prev=null;
		while(i<events.length){
			if(i==0){
				prev=events[i];
				OPT++;				
			}else{
				if(!isOverapping(prev, events[i])){
					OPT++;
					prev=events[i];
				}
			}
			i++;
		}
		return OPT;
	}
	
	public boolean isOverapping(Range r1, Range r2){
		if((r1.end <=r2.start) || (r2.end <= r1.start))
			return true;
		return false;
	}

}
class Range{
	int start;
	int end;
	public Range(int start, int end) {
		// TODO Auto-generated constructor stub
		this.start=start;
		this.end=end;		
	}
}
