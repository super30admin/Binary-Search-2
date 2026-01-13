public class PeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            //Check if mid is greater than its neighbours
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid == n-1 || nums[mid]>nums[mid+1])){
                return mid;
            } else if(mid != 0 && nums[mid-1] > nums[mid]){
                //move towards left and reject right half
                high = mid - 1;
            } else{
                ////move towards right and reject left half
                low = mid + 1;
            }
        }
        return 1;
    }
}

//Time complexity : O(log n)
//Space complexity : O(1)