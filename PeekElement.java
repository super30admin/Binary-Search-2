// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:

*. when we move towards the bigger side of an element from the mid, it is always
guaranteed that we will reach the peek, because the end is always -Infinity on both sides

1. Checked mid is greater than its neighbours, if it is return the peak, Also
   handle the conditions where the peek it at the beginning or at the end
2. Adjust low and high pointer to move towards to the higher value from the mid
 */
public class PeekElement {
    public int findPeakElement(int[] arr) {

        if(arr == null && arr.length == 0) return -1;

        int len =  arr.length - 1;

        int low = 0, high = len;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if((mid == 0 || arr[mid - 1] < arr[mid]) &&
                    (mid == len || arr[mid] > arr[mid + 1])) {
                return mid;
            } else if(mid != len && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
