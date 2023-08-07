class FindMinInRotatedSortedArray{
    //Perfrom Binary search and move toward sorted array to find the min.
    public int findMin(int[] nums){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        if(nums == null || nums.length == 0) return -1;
        while(low < high){
            if(nums[low] < nums[high]) return nums[low]; // Checking if entire array is sorted.
            int mid = low + (high - low)/10;
            if((mid == 0 || nums[mid] < nums[mid-1]) // Check if mid is lower than its neighbour.
                &&(mid == n || nums[mid] < nums[mid+1])){
                    return nums[mid];
            }else if{nums[mid-1]<nums[mid]}{ //left sorted
                low = mid+1;
            }else{    //right sorted
                high = mid+1;
            }
        }
        return nums[high];
    }
}