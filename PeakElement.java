// peak element = strictly greater than both its neighbours
//if the ele is strictly greater than both its elements then we have to return the element
// else we have more probability to find the element with the neighbour with greater value.
// if both the neighbours are of same value in that case, we can return either one
class PeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if((mid==0 ||nums[mid] > nums[mid-1]) && (mid==n-1 ||nums[mid] > nums[mid+1])) return mid;
            else if(mid > 0 && nums[mid-1] > nums[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1; // return random ele will also work because we always have a peak as per the question
    }
}
