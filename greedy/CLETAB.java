/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader sc=new FastReader();
      PrintWriter pr= new PrintWriter(System.out);
		int T = sc.nextInt();
		while(T-- > 0) {
		    int N = sc.nextInt();
		    int M = sc.nextInt();
		    int[] C = new int[M];
		    for(int i = 0; i < M; i++) {
		        C[i] = sc.nextInt();
		    }
		    
		    pr.println(getTablesToBeCleaned(C, N));
            pr.flush();
		}
	}
	
	static int getTablesToBeCleaned(int[] C, int N) {
	    Set<Integer> tables = new HashSet();
	    int cleans = 0;
	    for(int i = 0; i < C.length; i++) {
	        int c = C[i];
	        if(tables.contains(c)) {
	            continue;
	        }
	        cleans++;
	        if(tables.size() < N) {
	            tables.add(c);
	            continue;
	        }
	        tables.remove(getCustomerToBeRemoved(C, i, tables));
	        tables.add(c);
	    }
	    return cleans;
	}
	
	static int getCustomerToBeRemoved(int[] C, int i, Set<Integer> tables) {
	    Set<Integer> tmpTables = new HashSet<>(tables);
	    for(int j = i+1; j < C.length; j++) {
	        if(tmpTables.size() == 1) {
	            break;
	        }
	        if(tmpTables.contains(C[j])) {
	            tmpTables.remove(C[j]);
	        }
	    }
	    return tmpTables.iterator().next();
	}
	static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() {
			return Long.parseLong(next());
		}
    }
}
