// We check if if value at mid is less than value at mid + 1, 
// then we know that peak must be to the right side (because nums[-1] = nums[n] = -infinity)
//Else, move towards left and apply the same logic until left and right pointer become equal

class Solution {
    public int findPeakElement(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

       while (left < right) {
        int mid = left + (right-left)/2;

        if (nums[mid] < nums[mid+1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
       }
       return left;
       }
}

// Time complexity: O(logn)
// Space complexity: O(1)