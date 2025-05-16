// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindPeakElementClass {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low)/2;

            if(nums[mid] > nums[mid + 1]){
                 high = mid;
            }           
            else{
               low = mid + 1;
            }           
        }
        return low;
    }

    public static void main(){
        FindPeakElementClass peak = new FindPeakElementClass();
        int[] nums = [1,2,3,1];
        int peakNum = peak.findPeakElement(nums);

        system.out.print("Peak Number : "+peakNum);

        nums = [1,2,3,1];
        peakNum = peak.findPeakElement(nums);

        system.out.print("Peak Number : "+peakNum);

        nums = [6,5,4,3,2,3,2];
        peakNum = peak.findPeakElement(nums);

        system.out.print("Peak Number : "+peakNum);
    }
}