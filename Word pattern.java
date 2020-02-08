// Time Complexity - 0(n)
// space Complexity - 0(n)
import java.io.*;
import java.util.*;

class GFG {
    public boolean pattern(String pat, String str){
        String[] str_arr = str.split(" ");
        if(pat.length() == 0 || str.length() == 0) return false;
        HashMap<Character,String> patmap = new HashMap<>();
        HashMap<String,Character> strmap = new HashMap<>();
        for(int i=0;i<pat.length();i++){
            char a = pat.charAt(i);
            if(!patmap.containsKey(a)){
                patmap.put(a,str_arr[i]);
            }else {
               if(patmap.get(a).compareTo(str_arr[i])!=0) return false;
            }
            if(!patmap.containsKey(str_arr[i])){
                strmap.put(str_arr[i],a);
            }else {
               if(strmap.get(str_arr[i])!=a) return false;
            }
        }
        return true;
    }
	public static void main (String[] args) {
	    GFG g1 = new GFG();
	    String pat = "abba";
	    String str = "dog cat cat ele";
	   System.out.print(g1.pattern(pat,str));
	    
	    
	}
}