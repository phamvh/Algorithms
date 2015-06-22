package range;

import java.util.LinkedList;
import java.util.List;

public class MergeRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<Range> mergeRanges(List<Range> ranges, Range newRange){
		List<Range> results = new LinkedList<Range>();
		for(Range range:ranges){
			if((range.end < newRange.begin) || (newRange.end > range.begin)){
				results.add(range);
			}else{
				int minBegin = Math.min(range.begin, newRange.begin);
				int maxEnd = Math.max(range.end, newRange.end);
				newRange = new Range(minBegin, maxEnd);
			}
			
		}
		results.add(newRange);
		return results;
	}

}
