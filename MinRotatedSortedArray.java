/**
Time Complexity O(log n)
Space Complexity O(1)
Runs successfully on Leetcode
*/
class Solution {
    public int findMin(int[] nums) {
        //check for the null case
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length; 
        int low = 0;
        int high = n - 1; 
        while(low <= high){
            //checking if the complete array is sorted
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high-low)/2; //to avoid integer overflow;
            //check if element at mid is the min element
            if(mid != 0 && nums[mid] < nums[mid-1]){
                return nums[mid];
                //doing this to move to the unsorted part
            }else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return 999; 
    }
}