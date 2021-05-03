//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()){
            
            return false;
        }
        
            HashMap<Character,Character> m1 = new HashMap<>();
        HashMap<Character,Character> m2 = new HashMap<>();
          //  char s1 = new char[s.length()];
          //  char t1 = new char[t.length()];
        
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        
        for(int i = 0; i < s.length(); i ++){
            
            
            
            if(!m1.containsKey(s1[i])){
                
                m1.put(s1[i],t1[i]);
            
        }
              else{
                
              char temp =   m1.get(s1[i]);
             //   char temp2 = m2.get(t1[i]);
                
                if(temp != t1[i]){
                    
                    return false;
                }
                
              } 
            
            if(!m2.containsKey(t1[i])){
                
                m2.put(t1[i],s1[i]);
            
        }
            
            else{
                
            
                char temp2 = m2.get(t1[i]);
                
          
                
                if(temp2 != s1[i]){
                    
                    return false;
                }
            }
            
        }  
   //     System.out.print(m1);
    //    System.out.print(m2);
    
        return true;
    
}
}