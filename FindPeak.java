class FindPeak {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        
        while(low<=high){
            
            mid = high - (high - low)/2;
            
            if((mid == 0 || nums[mid-1]< nums[mid]) && (mid == nums.length -1 || nums[mid] > nums[mid+1]))
                return mid;
            
            if( mid != 0 && nums[mid-1] > nums[mid] ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            
            
        }
        return 8989898;
    }

    public static void main(String args[]){
        FindPeak findPeak = new FindPeak();
        int[] nums = {1,2};
        System.out.println(findPeak.findPeakElement(nums));
    }
}