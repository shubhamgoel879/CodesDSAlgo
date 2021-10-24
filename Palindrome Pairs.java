import java.util.*;
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        if(words.length==0 || words.length==1)
            return res;
        
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
            map.put(words[i],i);
        
        for(int i=0;i<words.length;i++)
        {
            String word=words[i];
            for(int j=0;j<=word.length();j++)
            {
                String str1=word.substring(0,j);
                String str2=word.substring(j);
                
                
                if(isPal(str1))
                {
                    String str2rev=new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rev) && map.get(str2rev)!=i)
                    {
                        List<Integer> list=new ArrayList<>();
                        list.add(map.get(str2rev));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(str2.length()!=0 && isPal(str2))
                {
                    String str1rev=new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rev) && map.get(str1rev)!=i)
                    {
                        List<Integer> list=new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str1rev));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPal(String str)
    {
        int i=0;
        int j=str.length()-1;
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
