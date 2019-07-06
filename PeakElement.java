class PeakElement {
    
    public int findPeakHandler(int[] nums, int low, int high){
       
        int mid = low + (high - low)/2;

        if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])){
            return mid;
        }

        if(mid > 0 && nums[mid] < nums[mid-1]){
            return findPeakHandler(nums, low, mid-1);
        }
        else{
            return findPeakHandler(nums, mid+1, high);
        }
    }
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        if(nums.length == 2){
            return nums[0] >= nums[1] ? 0 : 1;
        }
        int result = findPeakHandler(nums, 0, nums.length-1);        
        return result;   
    }

    
    public static void main(String[] args){
        System.out.println("Peak Element Implementation");
        PeakElement obj = new PeakElement();
        int[] nums = {3,4,3,2,1};
        System.out.println(obj.findPeakElement(nums));
    }
}