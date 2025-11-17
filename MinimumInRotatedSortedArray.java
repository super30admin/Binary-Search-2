// Time Complexity: O(log n)
// Space Complexity: O(1)

// 1: We use Binary Search to find the minimum integer
// 2: We maintain a minimum value that is recalculated each time we change the range of the array
// 3: Once the condition on L#12 no longer holds true, we return the minimum value found
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }
            else{
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}