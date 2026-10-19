class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high){
            int mid = low + (high - low)/2;

            if(nums[low] <= nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid+1;
            }else{
                min = Math.min(min, nums[mid]);
                high = mid-1;
            }
        }

        return min;
    }
}

// TC - O(log n)
// SC - O(1)