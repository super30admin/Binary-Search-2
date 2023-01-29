//Problem 153

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low]<nums[high]) return nums[low]; // already sorted array
            if((mid==0||nums[mid-1]>nums[mid]) && (mid==n-1||nums[mid+1]>nums[mid])){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){ //left sorted, min lies to the right
                low = mid+1;
            }
            else{
                high = mid-1;
            }
            
        }
        return -1;
    }
}
