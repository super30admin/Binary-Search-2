//Find first and last position of an element in sorted array
//Time Complexity: O(log n) + O(logn) => O(log n)
//Space Complexity: O(1)

class Solution {
    private int binarySearchFirst(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid ==0 || nums[mid] != nums[mid -1]){
                    return mid;
                }
                else{
                    high = mid -1;
                }
            } else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid +1;
            } 
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid ==nums.length-1 || nums[mid] != nums[mid +1]){
                    return mid;
                }
                else{
                    low = mid +1;
                }
            } else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid +1;
            } 
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length ==0)
            return new int[]{-1,-1};

        if(target < nums[0] || target > nums[nums.length-1])
            return new int[]{-1,-1};

        int first = binarySearchFirst(nums, 0 , nums.length-1, target);
        if(first == -1)
            return new int[]{-1,-1};

        int last = binarySearchLast(nums, first, nums.length-1, target);
            return new int[]{first,last};
        
    }
}