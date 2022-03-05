class Solution1 {
    private int binSearchLeft(int[] nums, int target, int low, int high)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid-1] < target)
                    return mid;
                else
                    high = mid-1;
            }
            else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
    private int binSearchRight(int[] nums, int target, int low, int high)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid+1] > target)
                    return mid;
                else
                    low = mid+1;
            }
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int first, last;
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        first = binSearchLeft(nums, target, 0, nums.length-1);
        if(first == -1)
            return new int[] {-1,-1};
        last = binSearchRight(nums, target, first, nums.length-1);
        int[] soln = {first, last};
        return soln;
    }
}

class Solution2 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length -1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[low] <= nums[high])
                return nums[low];
            else if((mid == nums.length - 1 || nums[mid] < nums[mid+1]) && (mid == 0 || nums[mid] < nums[mid-1]))
                return nums[mid];
            else if(nums[mid] >= nums[low])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}

class Solution3 {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid == nums.length-1 || nums[mid] > nums[mid+1]) && (mid == 0 || nums[mid] > nums[mid-1]))
                return mid;
            else if(nums[mid] < nums[mid+1])
                low = mid+1;
            else
                high = mid-1;
        }
        return 99;
    }
}