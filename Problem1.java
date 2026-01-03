//Problem: Find First and Last Position of Element in Sorted Array
// Time Complexity: O(log n) as we perform two independent binary searches.
// Space Complexity: O(1) as we are using a constant amount of extra space.

/*
Approach:
The solution uses two modified binary searches to find the starting and ending indices of the target.
The first search finds the leftmost occurrence by checking if the element before it is different, while the second search finds the rightmost occurrence by checking the element after it.
If the first occurrence isn't found, we immediately return [-1, -1] to optimize the process.
*/
class Solution {
    private int binarySearchFirst(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                // is the first occurance then return mid
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }else{
                    // keep moving left
                    high = mid -1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                // is the last occurance then return mid
                if(mid == (nums.length - 1) || nums[mid+1] != target){
                    return mid;
                }else{
                    // keep moving right
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
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
        int high = n -1;
        // if the target is out of range of the array
        if(n==0 || nums[low] > target || nums[high] < target){
            return new int[]{-1,-1};
        }
        // Perform binary search to find the first occurrence
        int first = binarySearchFirst(nums, target, low, high);
        // if we don't find the first occurance, then no need to do second binary search
        if(first == -1){
            return new int[]{-1,-1};
        }
        // Perform binary search for the last occurrence starting from the first index found
        int last = binarySearchLast(nums, target, first, high);
        // return the first and last position
        return new int[]{first,last};
    }
}