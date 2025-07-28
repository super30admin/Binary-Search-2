// Time Complexity: O(log n) for both left and right boundary searches → Overall: O(log n)
// Space Complexity: O(1) — no extra space used except variables
// Did this code run on LeetCode? Yes
// Any problems faced while coding this? No

//Approach:
//I apply binary search twice — once to find the leftmost (first) occurrence of the target, and once to find the rightmost (last) occurrence.
//- While searching for the left boundary, if I find the target, I continue searching in the left half (i.e., high = mid - 1) because it might not be the first occurrence.
//- Similarly, for the right boundary, upon finding the target, I continue searching right (i.e., low = mid + 1) to ensure I capture the last occurrence.

public class FirstAndLastPosition {
    public int findLeftBoundary(int[] nums, int target){
        int index = -1, low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                index = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return index;
    }

    public int findRightBoundary(int[] nums, int target){
        int index = -1, low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                index = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target){
        int left = findLeftBoundary(nums, target);
        int right = findRightBoundary(nums, target);

        return new int[]{left, right};
    }
}
