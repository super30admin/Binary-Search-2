
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int left = 0;

        int right = nums.length - 1;

        while(left < right)
        {
            int midpoint = left + (right - left) / 2;


            if(nums[midpoint] > nums[right])
            {

                // pivot is towards the right

                left = midpoint + 1;
            }

            else
            {

                // pivot is towards the left

                right = midpoint;
            }


        }

        return nums[left];


    }

}
