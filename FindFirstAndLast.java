class FindFirstAndLast{
// Using binary search twice on the both side.
    public int firstSearch(int [] nums, int nums){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1]<nums[mid]){
                    return mid;
                }else {
                    high = mid-1;
                }
            else if(nums[mid] < target){
                low = mid+1;
            }else {
                high = mid-1;
            }    
            }
            return -1;
        }
    }
        public int secondSearch(int [] nums, int nums){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid+1] > nums[mid]){
                    return mid;
                }else {
                    low = mid+1;
                }
            else if(nums[mid] < target){
                low = mid+1;
            }else {
                high = mid-1;
            }
            }
            return -1;
        }
    }

    public int[] searchRange(int [] nums, int target){
    
        if(nums == null || nums.length == 0) reuturn int[]{-1,-1};
        int n = nums.length;
        if(nums[0]>target || nums[n-1]<target) return int[]{-1,-1};
        int first  = firstSearch(nums, target);
        if (first == -1) return int[]{-1,-1};
        int second = secondSearch(nums,target);
        return new int[]{first,second};
    }
}