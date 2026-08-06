//TC: 2*O(log(N)) 
//SC: O(1)
//Approach: Apply BS in the array, once the mid==target. for low idx, compare it with mid-1, if it's equal to target do the BS in the left array till, mid-1 != target, return mid.
//Similarly do it for the high idx.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = binarySearchLowIndex(nums, 0, nums.length-1, target);
        if(low == -1) return new int[]{-1, -1};
        int hi = binarySearchHighIndex(nums, 0, nums.length-1, target);
        return new int[]{low, hi};
    }

    private int binarySearchLowIndex(int[] nums, int low, int hi, int target) {
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(nums[mid] == target) {
                if(mid ==0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else if( nums[mid] > target) {
                hi = mid - 1;
            } else {
                low = mid+ 1;
            }
        }
           return -1;
    }

    private int binarySearchHighIndex(int[] nums, int low, int hi, int target) {
      while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length -1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid +1;
                }
            } else if( nums[mid] > target) {
                hi = mid - 1;
            } else {
                low = mid+ 1;
            }
        }
           return -1;
       
    }
}