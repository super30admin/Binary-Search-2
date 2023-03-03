//Time complexity:O(logn)
//Space Complexity:O(1)
//executed successfully : yes 
// Approach - Used modified binary search to search peek element of larger element side 

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int n = nums.length;

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if((mid ==0||nums[mid]>nums[mid-1]) && (mid ==n-1|| nums[mid]>nums[mid+1]))
            return mid ;
            else if(mid > 0 && nums[mid-1]>nums[mid]){
                 high =mid-1;
            
            }
            else{
            low = mid+1;
            }
        }
       return -1;
    }
}
