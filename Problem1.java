// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Confused about the situations where we have to return [-1, -1].
// Approach: Perform 2 binasry searches. 1 for finding the first index of the target element and 2 for the last index for the target element
//           If the target is not found in the first binary search than return [-1, -1]
//           Or else, find the last index of the target by erformong the second binary search and return the indexes.
class Problem1 {
    private int bs1(int [] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid == 0 || arr[mid] > arr[mid -1]){
                    return mid;
                } else{
                    high = mid -1;
                }
            } else if(arr[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }
    private int bs2(int [] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid == arr.length-1 || arr[mid+1] > arr[mid]){
                    return mid;
                } else{
                    low = mid + 1;
                }
            } else if(arr[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(nums == null || n == 0) return new int[]{-1, -1};
        if(target < nums[0]) return new int[]{-1, -1};
        if(target > nums[n-1]) return new int[]{-1, -1};
        int first = bs1(nums, 0, n-1, target);
        if(first == -1) return new int[]{-1, -1};
        int second = bs2(nums, first, n-1, target);
        return new int[]{first, second}; 
    }
}