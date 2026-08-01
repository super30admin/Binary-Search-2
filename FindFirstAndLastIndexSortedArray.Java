// To find the first index, we check if the mid of the array is target and if so, verify its immediate left neighbour is also the target
// and perform the binary search towards the left side until we find the index
// Similary to find the last index, we check if the mid of the array is the target and if so, verify if its immdediate right neighbour is also the target
// and perform the binary searach towards the right side until we find the index

//Time Complexity   - O(logn)
// Space Complexity - O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int first = binarySearchFirst(nums, 0, nums.length-1, target);
        if (first == -1) return new int[] {-1, -1};

        int last = binarySearchLast(nums, first, nums.length-1, target);

        return new int[] {first, last};


    }

    private int binarySearchFirst(int[] nums, int low, int high, int target)
    {
        while (low <= high)
        {
            int mid = low + (high - low)/2;

            if (nums[mid] == target)
            {
                if (mid == low || nums[mid] != nums[mid-1]){
                    return mid;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else if (nums[mid] > target)
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

    private int binarySearchLast(int[] nums, int low, int high, int target)
    {
        while (low <= high)
        {
            int mid = low + (high - low)/2;

            if (nums[mid] == target)
            {
                if (mid == high || nums[mid] != nums[mid+1]){
                    return mid;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else if (nums[mid] > target)
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
}