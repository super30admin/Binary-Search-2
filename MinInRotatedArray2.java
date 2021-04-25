// time: log(n) = log(n)
// space: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had problem accumulating all the return nums[i] conditions

class MinInRotatedArray2 {
    public int findMin(int[] nums) {
        //if just one element
        if(nums.length==1){
            return nums[0];
        }

        int low=0, high=nums.length-1;

        //if search space is valid
        while(low<=high){

            //calculating mid
            int mid=low+(high-low)/2;

            // if mid is starting index and nums[mid] is smallest
            if(mid==0 && nums[mid]<nums[mid+1] && nums[mid]<nums[nums.length-1]){
                return nums[mid];
            }

            // if mid is last index and nums[mid] is smallest
            else if((mid==nums.length-1 && nums[mid]<nums[mid-1])){
                return nums[mid];
            }

            //if previous and next element of nums[mid] is bigger
            else if(mid!=0 && mid!=nums.length-1 && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                return nums[mid];
            }

            //left sub-array is sorted and it is pivoted
            else if((nums[low]<=nums[mid] && nums[low]>nums[high])){

                //move right
                low= mid+1;
            }

            //right sub-array sorted
            else{

                //move left
                high = mid-1;
            }
        }

        return -1;
    }
}