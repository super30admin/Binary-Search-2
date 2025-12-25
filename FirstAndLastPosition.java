// Approach:
// There is a chance that the target value starts in the first half of the array and ends in second half of the array.
// So we will need to search in both half of the input array. We can run 1 binary search operation on the left side to
// find the start and other binary search on right side to find end index.
// For cases where target start and end are on the one side of the array, we compare the target with the value at mid
// and update point the low/high to that side of the array.
public class FirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] result = {-1, -1};
        if(len == 0) return result;
        if(len == 1) return nums[0] == target ? new int[]{0,0} : result;

        int low = 0;
        int high = len-1;
        int startIndex = Integer.MAX_VALUE;
        int endIndex = Integer.MIN_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                startIndex = Math.min(startIndex, mid);
                high = mid-1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        low = 0;
        high = len-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                endIndex = Math.max(endIndex, mid);
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        if(startIndex == Integer.MAX_VALUE){
            return result;
        }
        result = new int[]{startIndex, endIndex};
        return result;
    }
}
