// time - O(log n)
// spac - O(1)
// leetcode ran? - yes
// problem - i got if(nums[mid] == target) part wrong for both binary searches

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int firstOcc = -1, lastOcc = -1;

        // binary search to find the first element
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
            {
                //is it first occurance of the target
                if(mid == 0 || nums[mid - 1] != target)
                {
                    firstOcc = mid;
                    break;
                }
                else
                {
                    right = mid - 1;
                }
            }
            else if(nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        if(firstOcc == -1)
        {
            return new int[]{-1,-1};
        }

        //binary search to find the last element
        left = 0; 
        right = nums.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
            {
                // is it last occurance of the target
                if(mid == nums.length - 1 || target != nums[mid+1])
                {
                    lastOcc = mid;
                    break;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else if(nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        if(lastOcc == -1)
        {
            return new int[]{firstOcc, firstOcc};
        }
        return new int[] {firstOcc, lastOcc};
    }
}