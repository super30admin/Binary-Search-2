/**time complexity O(log n)
 * space complexity O(1)
 * Did this code successfully run on Leetcode : yes
 * Did you face any problem while coding this : no
 */

/**
 * First find the occurrence of the target using binary search ie., when mid==target is first met.
 * If found, then find the last occurrence using binary search again by moving the start pointer to the right of the occurrence.
 * If found then find the first occurrence using binary search again by moving the end pointer to the left of the occurrence.
 * If not found return -1,-1
 */

class firstandLastSortedarray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[]{-1,-1};
        ans[0]=BinarySearch(nums,target,true);
        if(ans[0]!=-1)
        {
            ans[1]=BinarySearch(nums,target,false);
        }
        return ans;

    }

    public int BinarySearch(int[] nums,int target, boolean startelement)
    {
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]<target)
                start=mid+1;
            if(nums[mid]>target)
                end=mid-1;
            if(nums[mid]==target)
                {
                    ans=mid;
                    if(startelement)
                    {
                        end=mid-1;
                    }
                    else
                    {
                        start=mid+1;
                    }
                }
            }
        return ans;
    }
}