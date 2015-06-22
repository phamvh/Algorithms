package map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * My own HashMap implementation.
 * Pay attention to method containsKey() and put(). Those are important. Other methods can be implemented in
 * a similar way.
 * 
 * Note that each element in the buckets can contains a reference to a next element, in case of hash collision.
 * 
 * @author Van
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K,V> implements Map<K, V>{
	private Entry<K,V>[] buckets;
	private int MIN_CAPACITY = 32;
	private int capacity;
	private int count=0;
	
	public MyHashMap(int capacity) {
		this.capacity = capacity > MIN_CAPACITY?capacity:MIN_CAPACITY;
		buckets = new Entry[this.capacity];
	}
	
	 
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count==0;
	}

	@Override
	public boolean containsKey(Object key) {
		if(key==null)
			return false;
		int hash = key.hashCode();
		int position = hash&Integer.MAX_VALUE % capacity; //the & is to convert negative hash to non-negative.
		Entry<K,V> entry = buckets[position];
		if(entry==null)
			return false;
		//each entry may contain a reference to a next entry (linked list)
		//Note that this linked list is not a util collection. It is just our own linked list because
		//we cannot put a collection in buckets[].
		for(Entry<K,V> e = entry; e!=null; e=e.next){ 
			if((e.getKeyHash()==hash) && (key.equals(e.getKey())))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		if(key==null)
			return null;
		int hash = key.hashCode();
		int position = hash&Integer.MAX_VALUE % capacity; //the & is to convert negative hash to non-negative.
		Entry<K,V> entry = buckets[position];
		if(entry==null)
			return null;
		//each entry may contain a reference to a next entry (linked list)
		//Note that this linked list is not a util collection. It is just our own linked list because
		//we cannot put a collection in buckets[].
		for(Entry<K,V> e = entry; e!=null; e=e.next){ 
			if((e.getKeyHash()==hash) && (key.equals(e.getKey())))
				return e.getValue();
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if(key==null)
			return null;
		int hash = key.hashCode();
		int position = hash&Integer.MAX_VALUE % capacity;
		Entry<K,V> entry = buckets[position];
		
		for(Entry<K,V> e= entry; e!=null;e=e.next){
			if((e.getKeyHash()==hash) && (e.getKey().equals(key)))
				//key exists; simply replace the old value with the new value
				e.setValue(value);
			return value;
		}
		
		//if key does not exist yet
		if(count+1>capacity){
			//expand the buckets
			expand();
			//get new position after expanding
			position = hash&Integer.MAX_VALUE % capacity;
			entry = buckets[position];
		}
		
		Entry<K,V> newEntry = new Entry<K,V>(key,value);
		newEntry.next = entry;
		buckets[position] = newEntry;
		count++;
		
		return value;
		
	}
	
	private void expand(){
		int newCapacity = capacity*2;
		Entry<K,V>[] newBuckets = new Entry[newCapacity];
		for(int i=0; i<capacity;i++){
			Entry<K,V> entry = buckets[i];
			if(entry==null)
				continue;
			List<Entry<K,V>> list = new ArrayList<Entry<K,V>>();
			for(Entry<K,V> e = entry; e!=null;e=e.next){
				list.add(e);
				
			}
			for(Entry<K,V> e : list){
				int hash = e.getKeyHash();
				int position = hash&Integer.MAX_VALUE%newCapacity;
				Entry<K,V> e1 = newBuckets[position];
				if(e1==null){
					newBuckets[position] = e;
				}else{
					e.next=e1;
					newBuckets[position] = e;
				}
			}
				
		}
		capacity = newCapacity;
		buckets = newBuckets;
		
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	class Entry<K,V> implements Map.Entry<K, V>{
		final K key;
		V value;
		Entry<K,V> next;
		int hashCode;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			hashCode = key.hashCode();
			// TODO Auto-generated constructor stub
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			this.value = value;
			return value;
		}
		
		public int getKeyHash(){
			return key.hashCode();
		}
		
	}

}
