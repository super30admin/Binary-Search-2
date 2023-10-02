
// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// If array is empty return -1,-1 as start and end position

// If the first element  of the array is greater than target or last element is less than the target, then it is guaranteed
// that the target is not found in the array as it is sorted.  IF that is the case return -1-1 as start and end position

// The first and last position of a given target (range) can be found by applying Binary Search on finding the firstPosition
// If the target's first position is found, we can use first position to find the last position starting from the first position



public class FindFirstAndLastPositionOfTargetInSortedArray {
    public int[] searchRange(int[] nums, int target)
    {
        if(nums.length == 0) return new int[] {-1,-1}; //array empty
        int low = 0;
        int high = nums.length-1;
        //check the first and last elements values.
        // if first element is bigger than target, since it is a sorted array
        // the target will not be in the array.  Similarly, if the last element
        // is less than target then also the target is not in the array.  Hence, return -1,-1
        // no need to perform any search.
        if (nums[low] > target || nums[high] < target) {
            return new int[] {-1,-1};
        }
        // Find the start range of the target
        int firstPosition = binarySearchFirstPosition(nums, low,high, target);
        int secondIdx;
        // If firstPosition not find, target is not in the first half, return -1,-1
        if (firstPosition == -1)
            return new int[]{-1, -1};
        else // use the firstPosition as low and high  to find lastPosition of the target range
            secondIdx = binarySearchLastPosition(nums, firstPosition, high, target);
        // both first and last positions of the target range found return those values
        return new int[]{firstPosition, secondIdx};

    }

    public int binarySearchFirstPosition(int[] nums, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2; //handle integer overflow
            if(nums[mid] == target)
            {
                if(mid > 0 && nums[mid-1] == target)
                    high = mid-1;
                else
                    return mid;
            }
            else if (nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public int binarySearchLastPosition(int[] nums, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
            {
                if(mid < nums.length-1 && nums[mid+1] == target)
                    low = mid+1;
                else
                    return mid;
            }
            else if (nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}



