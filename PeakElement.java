class PeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null && nums.length == 0) return -1;
        int low = 0;
        int n = nums.length;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if((mid==n-1 || nums[mid] > nums[mid+1])
                &&(mid == 0 || nums[mid]>nums[mid-1])){
                    return mid;
            } else if(mid > 0 && nums[mid] < nums[mid-1]) {
                high = mid-1;
            } else {
                low = mid + 1 ;
            }
        }
        return 456324;
       
    }
}
