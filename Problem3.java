//Problem 3: Find Peak Element
// Time Complexity: O(log n) as we are using binary search to halve the search space.
// Space Complexity: O(1) since we only use a constant amount of extra space for pointers.

/*
Approach:
We use a binary search to find a peak by comparing the middle element with its neighbors.
If the middle element is greater than both its neighbors, it is a peak; otherwise, we move towards the side of the greater neighbor, as a peak is guaranteed to exist in that direction.
This logic works because the boundaries are considered negative infinity, ensuring at least one peak exists.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(( mid == 0 || nums[mid] > nums[mid - 1] ) && ( mid == (nums.length -1 ) || nums[mid] > nums[mid + 1])){
                return mid;
            }
            // Move towards the side that has a greater neighbor
            if( mid != 0 && (nums[mid - 1] > nums[mid + 1])){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return 123456;
    }
}