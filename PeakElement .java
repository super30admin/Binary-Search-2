class PeakElement {
    public int findPeakElement(int[] nums) {
        
        int left  = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left+(right-left)/2;
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            }else if(mid != nums.length && nums[mid+1] > nums[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return -1;
    }
}