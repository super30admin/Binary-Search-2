// Time Complexity : O(log n)
// Space Complexity : O(1) constance space for array of size 2 to store result
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No this came straightforward

public class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        //declaring result array of size two
        //index 1 is start positing of target, set as -1 assuming target is not found
        //index 1 is end positing of target, set as -1 assuming target is not found
        int[] res = {-1, -1};

        //adding base case
        if(nums == null || nums.length == 0) return res;

        //declare variable for binary search
        int low = 0;
        int high = nums.length - 1;


        while(low <= high){
            int mid = low + (high - low)/2; //to avoid integer overflow
            int start = mid;
            int end = mid;
            if(nums[mid] == target){
                //keeping going until start of element is found
                while(start > 0 && nums[start - 1] == target){
                    start--;
                }
                //keep going until end of element is found
                while(end < nums.length -1 && nums[end + 1] == target){
                    end++;
                }
                res[0] = start;
                res[1] = end;
                return res;

            }else if(target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }
}
