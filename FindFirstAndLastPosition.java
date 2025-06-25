//Time Complexity - O(log n)
//Space Complexity - O(1) Not using any extra space.

// Implemented using Binary search on  sorted array to find the first and last postions of the target
// checked the first occurence towards the left of the mid and last occurence towards right of the mid
public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null && nums.length == 0) {
            return new int[] {-1, -1};
        }
        int first = binarySearchFirst(nums, target);
        if(first == -1) {
            return new int[] {-1, -1};
        }
        int last = binarySearchLast(nums, target);
        return new int[] {first, last};

    }
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2; // prevent overflow
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != nums[mid]) {
                    return mid;
                }
                high = mid - 1;
            } else if(target > nums[mid]){
                low = mid + 1;

            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2; // prevent overflow
            if(nums[mid] == target){
                if(mid == high || nums[mid+1] != nums[mid]) {
                    return mid;
                }
                low = mid + 1;
            } else if(target < nums[mid]){
                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
