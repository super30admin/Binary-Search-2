// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

// 153. Find Minimum in Rotated Sorted Array
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int high = n-1;
        int low = 0;
        int min = nums[low];
        int mid = 0;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (nums[low] == min){
                return mid;
            }
            if(nums[low] < nums[mid]){
                if((nums[low] < min)&&(nums[mid] < min)){
                    high = mid;
                }
                else{
                    low = mid;
                    min = nums[low];
                }
            }
            else{
                low = mid;
                min = nums[low];
            }
        }
        return 0;
    }
}