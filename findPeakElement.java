class Solution{
    public int findPeakElement(int [] nums){
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;

            //if mid is smaller than next elemnt
            //peak is must be on right side
            if(nums[mid] < nums[mid+1]){
                left= mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
}