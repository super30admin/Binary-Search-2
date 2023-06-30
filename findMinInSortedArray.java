// Time Complexity : log(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MinimumInSortedArray {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0, high = len-1;

        if(nums[high] > nums[low] || low == high){
            return nums[low];
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }

            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }

            if(nums[mid] > nums[low]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return Integer.MIN_VALUE;
    }
}