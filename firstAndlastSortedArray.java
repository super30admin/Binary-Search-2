// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class firstAndlastSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = findFirstIndex(nums, target);
        result[1] = findLastIndex(nums, target);
        return result;
    }
    
    public static int findFirstIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid;
        int index = -1;
        while(start<=end) {
            mid = start + (end-start)/2;
            
            if(nums[mid]==target)
                index = mid;
            if(nums[mid] >= target)
                end = mid-1;
            else
                start = mid+1;
        }
        return index;  
    }
    
    public static int findLastIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid;
        int index = -1;
        while(start<=end) {
            mid = start + (end-start)/2;
            
            if(nums[mid]==target)
                index = mid;
            if(nums[mid] <= target)
                start = mid+1;
            else
                end = mid-1;
                
        }
        return index;  
    }

    public static void main(String args[]) {
        int numbers[] = {15,7,7,8,8,8,8,10};
        int res[] = new int[2];
        res = searchRange(numbers, 8);
        System.out.println("The first and last index of the target: " + res[0] + " " + res[1]);
    }
}
