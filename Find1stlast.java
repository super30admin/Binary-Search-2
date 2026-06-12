// Explain your approach in **three sentences only** at top of your code: binary search to find the first occurrence of the target, if not found return [-1,-1]. If found, use the index of the first occurrence as the starting point to perform another binary search to find the last occurrence of the target. Return the indices of the first and last occurrences as an array.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        

        int first = binarySearchFirst(nums, target, 0, nums.length-1);

        if(first == -1) return new int[]{-1,-1};

        int last = binarySearchLast(nums, target, first, nums.length-1);

        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}

