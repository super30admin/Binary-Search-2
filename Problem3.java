// Accepted on LT
// So the idea was to use inequalites to dicide the movement with binary search to get it done in log n time.
class Solution {
    public int findPeakElement(int[] nums) {
        return peeksearch(nums,0,nums.length-1);
        
    }

    public int peeksearch(int[] nums, int l, int h){
        while(l<=h){
            int mid = l + (h-l)/2;
            if((mid == h ||  (nums[mid] > nums[mid+1])) && (mid == 0 || (nums[mid]> nums[mid-1] ) ) ){
                return mid;
            }
            else if(mid > 0 && nums[mid-1]>nums[mid]){
                h = mid-1;
            }
            else{
                l = mid + 1;
            }
        }

        return 331231;
    }
}