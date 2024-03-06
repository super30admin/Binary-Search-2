// Time Complexity O(log n)
// Space Complexity O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int l = 1;
        int h = n - 2;

        if (nums.length == 1) {return 0;}
        if (nums[0] > nums[1]) {return 0;}
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        while (l <= h) {
            int mid = l + (h - l)/2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            else if (nums[mid] < nums[mid - 1]){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}