class Solution {
    public int findMin(int[] nums) {
        
        int l = nums.length;
        int low = 0;
        int high =l-1;

        while(low<=high)    {
            //binary search 
            int mid = low + (high-low)/2;
            if(nums[low]<=nums[mid]) {
                //left side sorted
                if(nums[low]<= nums[high]) return nums[low];
                else{
                    //min at unsorted side
                    low = mid+1;
                }
            }
            else    {
                //right side is sorted
                if(nums[mid-1]<=nums[mid]){
                    //smaller element exist before mid
                    high = mid-1;
                }
                else return nums[mid];
            }

        }
        return -1;
    }
}
