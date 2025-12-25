// Approach:
// We will perform binary search on the array. If the mid value is smaller than high index value, there is a chance
// there is a even smaller value on the left of the mid index, so search for min value on the left by updating
// high pointer. If the mid value is greater than the high index value, the minimum value is definitely on the right
// side of the array, so update the low index.

public class MinimumInRotatedArray {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return -1;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.min(nums[0], nums[1]);

        int low = 0;
        int high = len - 1;
        int minValue = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] <= nums[high]){
                minValue = Math.min(minValue, nums[mid]);
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return minValue;
    }
}
