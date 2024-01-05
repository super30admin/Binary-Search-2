class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = (high-low)/2;

        while(low <= high){
            // check if mid is pivot
            int nMid = nums[mid];
            Integer nBefore = mid - 1 > -1 ? nums[mid-1] : null;
            Integer nAfter = mid + 1 < high + 1 ? nums[mid+1]: null;

            if((nBefore == null || nMid >= nBefore) && (nAfter == null || nMid >= nAfter)){
                return mid;
            } else if(nBefore == null || nMid > nBefore){
                low = mid+1;
            } else high = mid-1;
            mid = low + (high-low)/2;
        }

        return -1;
    }
}
