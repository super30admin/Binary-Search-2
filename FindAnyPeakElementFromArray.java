
// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// This problem can be solved by using Binary Search by comparing the mid-element with adjacent elements.  If both of them
// are smaller than the mid then we find the first peak element  and return it.  Otherwise, traverse either side to find
// the peak.
// If first element or last element is greater than their peer then we can consider it as peak element no need to search
// entire array
public class FindAnyPeakElementFromArray {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        //[1,2,3,1]
        while(low < high){
            int mid = low + (high - low)/2;
            System.out.println("mid = " + mid + " low = " + low + " high = " + high);
            if((mid == 0 || nums[mid] > nums[mid -1] )&&
                    (mid == n-1 || nums[mid] > nums[mid +1])){
                return mid;
            }else if (mid >0 && nums[mid-1]> nums[mid]){
                high = mid;
            }else{
                low = mid +1;
            }
        }
        return high;
    }
    public static void main(String[] args){
        int[] testcase1 = {1,2,1};
        int [] testcase2 = {1,2,3,1};
        int[] testcase3 = {1,2};
        int[] testcase4 = {3,2,1};
        int[] testcase5 = {1,2,3};
        System.out.println("testcase1[1,2,3] result = "+ findPeakElement(testcase1));
        System.out.println("testcase2 [1,2,3,1] result = "+ findPeakElement(testcase2));
        System.out.println("testcase3 [1,2] result = "+ findPeakElement(testcase3));
        System.out.println("testcase4 [3,2,1] result = "+ findPeakElement(testcase4));
        System.out.println("testcase5 [1,2,3] result = "+ findPeakElement(testcase5));
    }
}
