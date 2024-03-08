// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Initialize low as 0 and high as n-1, where n is the length of the input array.
// 2. Check if the array is already sorted. If so, return the first element as the minimum.
// 3. Perform binary search to find the minimum element.
// 4. At each step, check if the mid element is less than its previous element (mid-1).
// 5. If it is, then mid is the minimum element, return it.
// 6. If not, determine whether the left half or right half is sorted.
// 7. Adjust low and high pointers accordingly and continue the search.
// 8. Repeat steps 3-7 until low is less than or equal to high.
// 9. Return any valid minimum element found during the binary search.


class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int n = nums.length;
        int low=0;
        int high = n-1;
        while(low <= high)
        {
            //checking if complete arr is sorted
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high-low)/2;

            // check mid is min or not
            if(mid != 0 && nums[mid] < nums[mid-1])
            {
                return nums[mid];
            }
            else if(nums[low] <=nums[mid])
            {
                //left sorted
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return 799;
    }
}