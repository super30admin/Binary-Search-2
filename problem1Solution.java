//Find First and Last position of Element in Sorted Array
//Time Complexity : O(log n)
//Space Complexity : O(1)

public class problem1Solution {
    private int firstSearch(int low, int high, int[] nums, int target) {
        while(low<=high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid-1]) return mid;
                else {
                    high  = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid -1;
            } else {
                low= mid + 1;
            }
        }
        return -1;
    }

    private int lastSearch(int low, int high, int[] nums, int target) {
        while(low<=high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]) return mid;
                else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = firstSearch(0, n-1, nums,target);
        if(first == -1) return new int[]{-1,-1};
        int last = lastSearch(first, n-1, nums, target);
        return new int[]{first,last};
    }
}
