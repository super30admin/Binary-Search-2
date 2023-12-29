//TC Ologn
//SC O(1)
class Peak {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;

            if((mid==0 || nums[mid-1]<nums[mid]) &&
                    ( mid==nums.length-1 || nums[mid+1]<nums[mid])){
                return mid;
            }
            else if(mid>0 && nums[mid-1]>nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}
