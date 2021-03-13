import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader sc=new FastReader();
	        PrintWriter pr= new PrintWriter(System.out);
		int t = sc.nextInt();
		while(t-- > 0) {
		    String s = sc.next();
		    int n = sc.nextInt();
		    while(n-- > 0) {
		        int q = sc.nextInt();
		        pr.println(canAttackAt(s, q));    
		    }
		    
            pr.flush();
		}
	}
	
	static int canAttackAt(String s, int t) {
	    int i = t-1;
	    int cnt = 0;
	    while(i < s.length()) {
	        while(i < s.length() && s.charAt(i) == ')') {
	            i++;
	        }
	        if(i >= s.length()) {
	            return -1;
	        }
	        while(i < s.length() && s.charAt(i) == '(') {
	            i++;
	            cnt++;
	        }
	        while(i < s.length() && s.charAt(i) == ')' && cnt > 0) {
	            i++;
	            cnt--;
	        }
	        if(cnt == 0) {
	            return i;
	        }
	    }
	    return -1;
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
