// problem 1: 
// Time: logn + logn = 2logn = O(longn)
// Space: O(1)
// The general idea of this solution is to perform binary search twice. The first time
// is for finding the first occurrence of the target element, and the second time is for 
// finding the second element of the target element. Then, return the two indexes. 
class Solution {
    private int leftBS(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid; // Return index of the found target
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int rightBS(int[] nums, int target, int left) {
        int low = left;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid; // Return index of the found target
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }
        int left = leftBS(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = rightBS(nums, target, left);
        return new int[]{left, right};
    }
}





// problem 2: 
// Time: O(logn)
// Space: O(1)
// The general idea for this solution is to perform a modified version of binary search.
// It is guaranteed that one half of the array will be sorted, while the other will not be.
// After determining which side is sorted, we go to the other half of the array and repeat.
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if(mid != 0 && mid != nums.length-1){
                if(nums[mid] <= nums[mid-1] && nums[mid+1] >= nums[mid+1]){
                    return nums[mid];
                }  
            }
            //if left sorted, go to right
            if(nums[low]<=nums[mid]){
                low = mid+1;
            }
            //right sorted, go to left
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}




// problem 3: 
//Time: O(logn)
//Space: O(1)
//The general idea behind this solution is to perform binary search on an unsorted array.
//Since we have to find a peak element and it is guaranteed that there will be at least
// one peak element and we do not need to return all possible peaks, we can perform a 
// modified version of binary search. This modified version will move to the side of mid's
// neighbors that is larger. This is similar to climbing a mountain that does not grow 
// linearly in size. 
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid]>nums[mid-1]) && ( mid == len-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            //search on the right part of the array
            else if(nums[mid+1]>nums[mid]){
                low = mid+1;
            }
            //search left
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}