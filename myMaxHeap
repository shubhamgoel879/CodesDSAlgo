
import java.util.*;
 public class myMaxHeap
 {
	public static class PQ
	{
		// Complete this class
	    private ArrayList<Integer> arr;
	    PQ()
	    {
	        arr=new ArrayList<>();
	    }
	    PQ(int[] a)
	    {
	    	arr=new ArrayList<>();
	    	for(int num: a)
	    		arr.add(num);
	    	for(int i=arr.size()/2 -1;i>=0;i--)
	    	{
	    		downheapify(i);
	    	}
	    }
		boolean isEmpty() {
			// Implement the isEmpty() function here
	        return arr.size()==0;
		}

		int getSize() {
			// Implement the getSize() function here
	        return arr.size();
		}

		int getMax() {
			// Implement the getMax() function here
	        if(arr.size()==0)
	            return Integer.MAX_VALUE;
	        else
	            return arr.get(0);
		}

		void insert(int element) {
			// Implement the insert() function here
	        
	        arr.add(element);
	        upheapify(arr.size()-1);
		}

		int removeMax() {
			// Implement the removeMax() function here
	        if(arr.size()==0)
	            return Integer.MAX_VALUE;
	        if(arr.size()==1)
	            return arr.remove(0);
	        int ans=arr.get(0);
	        arr.set(0,arr.remove(arr.size()-1));
	        downheapify(0);
	        return ans;
	        
		}
	    private void upheapify(int ci)
	    {
	        while(ci>=1)
	        {
	            int pi=(ci-1)/2;
	            if(arr.get(pi)<arr.get(ci))
	                swap(arr,pi,ci);
	            else
	                break;
	            ci=pi;  
	        }
	    }
	    private void swap (ArrayList<Integer> arr,int a, int b)
	    {
	        int t=arr.get(a);
	        arr.set(a,arr.get(b));
	        arr.set(b,t);
	    }
	    private void downheapify(int pi)
	    {
	        int li=2*pi+1;
	        int ri=li+1;
	        while(li<=arr.size()-1 || ri<=arr.size()-1)
	        {
	            int ai=pi;
	            if(li<=arr.size()-1 && arr.get(li)>arr.get(ai))
	                ai=li;
	            if(ri<=arr.size()-1 && arr.get(ri)>arr.get(ai))
	                ai=ri;
	            if(ai==pi)
	                return;
	            swap(arr,ai,pi);
	            pi=ai;
	            li=2*pi+1;
	            ri=li+1;
	        }
	    }
	}

	public static void main(String[] args)
	{
		int[] arr= {2,5,1,9,7,3};
		PQ q=new PQ(arr);
		System.out.println(q.removeMax());
		System.out.println(q.removeMax());
		System.out.println(q.removeMax());
		q.insert(100);
		System.out.println(q.getMax());
		
	}

}
