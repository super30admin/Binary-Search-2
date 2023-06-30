// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class FirstAndLastPositionOfElement {

    public int[] searchRange(int[] nums, int target) {

        int result[] = new int[2];

        result[0] = -1;
        result[1] = -1;


        int count = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == target)
            {
                count++;

                if(count == 1)
                {
                    result[0] = i;
                }

                result[1] = i;

            }

        }

        return result;

    }

}
