//TC : o(log n)
//SC: o(1)

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        if(nums[low] <= nums[high]){
            return nums[low];
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid >0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            else if(nums[mid] > nums[high]){ // left array is sorted
                low = mid + 1;
            }
            else{
                high = mid -1;
            } 
        }
        return 89;
    }
}