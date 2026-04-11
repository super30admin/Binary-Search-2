class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int n = nums.length;
        int high = n-1;
        while(low<=high){
            if (nums[low]<=nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            else if(nums[mid]>=nums[low]){
                low = mid + 1;
            }else{
                high = mid -1 ;
            }
        }

        return -1;
    }
}

/*There are few things to consider to solve this question - 
(1) The minimum is always on the other side of the sorted half - thats an observation 
(2) Whenever you see that its a sorted array - think of Binary search (also it is  O(logn))
(3) One mistake that i made was while submitting it was to write the following statement - realised when dry run the attempt - if (nums[low]<=nums[high]) return nums[low];
*/ 
