// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

/**
 * Time Complexity :  O(log n) + O(log m) = O(log n) since n > m. We reduce search space by half hence logarithmic complexity.
 * Space Complexity : O(1) since no extra linear space
 * 
 */

/**
 * In this approach we apply binary search twice.
 * Once to find 1st position and other to find 2nd position.
 * If first returns -1, then there is for sure no target present in array, hence return [-1, -1];
 * binarySearchFirst finds the target and then checks if the found target is on first index. If not, we reduce the search space and move towards left.
 * binarySearchLast finds the target and then checks if the found target is on last index. If not, we reduce the search space and move towards right.
 */

class Solution {

    private int binarySearchFirst(int[] nums, int low, int high, int target) {

        while(low <= high){
            int mid = (low + (high - low)/ 2);

            if(nums[mid] == target){

                if(mid == 0){ // means low and high are same and not element to the left
                    return mid;
                }

                if(nums[mid] > nums[mid - 1]){ 
                    return mid;
                }else{                 // if we have more targets to left, reduce search space to left 
                    high = mid - 1;
                }

            }else if(nums[mid] > target){  // common conditions for binary search
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target){

        while(low <= high){
            int mid = (low + (high - low) / 2);

            if(nums[mid] == target){
                
                if(mid == nums.length - 1){ // means low and high are same and no element to the right
                    return mid;
                }

                if(nums[mid] < nums[mid + 1]){
                    return mid;
                }else{
                    low = mid + 1;   // if we have more targets to right, reduce search space to right 
                }
            }
            else if(nums[mid] > target){  // common conditions for binary search
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;

    }

    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        int first = binarySearchFirst(nums, low, high, target); // O(log n)

        if(first == -1){ // if first is -1, means there is no target at all in our array. If there would have been it would have returned index
            return new int[] {-1, -1};
        }

        // Now our low is first because if we have first and array is sorted, we can reduce search space to find last index.
        int last = binarySearchLast(nums, first, high, target); // O(log m)  

        return new int[] {first, last};
    }
}