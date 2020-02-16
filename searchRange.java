class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int l = 0 ;
        int h = nums.length -1  ;
        int[] result = new int[]{-1,-1};
        
         
        if(nums == null || nums.length < 1 ) return result;
                 System.out.println(l +":"+h);
        if( nums.length == 1 && nums[0] == target) return  new int[]{0,0};
        
        while(h >= l ) {
            
            int mid = ( h + l) /2 ;
            System.out.println(l +":"+h+":"+mid);
            if(nums[mid] == target) {
                 System.out.println( "found at "+mid);
                int k = mid;
                int j = mid;
                while(--k >=0 && nums[k] == target    ) {
                  
                    
                }
                while(++j < nums.length && nums[j] == target ) {
                   
                }
                 result[0] = k+1;
                 result[1] = j-1;
                   System.out.println("result  "+k +":"+j+":"+mid);
                 return result;
            } else if (nums[mid] > target) {
                h = mid  -1 ;
                
            }else {
                l = mid +1 ;
            }
            
             System.out.println("end  "+l +":"+h+":"+mid);
            
        }
        
        
        return new int[]{-1,-1};
        
    }
}
