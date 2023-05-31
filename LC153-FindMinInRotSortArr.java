// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only
/*
 min is the point which is surronded by higher values. We can check if mid is surrounded by high value or not.
if (mid > l) l = mid+1
else if (mid) 

 */


class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        if (nums[l] <= nums[r]) return nums[l]; // sorted array. Equal check if single element array

        while(l<=r){
            int mid = l + (r-l)/2;

            if (mid<nums.length-1 && nums[mid+1]<nums[mid]) return nums[mid+1]; // we got min
            
            // if (mid>0 && nums[mid-1]>nums[mid]) return nums[mid]; // we got min
            if (mid == 0 || nums[mid-1]>nums[mid]) return nums[mid]; // we got min
            

            if (nums[mid]> nums[l]) {
                l = mid +1;
            }
            else if (nums[mid] < nums[r]) {
                r = mid-1;
            }
        }

        return nums[0];
        
    }
}