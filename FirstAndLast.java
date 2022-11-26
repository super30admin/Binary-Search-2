//Time Complexity: O(logn)
//Space Complexity: O(1)

/*
 * We first find the left postion and then the right using binary search.
 * In binary search if the mid is the target element we get the first 
 * element using the binary search and do the same for last element.
*/

public class FirstAndLast {
    public int binarySearchLeft(int[] nums, int low, int high, int target){
        while (low <= high){
            int mid = low + (high-low)/2;
            if (nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    public int binarySearchRight(int[] nums, int low, int high, int target){
        int n = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == n || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        int n = nums.length;
        if(nums[0] > target || nums[n-1] < target) return new int[] {-1,-1};
        int left = binarySearchLeft(nums, 0, n-1, target);
        if (left == -1) return new int[]{-1,-1};
        int right = binarySearchRight(nums, left, n-1, target);
        return new int[] {left, right};
                
        }
}