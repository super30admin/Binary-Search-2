class findPeak {
    public int findPeakElement(int[] nums) {
        int start=0;
        //int l = nums.length;
        int end = nums.length-1;
        int mid;
        
        while(start <= end){
            mid = start + (end - start) / 2;
            if((mid == nums.length-1 || nums[mid] > nums[mid+1]) && (mid == 0 || nums[mid] > nums[mid-1]))
                return mid;
            else if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                start = mid + 1;
            else
                end = mid - 1;
            }
        return -1;
    }
}