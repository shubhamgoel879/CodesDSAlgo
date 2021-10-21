import java.util.*;
public class triesimplement 
{
	public static class Tries
	{
		private Tnode root;
		public int numOfWords;
		Tries()
		{
			this.root=new Tnode('\0');
			this.numOfWords=0;
		}
		private class Tnode
		{
			char data;
			boolean isTrmnl;
		 	HashMap<Character, Tnode> nbrs;
			Tnode(char data)
			{
				this.data=data;
				this.isTrmnl=false;
				this.nbrs=new HashMap<>();
			}
		}
		
		public void insert(String str)
		{
			this.insertHelper(root, new StringBuilder(str), 0);
		}
		private void insertHelper(Tnode node, StringBuilder str,int i)
		{
			if(i==str.length())
			{
				if(node.isTrmnl)
				{
					
				}
				else
				{
					node.isTrmnl=true;
					numOfWords++;
				}
				return;
			}
			char c=str.charAt(i);
			if(node.nbrs.containsKey(c))
			{
				insertHelper(node.nbrs.get(c), str, i+1);
			}
			else
			{
				node.nbrs.put(c, new Tnode(c));
				insertHelper(node.nbrs.get(c), str, i+1);
			}
		}
		
		public boolean search(String str)
		{
			return searchHelper(root, new StringBuilder(str), 0);
		}
		private boolean searchHelper(Tnode node,StringBuilder str,int i)
		{
			
			if(i==str.length())
			{
				if(node.isTrmnl)
				{
					return true;
				}
				else
				{ 
					return false;
				}
			}
			char c=str.charAt(i);
			if(node.nbrs.containsKey(c))
			{
				return searchHelper(node.nbrs.get(c),str,i+1);
			}
			else
			{
				return false;
			}
		}
		
		public void remove(String str)
		{
			removeHepler(root, new StringBuilder(str), 0);
		}
		private void removeHepler(Tnode node, StringBuilder str,int i)
		{
			if(i==str.length())
			{
				if(node.isTrmnl)
				{
					node.isTrmnl=false;
					numOfWords--;
					return;
				}
				else
				{
					return;
				}
			}
			char c=str.charAt(i);
			if(node.nbrs.containsKey(c))
			{
				Tnode child=node.nbrs.get(c);
				removeHepler(child, str, i+1);
				if(child.isTrmnl==false && child.nbrs.size()==0)
					node.nbrs.remove(c);
			}
			else
			{
				return;
			}
		}
		
		
		
		public void display()
		{
			displayHelper(root, new StringBuilder());
		}
		private void displayHelper(Tnode node,StringBuilder str)
		{
			if(node.isTrmnl)
				System.out.println(str.toString());
			Set<Map.Entry<Character, Tnode>> eset= node.nbrs.entrySet();
			for(Map.Entry<Character, Tnode> e: eset)
			{
				str.append(e.getKey());
				displayHelper(e.getValue(), str);
				str.deleteCharAt(str.length()-1);
			}
		}
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Tries t=new Tries();
		t.insert("abc");
		t.insert("abcde");
		t.insert("done");
		t.insert("do");
		t.display();
		System.out.println(t.numOfWords);
		t.remove("do");
		System.out.println(t.search("do"));
		System.out.println(t.numOfWords);
	}

}
