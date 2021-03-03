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
		int t = sc.nextInt();
		while(t-- > 0) {
		    String s = sc.next();
		    int[] attacks = preprocess(s);  
		    int n = sc.nextInt();
		    while(n-- > 0) {
		        int q = sc.nextInt();
		        pr.println(attacks[q-1]);    
		    }
            pr.flush();
		}
	}
	
	static int[] preprocess(String s) {
	    Stack<Integer> stack = new Stack<>();
	    int[] attacks = new int[s.length()];
	    Arrays.fill(attacks, -1);
	    int recentlyBalancedAt = -1;
	    
	    for(int i = attacks.length-1; i >= 0; i--) {
	        if(s.charAt(i) == ')') {
	            stack.push(i);
	            attacks[i] = recentlyBalancedAt;
	            continue;
	        }
	        if(!stack.isEmpty()) {
	            attacks[i] = stack.pop()+1;
	        }
	        
	        recentlyBalancedAt = attacks[i];
	    }
	    return attacks;
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
