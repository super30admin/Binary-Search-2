// Time Complexity : O(log(n)) Binary search applied for searching the element in array
// Space Complexity : O(1) no extra space used other than constants
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class FirstAndLastElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[]{-1,-1};

        //base case
        if(nums == null || nums.length == 0) {
            return result;
        }
        int first = binarySearchFirst(nums, target);
        if(first == -1){
            return new int[] {-1,-1};
        }
        int second = binarySearchSecond(nums, target, first);
        return new int[]{first, second};
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if((mid == low) || (nums[mid-1] != nums[mid])){
                    return mid;
                }
                high =  mid - 1;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchSecond(int[] nums, int target, int low) {
        int high = nums.length -1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if((mid == high) || (nums[mid] != nums[mid + 1])){
                    return mid;
                }
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
