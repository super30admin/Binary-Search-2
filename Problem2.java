class Solution {
    public int findMin(int[] nums) {
        // check if length is zer0, then output = -1
        if(nums.length == 0){
            return -1;
        }
        //check if length is 1, then output = nums[0]
        if(nums.length == 1){
            return nums[0];
        }
        // check if array is rotated or not
        if(nums[nums.length-1]>nums[0]){
            return nums[0];
        }
        // if length is 2, then return min out of two
        if(nums.length == 2){
            if(nums[0]<nums[1]){
                return nums[0];
            }
            else{
                return nums[1];
            }
        }
        // intitialzing lo, and hi for binary search
        int lo = 0, hi = nums.length - 1;
        
        while(hi >= lo){
            //finding mid
            int mid = lo + (hi - lo)/2;
            //if mid value is greater than mid + 1, then output is mid + 1
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            // if mid value is lesser than mid - 1 then output is mid
            if(nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            // if value mid is less than num[0], then update lo
            if(nums[mid] < nums[0]){
                hi = mid - 1;
            }
            // if value mid is greater than num[0], then update hi
            else{
                lo = mid + 1;
            }
        }
        return -1;
    }
    
}