// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low,mid,high;
        low = 0; 
        high = n-1;

        while(low <= high){
            mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] > nums[mid - 1]) && ( mid == n-1 || nums[mid] > nums[mid + 1])){//peak at mid
                return mid;
            }
            else if(nums[mid + 1] > nums[mid]){//search in right side
                low = mid + 1;
            }else{//search in left side
                high = mid - 1;
            }
        }

        return -1;
    }
}