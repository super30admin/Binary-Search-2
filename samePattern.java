//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] word = s.split(" ");
        
    //    System.out.println(pattern.length()); 
      //  System.out.println(word.length);
        
          if(pattern.length() != word.length || pattern.length() == 0 || s.length() == 0 || pattern == null || s == null){
            
            return false;
        }
         
         HashMap<Character,String> m1 = new HashMap<>();
        HashMap<String,Character> m2 = new HashMap<>();
        
        
        
         for(int i = 0; i < pattern.length(); i ++){
          
            
            if(!m1.containsKey(pattern.charAt(i))){
            
                m1.put(pattern.charAt(i),word[i]);
                //
            }
           //  System.out.println(m1.get(pattern.charAt(i)));
             else {
                 
              String temp =    m1.get(pattern.charAt(i));
                 if(temp.equals(word[i]) == false){
                     
                     return false;
                 }
             }
                if(!m2.containsKey(word[i])){
            
                m2.put(word[i],pattern.charAt(i));
                //
            }
           //  System.out.println(m1.get(pattern.charAt(i)));
             else {
                 
              char temp1 =    m2.get(word[i]);
                 if(temp1 != pattern.charAt(i)){
                     
                     return false;
                 }
             }
        }
        return true;
        
        
    }
}