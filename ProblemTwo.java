//Ran on leetcode: Yes
//TC:O(logn)
//SC:O(1)
//Since it is rotated sorted array apply binary search on the sorted half and check if the leftmost element is smallest
class ProblemTwo {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) / 2;
            //left part is sorted then take the first element from left side and ignore rest
            if(nums[mid] >= nums[low]){
                min = Math.min(nums[low], min);
                low = mid + 1;
            } else { //right part is sorted, then take the first element from right side and ignore the rest
                min = Math.min(nums[mid], min);
                high = mid - 1;
            }
        }
        return min;
    }
}