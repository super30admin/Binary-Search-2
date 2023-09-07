// Find First and Last Position of Element in Sorted Array

class Solution {

    public int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int[] arr = new int[]{-1, -1};

        // finding first position of target
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    arr[0] = mid;
                    break;
                } else high = mid - 1;
            } else if(target > nums[mid])
                low = mid + 1;
            else high = mid - 1;
        }

        // finding last position of target
        low = 0;
        high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    arr[1] = mid;
                    break;
                } else low = mid + 1;
            } else if(target > nums[mid])
                low = mid + 1;
            else high = mid - 1;
        }

        return arr;
    }


// Find Peak Element
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
                return mid;
            else if(nums[mid + 1] > nums[mid]) 
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

// Find Minimum in Rotated Sorted Array

class Solution {
    public int findMin(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high])
                low = mid + 1;
            if(nums[mid] < nums[high])
                high = mid;
        }

        return nums[low];
        
    }
}
