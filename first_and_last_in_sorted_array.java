//TC:O(n)
//SC:O(n)
//solved in leetcode:YES
class Solution {

    public  int binarySearchFirst(int[] arr,int target)
    {
        int low = 0;
        int high = arr.length-1;



        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid] == target)
            {
                // check whether mid is the first occurence
                // if arr[mid]>arr[mid-1], it means 1st occ is mid, else move left to get 1st occurence
                if(mid==0||arr[mid]>arr[mid-1])
                {
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else if(arr[mid]>target)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }

        }
        return -1;
    }

    public int binarySearchLast(int[] arr,int target,int low)
    {
        int high = arr.length-1;



        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid] == target)
            {
                // check whether target is the last occurence
                // if arr[mid]>arr[mid-1], it means 1st occ is mid, else move left to get 1st occurence
                if(mid==arr.length-1||arr[mid]<arr[mid+1])
                {
                    return mid;
                }
                else{
                    low=mid+1;
                }
            }
            else if(arr[mid]>target)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }

        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchFirst(nums,target);

        if(first==-1)
        {

            return new int[]{-1,-1};
        }
        else
        {
            int last = binarySearchLast(nums,target,first);

            return new int[]{first,last};
        }
    }
}