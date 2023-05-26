// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only



class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while(l<=r){
            int mid = l + (r-l)/2;

            if (mid<nums.length-1 && nums[mid+1]<nums[mid]) return nums[mid+1]; // we got min
            
            if (mid>0 && nums[mid-1]>nums[mid]) return nums[mid]; // we got min
            

            if (nums[mid]> nums[l] && nums[l] > nums[r]) {
                l = mid +1;
            }
            else if (nums[mid] < nums[r] && nums[l] > nums[r]) {
                r = mid-1;
            }
            else return nums[l];// array is sorted
        }

        return nums[0];
        
    }
}