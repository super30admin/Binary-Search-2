class Solution {
    public int findMin(int[] nums) {
        
        int low=0;
        int high = nums.length -1;
        
        //1. Define low and high
        //2.do binary search with 4 conditions mentioned
        //3. mis is teh answer
        //4.low is the answer
        //5.move towards right
        //6.move towards left
        
        //Why not low<=high 1..already checking,assumes no dublicates
       while(low<high){ //One element go in while loop
           int mid = low + (high - low)/2;     // To avoid  Overflow
           
           //3.
           if((mid == 0 || nums[mid] < nums[mid-1])&& nums[mid]<nums[mid+1]){
               return nums[mid];
           }
           
           
           
           //4.
           else if(nums[low]<nums[high]){
               return nums[low];
           }
           
           
           //5.
                                else if(nums[mid]>nums[high]){
                                low = mid+1;
                                }
           
           
           
           //6.
                                else{
                                high = mid -1; 
                                }
           
           
           
           
       } 
        
        
        
        
        return nums[low];   //nums[high]
    }
                                }
                                
//Time Complexity O(log n)
//Space Complexity O(1)