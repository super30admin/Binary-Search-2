// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Implement two binary search functions, one to find the first occurrence of the target and the other to find the last occurrence.
// 2. For finding the first occurrence:
//    - If mid element equals the target, check if it's the first occurrence by verifying if it's either the first element or the element before it is less than the target.
//    - If mid element is greater than the target, move to the left half of the array.
//    - If mid element is less than the target, move to the right half of the array.
// 3. For finding the last occurrence:
//    - If mid element equals the target, check if it's the last occurrence by verifying if it's either the last element or the element after it is greater than the target.
//    - If mid element is greater than the target, move to the left half of the array.
//    - If mid element is less than the target, move to the right half of the array.
// 4. Use the first occurrence index as the starting point for the search for the last occurrence.
// 5. Return the indices of the first and last occurrences of the target.


class FindFirstAndLastElementOfSortedArray {
    private int binarySearchFirst(int[] nums, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid] == target)
            {
                //check mid is first occurence
                if(mid ==0 || nums[mid] > nums[mid-1])
                {
                    return mid;
                }
                else
                {
                    high = mid-1; // keep moving left
                }
            }
            else if(nums[mid] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid] == target)
            {
                //check mid is last occurence
                if(mid == high || nums[mid] < nums[mid+1])
                {
                    return mid;
                }
                else
                {
                    low = mid+1; // keep moving right
                }
            }
            else if(nums[mid] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return new int[]{-1,-1};
        }
        int n = nums.length;
        int first = binarySearchFirst(nums, 0, n-1, target);
        if(first == -1)
        {
            return new int[]{-1,-1}; // does not exist
        }
        int last = binarySearchLast(nums, first, n-1, target);
        return new int[]{first, last};
    }
}
