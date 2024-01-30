////time complexity - O(logn), space complexity O(1) no additional space
//The solution uses two binary search functions (binarySearch1 and binarySearch2) to find the leftmost and rightmost occurrences of the target in the sorted array.
//The searchRange function returns an array with the leftmost and rightmost indices of the target.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearch1(nums, 0, nums.length-1, target);
        result[1] = binarySearch2(nums, 0, nums.length-1, target);
        return result; 
    }

    private int binarySearch1(int[] nums, int l, int r, int target){
        if(l>r) return -1; 
        int result = -1; 
        while(l <= r){
            int mid = l + (r-l)/2;
            
       

            if(nums[mid] == target){
                result = mid; 
                r = mid-1; 
            } else if (nums[mid] > target){
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return result; 
    }

    private int binarySearch2(int[] nums, int l, int r, int target){
        if(l>r) return -1; 
        int result = -1; 
        while(l <= r){
            int mid = l + (r-l)/2;
           
            if(nums[mid] == target){
                result = mid; 
                l = mid + 1; 
            } else if ( nums[mid] > target){
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }
        return result; 
    }
}