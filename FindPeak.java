// time: log(n) = log(n)
// space: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class FindPeak {
    public int findPeakElement(int[] nums) {

        //if just one element
        if(nums.length==1){
            return 0;
        }

        //initialize low and high
        int low=0, high=nums.length-1;

        //while search space is valid
        while(low<=high){

            //calculate mid
            int mid = low+(high-low)/2;

            //if starting element is peak
            if(mid==0 && nums[mid]>nums[mid+1]){
                return mid;
            }
            //if last element is peak
            else if(mid==nums.length-1 && nums[mid]>nums[mid-1]){
                return mid;
            }
            //peak in between
            else if(mid!=0 && mid!=nums.length-1 && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            //if previous element is bigger search left sub-array
            else if(mid!=0 && nums[mid-1]>nums[mid]){
                high = mid-1;
            }
            //move to right sub-array
            else{
                low = mid+1;
            }
        }

        return -2;
    }
}