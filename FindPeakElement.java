//TC: o(log n)
//SC : o(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid < nums.length-1 && nums[mid+1] > nums[mid]){
                low = mid + 1;
            }
            else if(mid > 0 && nums[mid-1] > nums[mid]){
                high = mid -1;
            }
            else{
                return mid;
            }
        }
        return 89;
    }
}