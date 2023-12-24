// 153. Find Minimum in Rotated Sorted Array

// Time Complexity : O(log n)
// Space Complexity : O(1) since we only used pointers 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// first check if the array is sorted, i.e. a[low]<=a[high]
// then check if mid is smaller than its neighbours, if yes return a[mid]
// if not, then check unsorted side to find min
// keep doing that till mid is smaller than its neighbours

class Solution {
    public int findMin(int[] nums) {
        //first check if nums is sorted
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            // at any point if the array is sorted return nums[low]
            if(nums[low] <= nums[high])
                return nums[low];
            int mid = low+(high-low)/2;
            if((mid == nums.length-1 || nums[mid]<=nums[mid+1]) && ( mid == 0 || nums[mid]<=nums[mid-1])){
                return nums[mid];
            }
            else if (nums[low] <= nums[mid]){
                //left side is sorted - move right
                low = mid+1;
            }
            else{
                //right side is sorted - move left
                high = mid-1;
            }
        }
        return nums[low];
    }
}