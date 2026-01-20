class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int i=-1,j=-1;
        int [] res=new int []{-1,-1};



        while(low<=high)
        { 
            int mid=low+(high-low)/2;

            if(nums[mid]==target)
            {
                i=mid;
                high =mid-1;

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

        res[0]=i;
        low=0;
       high=n-1;
        while(low<=high)
        { 
            int mid=low+(high-low)/2;

            if(nums[mid]==target)
            {
                j=mid;
                low =mid+1;

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

        res[1]=j;

        return res;


        
    }
}