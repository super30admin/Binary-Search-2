// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Initialize low as 0 and high as n-1, where n is the length of the input array.
// 2. Perform binary search on the array to find the peak element.
// 3. Check if the element at the mid index is greater than its neighbors.
// 4. If it is, return the mid index as the peak element.
// 5. Otherwise, move towards the side with a higher value neighbor.
// 6. Repeat steps 2-5 until low is less than or equal to high.
// 7. Return any valid peak index found during the binary search.



class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low =0;
        int high = n-1;

        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if((mid == 0 || nums[mid] > nums[mid-1] )&& (mid == n-1 || nums[mid] > nums[mid+1]))
            {
                return mid;
            }
            else if(mid != 0 && nums[mid-1] > nums[mid])
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
    return 89;
    }
}