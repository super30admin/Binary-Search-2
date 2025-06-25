//Time Complexity - O(log n)
//Space Complexity - O(1) Not using any extra space.

// Implemented using Binary search on a rotated array. There is one side where its always sorted and
// move the high low accordingly
public class FindMinimun {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int low = 0;
        int high = n -1 ;
        while(low <= high) {
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n-1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){ // left sorted range
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;

    }
}
