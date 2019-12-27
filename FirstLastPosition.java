// Time Complexity : O(logn)
// Space Complexity : Not sure
// Did this code successfully run on Leetcode : No. 21/88 test case pass.
// Any problem you faced while coding this : Yes, Failing for -ve nos.

class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return numbers(-1, -1);
        if(nums.length == 1)
            return nums[0] == target ? numbers(0, 0) : numbers(-1, -1);

        int start = 0, high = 1;
        int beginIndex = -1;
        int endIndex = -1;
        if(nums.length > 2){
            while(target > nums[high]){
                start = high;
                high = high * 2;
            }
        }
        
        while(start <= high){
            int mid = start + (high - start) / 2;
            if(nums[mid] == target){
                beginIndex = mid;
                endIndex = mid;
                while(mid < nums.length && nums[mid] == target){
                    endIndex = mid++;
                }
                return numbers(beginIndex, endIndex);
            } else if(target < nums[mid]){
                high = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return numbers(-1, -1);
    }
    
    public static int[] numbers(int start, int end){
        int[] arr = {start, end};
        return arr;
    }
}