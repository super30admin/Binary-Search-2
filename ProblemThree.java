//Ran on leetode: Yes
//TC: O(logn)
//SC: O(1)
//Binary search to move towards the peak by moving to the greater element
class ProblemThree {
    public int findPeakElement(int[] nums) {
        int low = 1;
        int high = nums.length - 2;
        // Check if the first element is peak
        if(nums.length == 1 || nums[0] > nums[low]){
            return 0;
        }
        //Check if the last element is the peak
        if(nums[nums.length - 1] > nums[high]){
            return nums.length - 1;
        }
        //Apply binary search to find the peak
        while(low <= high){
            int mid = low + (high - low) / 2;
            //Check if mid is peak
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            //Move towards the peak
            if(nums[mid + 1] > nums[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        //Peak always exists 
        return Integer.MAX_VALUE;
    }
}