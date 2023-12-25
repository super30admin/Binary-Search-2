class Solution {

    private int binarySearchLeft(int[] nums, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(mid == 0 || nums[mid] > nums[mid - 1] )
                {
                    return mid;
                }
                else
                {
                    //keep moving left
                    high = mid - 1;
                }
            }
            else if(target < nums[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }


    private int binarySearchRight(int[] nums, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1] )
                {
                    return mid;
                }
                else
                {
                    //keep moving right
                    low = mid + 1;
                }
            }
            else if(target < nums[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }


    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int n = nums.length;
        int left = binarySearchLeft(nums, target, 0, n-1);
        if(left == -1) return new int[]{-1, -1};
        int right = binarySearchRight(nums, target, left , n - 1);
        return new int[]{left, right};

    }
    }
    
