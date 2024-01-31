class Solution {
    private int binarysearch_1(int []arr,int low,int high,int target)
    {
        int mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                if(mid==0||arr[mid]>arr[mid-1])
                return mid;
                else
                high=mid-1;
           }
else if(arr[mid]>target)
high=mid-1;
else
low=mid+1;
        }
        return -1;

    }
     private int binarysearch_2(int []arr,int low,int high,int target)
    {
        int mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                if(mid==arr.length-1||arr[mid]<arr[mid+1])
                return mid;
                else
                low=mid+1;
           }
else if(arr[mid]>target)
high=mid-1;
else
low=mid+1;
        }
        return -1;

    }
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0)
        return new int[]{-1,-1};
        int size=nums.length;
        if(nums[0]>target||nums[size-1]<target)
        return new int[]{-1,-1};
        int lower=binarysearch_1(nums,0,size-1,target);
        if(lower==-1)
        return new int[]{-1,-1};
        int upper=binarysearch_2(nums,lower,size-1,target);
        return new int[]{lower,upper};
    }
}