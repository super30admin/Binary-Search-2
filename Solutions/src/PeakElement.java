
// Time Complexity :
//O(logN)
// Space Complexity :
//O(1)
// Did this code successfully run on Leetcode : No. Failed many testcases.
// Any problem you faced while coding this : Failed the increasing order and decreasing ordered array testcase.


// Your code here along with comments explaining your approach

class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums==null || nums.length == 0){
            return -1;
        }
        if (nums.length ==1){
            return 0;
        }
        if (nums.length ==2){
            if (nums[0]>nums[1]){
                return 0;
            }
            else{
                return 1;
            }

        }
        if (nums.length ==3 && nums[0]<nums[1] && nums[1]>nums[2]){
            return 1;
        }
        int low = 0;

        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            // if(nums.length ==3 && nums[mid-1]>nums[mid] && nums[mid-1]>=nums[mid+1]){
            //     return mid-1;
            // }
            // if(nums.length ==3 && nums[mid+1]> nums[mid] && nums[mid+1]>=nums[mid-1]){
            //     return mid+1;
            // }
            //Case 1: Peak element found
            if ((mid+1<nums.length && (nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) && mid -1>0)||(nums[mid]>nums[mid-1] && mid+1>nums.length) || (nums[mid]>nums[mid+1]) && mid-1 <0 ){
                return mid;
            }


            if (nums[mid]<nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}