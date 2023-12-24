// Time Complexity : O(logn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class FirstLastElement {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int []{-1,-1};
        int n = nums.length;
        int left = binarysearchLeft(nums, 0,n-1, target);
        if(left == -1)
             return new int []{-1,-1};
        int right = binarysearchRight(nums, left,n-1, target);
        return new int[]{left,right};


    }
    public int binarysearchLeft(int [] nums, int low, int high, int target)
    {
        int mid = 0;
        while (low <=high)
        {
            mid = low + (high-low)/2;
            if(nums[mid] == target )
            {
           if(mid == 0 || nums[mid] > nums[mid-1])
                return mid;
            else
            {
                 //keep moving left
                high = mid-1;
            }
            }
            else if(nums[mid] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid +1;
            }

        }
        return -1;
    }
        public int binarysearchRight(int [] nums, int low, int high, int target)
    {
        int mid = 0;
        while (low <=high)
        {
            mid = low + (high-low)/2;
            if(nums[mid] == target )
            {
           if(mid ==  nums.length-1 || nums[mid] < nums[mid+1])
                return mid;
            else
                low=mid+1;
            }
            else if(nums[mid] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid +1;
            }

        }
        return -1;
    }

    public static void main(String[] args)
    {
        int [] nums = {5,7,7,8,8,10};
        FirstLastElement f =new FirstLastElement();
        System.out.println(f.searchRange(nums,8)[0]+ " "+f.searchRange(nums,8)[1]);
    }
}
