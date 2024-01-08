class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = (high-low)/2;

        int start = 0;

        // finding start of range
        while(low < high){
            if(nums[mid] < target){
                low = mid+1;
            } else if(nums[mid] > target){
                high = mid-1;
            } else {
                if(mid-1 > -1 && nums[mid-1] == target) {
                    high = mid-1;
                } else {
                    low = mid;
                    break;
                }
            }
            mid = low + (high-low)/2;
        }


        if(low > -1 && low < nums.length && nums[low] == target){
            start = low;
        } else return new int[] {-1,-1};

        // finding end of range
        int end = start;
        low = start+1;
        high = nums.length-1;


        while(low < high){
            if(nums[mid] < target){
                low = mid+1;
            } else if(nums[mid] > target){
                high = mid-1;
            } else {
                if(mid+1 < nums.length && nums[mid+1] == target) {
                    low = mid+1;
                } else {
                    low = mid;
                    break;
                }
            }
            mid = low + (high-low)/2;
        }

        if(low < nums.length && nums[low] == target){
            end = low;
        }

        return new int[] {start, end};
    }
}
