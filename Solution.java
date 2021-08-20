class Solution {
    public int findPeakElement(int[] nums) {

        if( nums.length == 1){
            return 0;
        }

        if (nums[0]>nums[1]){
            return 0;
        }
        if (nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }


        int l = 1;
        int r = nums.length-2;
        int mid = l + (r-l) /2;


        while(l<=r){
            mid = l + (r-l) / 2;
            if (nums[mid-1] > nums[mid]){
                r = mid -1;

            }
            else if (nums[mid+1] > nums[mid]){
                l = mid +1;

            }
            else if (nums[mid]>nums[mid+1] && nums[mid-1]<nums[mid]){
                return mid;
            }
        }

        return (mid);


    }
}