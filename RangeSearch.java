class RangeSearch {
    public int firstOccurance(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if( mid == low ||  nums[mid - 1] < nums[mid]) return mid;
                else high = mid - 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else low = mid + 1; 
        }
        return -1; 
    }
    public int secondOccurance(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] > target) return mid;
                else low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else low = mid + 1; 
        }
        return -1; 
    }
    public int[] searchRange(int[] nums, int target) {
        int left = firstOccurance(nums, 0, nums.length - 1, target);
        int right = secondOccurance(nums, 0, nums.length - 1, target);
        return new int[] {left,right};
    }
}