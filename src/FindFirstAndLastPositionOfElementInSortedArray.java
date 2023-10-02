// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};

        int low = 0;
        int high = nums.length - 1;
        if(nums[low] > target || nums[high] < target){
            return new int[]{-1,-1};
        }
        int firstPosition = findFirstPosition(nums, low, high, target);
        int secondPosition;
        if(firstPosition == -1){
            return new int[]{-1,-1};
        } else {
            secondPosition = findLastPosition(nums, firstPosition, high, target);
        }
        return new int[]{firstPosition, secondPosition};
    }
    public int findFirstPosition(int[] nums, int low, int high, int target){
        while (low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid>0 && nums[mid-1] == target){
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if(nums[mid] > target){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findLastPosition(int[] nums, int low, int high, int target){
        while (low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid < nums.length-1 && nums[mid+1] == target){
                    low = mid+1;
                } else {
                    return mid;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
