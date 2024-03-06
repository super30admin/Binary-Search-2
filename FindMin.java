// Time Complexity O(log n)
// Space Complexity O(1)

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;

        if (nums.length == 0) return -1;

        while (l <= h) {
            if (nums[l] <= nums[h]) return nums[l];

            int mid = l + (h-l)/2;
            if (mid !=0 && nums[mid] < nums[mid-1]) {return nums[mid];}

            else if (nums[l] <= nums[mid]) {
               l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return 999;
    }
}




