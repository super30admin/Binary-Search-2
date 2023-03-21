class Solution {
    public int[] searchRange(int[] nums, int target) {
        //Twist the binary search a little. How?
        
        
        //2, 3, 7, 7, 8, 10
        //Here we need to use the nearest binary search

        int first_index = bs(nums, target, true);
        if(first_index == -1){
            return new int[]{-1, -1};
        }

        int last_index = bs(nums, target, false);
        return new int[]{first_index, last_index};


        
        
    }

    public int bs(int[] nums, int target, boolean find_first){


        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        int last = -1;
         while(low <= high){

             int mid = low + (high - low)/ 2;

             if(nums[mid] == target){
                 //there are a couple of things you need to look at. 
                 if(find_first == true){

                     //if this is the first occurance then return the index. 
                     if(mid == low || nums[mid - 1] != target){
                         return mid;
                     }
                     //search the left side as this might not be the first occurance. 
                     high = mid - 1;
                 }
                 
                 //if we are looking for the last occurance
                 else{
                     //check if this is actually the last occurance. 
                     if(mid == high || nums[mid + 1] != target){
                         return mid;
                     }
                     //otherwise keep checking on the right side. 
                     low = mid + 1;
                 }
             }

             else if(nums[mid] < target){
                 low = mid + 1;
             }

             else{
                 high = mid - 1;
             }

         }
         return -1;
    }


    
       
    
}