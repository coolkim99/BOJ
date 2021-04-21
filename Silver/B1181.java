package Silver;

import java.io.*;
import java.util.*;

public class B1181 {
    public static void main(String args[]) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(rd.readLine());
        String[] words = new String[n]; 
        for(int i=0; i<n; i++) {
            words[i] = rd.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //단어 길이가 같을 때 사전 순으로 
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                
                else {
                    return s1.length() - s2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        sb.append(words[0]).append('\n');

        for(int i = 1; i<n; i++) {
            if(!words[i].equals(words[i-1])) {
                sb.append(words[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
    
}

