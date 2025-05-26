//time complexity = O(log(n))
//space complexity = O(1)
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low<=high)
        {
            if(nums[low]<=nums[high])
            {
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if(mid!=0 && nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            else if(nums[low] <= nums[mid])
            {
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}
//Find First and Last Position of Element in Sorted Array
//Time complexity = 2 Log(n)
//Space Complexity = O(1)
class Solution1 {
    private int binarySearchFirst(int[] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
            {
                if(mid == 0 || nums[mid]> nums[mid-1])
                {
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums[mid]< target)
            {
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
            {
                if(mid == nums.length -1 || nums[mid] < nums[mid+1])
                {
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[mid]< target)
            {
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return new int [] {-1,-1};
        }
        int n = nums.length;
        int []arr = new int[2];
        if(target < nums[0] || target > nums[n-1])
        {
            return new int [] {-1,-1};
        }
        int firstIdx = binarySearchFirst(nums, 0, n-1, target);
        if(firstIdx == -1)
        {
            return new int [] {-1,-1};
        }
        int secondIdx = binarySearchLast(nums, firstIdx, n-1, target);
        return new int [] {firstIdx,secondIdx};
    }
}

//Find Peak Element
//Time Complexity = O(log(n)
//Space Complexity = O(1)
class Solution2 {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid]> nums[mid-1]) && (mid == n-1|| nums[mid]> nums[mid+1]))
            {
                return mid;
            }
            else if(mid != n-1 && nums[mid]< nums[mid+1])
            {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return 9999;
    }
}