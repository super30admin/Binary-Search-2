// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Approach: By making the array into halves and finding mid to check their numbers to find peak. Check which side is greater then go to that side and check if its both neighbours are greater then we can find a peak. By writing all the conditions that peak returns in while loop then no need to return anything if it comes out to loop also because peak will be found inside loop.
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null ||nums.length==0){
            return -1;
        }
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if((mid==low || nums[mid]>nums[mid-1]) && (mid==high || nums[mid] > nums[mid+1])){
                return mid;
            } else if ( nums[mid] < nums[mid+1]){
              low=mid+1;
            } 
            else{
                high=mid-1;
            }
        }

        
        return 234;
    }
}
 