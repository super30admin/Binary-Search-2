// Time Complexity : O(log(n)) as we're halving the list during each iteration  (O(log(n) + log(n/2) + log(n/2))
// Space Complexity : O(1) as we're not using any auxiliary data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachgi
class FirstAndLastPosition
{
    private int firstIndex;
    private int lastIndex;

    public FirstAndLastPosition()
    {
        firstIndex = -1;
        lastIndex = -1;
    }

    public int[] searchRange(int[] nums, int target)
    {
        int[] result = {firstIndex, lastIndex};

        //first try to find the target at any index in the array
        if(nums.length == 0)
        {
            return result;
        }

        int low = 0;
        int high = nums.length -1;

        if(!binarySearch(low, high, nums, target, true))
        {
            //target is not present
            return result;
        }

        binarySearch(0, firstIndex-1, nums , target, false);
        binarySearch(lastIndex + 1, nums.length -1, nums, target, false);

        result[0] = firstIndex;
        result[1] = lastIndex;

        return result;
    }

    private boolean binarySearch(int low, int high, int[] nums, int target, boolean firstSearch)
    {
        while(low <= high)
        {
            //first try to find the firstIndex
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(firstIndex == -1 || firstIndex > mid)
                {
                    firstIndex = mid;
                    high = mid -1;
                }
                if(lastIndex < mid)
                {
                    lastIndex = mid;
                    low = mid +1;
                }
                if(firstSearch)
                {
                    return true;
                }
            }
            else if(target < nums[mid])
            {
                high = mid -1;
            }
            else
            {
                low = mid +1;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        FirstAndLastPosition obj = new FirstAndLastPosition();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = obj.searchRange(nums, target);
        System.out.println(result[0] + ", " +result[1] );
    }


}