// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class PeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int low = 0, high = len-1;
        if(low == high){
            return low;
        }

        if(nums[low] > nums[low+1]){
            return low;
        }

        if(nums[high] > nums[high-1]){
            return high;
        }

        low++;
        high--;

        int peakIndex = -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid > 0 && mid < len && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                peakIndex = mid;
                break;
            }else if(mid > 0 && mid < len && nums[mid] > nums[mid-1]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return peakIndex;
    }
}