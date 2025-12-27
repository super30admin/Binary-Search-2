// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : coming up with the logic, and check when to stop in both first and last index
// Time constarint

// Your code here along with comments explaining your approach in three sentences only
class FirstLastInArray {
    public int[] searchRange(int[] nums, int target) {
        //First edge case if array len is 0
        if(nums.length==0)
        {
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = nums.length -1;
        //edge case if target lies out of range
        if(target<nums[start] || target>nums[end] )
        {
            return new int[]{-1,-1};
        }
        int firstIndex = findFirstIndex(nums,target,start,end);
        int lastIndex = findLastIndex(nums,target,start,end);
        return new int[]{firstIndex,lastIndex};
    }

    //Finds the first target element in sorted array
    private int findFirstIndex(int[] nums,int target,int start,int end)
    {
        int index = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            //can't move left further when mid is already start or mismatch
            if(nums[mid]==target && (mid==start || nums[mid-1]!=nums[mid]))
            {
                index = mid;
                break;
            }
            //can move left further
            else if(nums[mid]==target)
            {
                end = mid -1;
            }
            //Same for finding element in sorted binary serach
            else if(target<nums[mid])
            {
                end = mid - 1;
            }else
            {
                start = mid + 1;
            }
        }
        return index;

    }

    private int findLastIndex(int[] nums,int target,int start,int end)
    {
        int index = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            //if mid is target and you can't move right further
            if(nums[mid]==target && (mid==end || nums[mid]!=nums[mid+1]))
            {
                index = mid;
                break;
            }
            //can move right further, start = mid +1
            else if(nums[mid]==target)
            {
                start = mid+1;
            }
            //Same for finding element in sorted binary serach
            else if(target<nums[mid])
            {
                end = mid - 1;
            }else
            {
                start = mid + 1;
            }
        }
        return index;
    }
}