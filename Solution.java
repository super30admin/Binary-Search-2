//Find First and Last Position of Element in Sorted Array
//Time Complexity:2(logn)
//Space Complexity:O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
        {
            return new int[]{-1,-1};
        }
        int n=nums.length;
        if(target<nums[0] || target>nums[n-1])
        {
            return new int[]{-1,-1};
        }
        int first=leftBinarySearch(nums,target);
        if(first==-1)
        {
            return new int[]{-1,-1};
        }
        int last=rightBinarySearch(nums,first,n-1,target);
        return new int[]{first,last};

    }
    private int leftBinarySearch(int[] nums, int target)
    {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==0 || nums[mid-1]<target)
                {
                    return mid;//this is the first occurance
                }
                else
                {
                    //move to left to get first occurance
                    high=mid-1;
                }

            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;

    }
    private int rightBinarySearch(int[] nums,int low,int high,int target)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if((nums[mid]==target))
            {
                if(mid==nums.length-1 || nums[mid+1]>nums[mid])
                {
                    return mid;//last occurance
                }
                else
                {
                    //move to right to get last element
                    low=mid+1;
                }

            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}