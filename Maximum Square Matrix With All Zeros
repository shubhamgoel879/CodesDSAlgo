
// O(n*m) time,   O(m) space

import java.util.*;
public class Solution {
	
    public static int findMaxSquareWithAllZeros(int[][] input){
        

        if(input.length==0)
            return 0;
        int ans=Integer.MIN_VALUE;
        int[] arr=new int[input[0].length];
        for(int[] in:input)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(in[i]==1)
                    arr[i]=0;
                else
                    arr[i]++;
            }
            ans=Math.max(ans,findMaxSquareHistogram(arr));
        }
        return ans;
	
	}
    private static int findMaxSquareHistogram(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                int h=arr[st.pop()];
                int rs=i;
                int ls=st.isEmpty()?-1:st.peek();
                ans=Math.max(ans,Math.min(h,rs-ls-1));
            }
            st.push(i);
        }
        while(!st.isEmpty())
            {
                int h=arr[st.pop()];
                int rs=arr.length;
                int ls=st.isEmpty()?-1:st.peek();
                ans=Math.max(ans,Math.min(h,rs-ls-1));
            }
        return ans;
    }

	
}
