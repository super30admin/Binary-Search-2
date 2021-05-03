//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null || strs.length == 0){
            
            return new ArrayList<>();
        }
        
        //Logic to sort the string array and to sort the string, convert it to char array
        //add the sorted and cooresponding original string to the hashmap and return the hashmap values
        //ArrayList<String> arr1 = new ArrayList<>();
        HashMap<String,List<String>> map1 = new HashMap<>();
        
        char[][] ch = new char[strs.length][];
        
        for(int i = 0; i < strs.length; i ++){
            
            ch[i] = strs[i].toCharArray();
            
         //   char[][] temp = new char[1][];
            
             Arrays.sort(ch[i]); //sorting the original string
            String sorted = String.valueOf(ch[i]);
            
            if(!map1.containsKey(sorted)){
                
                map1.put(sorted,new ArrayList<>());
            }
            
         //   else {
                
           //     map1.put(map1.get(String.valueOf(ch[i])),strs[i]);
            
          //  }
            map1.get(sorted).add(strs[i]);
            /*if(map.containsKey(key)){
    map.get(key).add(value);
} else {
   List<String> list = new ArrayList<>();
   list.add(value);
   map.put(key, list);
} */
          //  map1.put(map1.get(sorted),strs[i]);
           // map1.put(sorted,strs[i]);
        }
        
     //   System.out.println(map1);
        
      //  List<List<String>> s1 = new ArrayList<List<String>>();
        
        return new ArrayList<>(map1.values());
    }
}