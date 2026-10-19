class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0)
            return new int[] { -1, -1 };
      // Above if block can be omitted as well
        int low = 0;
        int high = nums.length - 1;

        int first = -1;
        int second = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        low = 0;
        high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                second = mid;
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return new int[]{first, second};
    }
}
// 2 binary search = 2 * O(log n) 2 is constant so just O(log n) 
// SC - O(1)