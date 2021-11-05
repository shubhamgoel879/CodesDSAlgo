/*Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
There is a path from any cell to all its neighbouring cells.*/


public class Solution {

    int solve(String[] graph , int N, int M)
    {
        boolean[][] visited=new boolean[N][M];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(dfs(graph,visited,"CODINGNINJA",0,i,j))
                    return 1;

            }
        }
        return 0;

    }
    private boolean dfs(String[] graph, boolean[][]visited,String str,int i_str,int i,int j)
    {
        if(i_str==str.length())
            return true;
        if(!isValid(graph,visited,str,i_str,i,j))
            return false;

        visited[i][j]=true;

        if(dfs(graph,visited,str,i_str+1,i,j-1))
        {
            visited[i][j]=false;
            return true;
        }
        if(dfs(graph,visited,str,i_str+1,i,j+1))
        {
            visited[i][j]=false;
            return true;
        } 
        if(dfs(graph,visited,str,i_str+1,i-1,j-1))
        {
            visited[i][j]=false;
            return true;
        }
        if(dfs(graph,visited,str,i_str+1,i-1,j))
        {
            visited[i][j]=false;
            return true;
        }
        if(dfs(graph,visited,str,i_str+1,i-1,j+1))
        {
            visited[i][j]=false;
            return true;
        }
        if(dfs(graph,visited,str,i_str+1,i+1,j-1))
        {
            visited[i][j]=false;
            return true;
        }
        if(dfs(graph,visited,str,i_str+1,i+1,j))
        {
            visited[i][j]=false;
            return true;
        }
        if(dfs(graph,visited,str,i_str+1,i+1,j+1))
        {
            visited[i][j]=false;
            return true;
        }
        
        visited[i][j]=false;
        return false;

    }
    private boolean isValid(String[] graph, boolean[][]visited,String str,int i_str,int i,int j)
    {
        if(i<=-1 || i>=graph.length)
            return false;
        if(j<=-1 || j>=graph[i].length())
            return false;
        if(visited[i][j])
            return false;
        if(str.charAt(i_str)!=graph[i].charAt(j))
            return false;
        return true;
    }

}


