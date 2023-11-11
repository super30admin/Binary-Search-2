//Time complexity : o(log n)
//Space Complexity : O(1)
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length -1;
        while(low <= high){
            if(nums[low]<=nums[high]) return nums[low];
            int mid = low+(high - low)/2;
            if((mid == low || nums[mid] < nums[mid -1])&&(mid == high || nums[mid]<nums[mid+1]))
                return nums[mid];
            //left sorted    
            else if(nums[low]<=nums[mid])
                low = mid+1;
            //right sorted    
            else
                high = mid -1;
        } 
        return 98980;   
    }
}