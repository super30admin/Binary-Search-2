/*
approach-1
linearly check for all the adjacent  elements. TC:O(n), sc:O(1)
*/

/*
approach-2
binary search
if mid is greater to adjacent elemnt, well return mid
if mid is lesser than right adjacent, we move right, as there are chaces of finding peak
else we go left
Questions says - in any case, the boundary element will always represent peak!!
cosndering -infinity on both sides
*/
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == low || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1]))
                return mid;
            else if (nums[mid] <= nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}