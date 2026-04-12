// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    private int binarySearch(int[] arr, int target, boolean flag, int low)
    {
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid]==target){
                if(flag == false && (mid == 0 || arr[mid - 1] < target))
                {
                    return mid;
                }
                if(flag && (mid == high || arr[mid + 1] > target))
                {
                    return mid;
                }
            }
            if(arr[mid] < target){
                low = mid + 1;
            }
            else if(flag == true && arr[mid] == target){
                low = mid + 1;
            }
            else
            {
                high = mid -1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums,target,false,0);
        if(first == -1){
            return new int[]{-1, -1};
        }
        int last = binarySearch(nums,target,true,first);
        return new int[]{first,last};
    }
}