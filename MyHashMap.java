import java.util.LinkedList;
public class MyHashMap {
	
     public static class HMap<K,V>{
		
		private class HTPair
		{
			K key;
			V value;
			HTPair(K key,V value)
			{
				this.key=key;
				this.value=value;
			}
			public boolean equals(Object other)
			{
				HTPair ob=(HTPair) other;
				return ob.key.equals(this.key);
			}
			public String toString()
			{
				return "{"+this.key+":"+this.value+"}";
			}
		}
		private LinkedList<HTPair>[] bucketArray;
		private int size;
		HMap(){
			this(10);
		}
		HMap(int cap)
		{
			bucketArray=new LinkedList[cap];
			size=0;
		}
		public void put(K key,V value)
		{
			int i=hashFunction(key);
			LinkedList<HTPair> bucket=bucketArray[i];
			HTPair pair=new HTPair(key, value);
			if(bucket==null)
			{
				bucket=new LinkedList<>();
				bucket.addLast(pair);
				bucketArray[i]=bucket;
				size++;
			}
			else
			{
				int j=bucket.indexOf(pair);
				if(j==-1)
				{
					bucket.addLast(pair);
					size++;
				}
				else
				{
					HTPair temp=bucket.get(j);
					temp.value=value;
				}
			}
			
			
			double lf=(this.size*1.0)/this.bucketArray.length;
			if(lf>0.75)
				this.rehash();
		}
		public V get(K key)
		{
			int i=hashFunction(key);
			LinkedList<HTPair> bucket=bucketArray[i];
			if(bucket==null)
				return null;
			HTPair pair=new HTPair(key, null);
			int j=bucket.indexOf(pair);
			if(j==-1)
				return null;
			else
			{
				return bucket.get(j).value;
			}
		}
		public V remove(K key)
		{
			int i=hashFunction(key);
			LinkedList<HTPair> bucket=bucketArray[i];
			if(bucket==null)
				return null;
			HTPair pair=new HTPair(key,null);
			int j=bucket.indexOf(pair);
			if(j==-1)
				return null;
			else
			{
				HTPair temp=bucket.remove(j);
				size--;
				return temp.value;
			}
		}
		public void display()
		{
			System.out.print("[ ");
			for(LinkedList<HTPair> bucket: bucketArray)
			{
				if(bucket==null)
					continue;
				for(HTPair p: bucket)
				{
					System.out.print(p.toString()+" ");
				}
			}
			System.out.println("]");
		}
		private void rehash()
		{
			LinkedList<HTPair>[] tempBucketArray=bucketArray;
			bucketArray=new LinkedList[2*tempBucketArray.length];
	/******/		size=0;
			for(LinkedList<HTPair> bucket:tempBucketArray)
			{
				if(bucket==null)
					continue;
				while(bucket.size()!=0)
				{
					HTPair pair=bucket.removeFirst();
					this.put(pair.key,pair.value);
				}
			}
		}
	    private int hashFunction(K key)
	    {
	    	int hc=Math.abs(key.hashCode());
	    	return hc%this.bucketArray.length;
	    }
	}
	

	public static void main(String[] args) 
	{
		HMap<Integer,Integer> map=new HMap<>();
		map.put(100, 90);
		map.put(10, 9);
		map.put(1, 89);
		map.put(1000, 5);
		map.display();
	    
	    

	}
}
