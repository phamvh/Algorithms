package social;

import java.util.List;

public class Celebrity {
	
	public Person getCelebrity(List<Person> people){
		
		while(people.size()>1){
			boolean first=false,second=false;
			if(knows(people.get(0),people.get(1))){
				first=true;
			}else{
				second=true;
			}
			if(knows(people.get(1),people.get(0))){
				second=true;
			}else
				first=true;
			if(first){
				people.remove(0);
			}
			if(second){
				if(first)
					people.remove(0);
				else
					people.remove(1);
			}
		}
		if(people.size()==0)
			return null;
		return people.get(0);
	}
	
	public boolean knows(Person p1, Person p2){
		return false;
	}

}

class Person{
	
}
