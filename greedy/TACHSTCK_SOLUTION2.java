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
		int N = sc.nextInt();
		long D = sc.nextLong();
		long[] L = new long[N];
		for(int i = 0; i < N; i++) {
		    L[i] = sc.nextLong();
		}
		Arrays.sort(L);
		int count = 0;
		for(int i = 0; i < L.length-1; i++) {
		    long diff = L[i+1] - L[i];
		    if(diff <= D) {
		        count++;
		        i++;
		    }
		}
		pr.println(count);
        pr.flush();
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
