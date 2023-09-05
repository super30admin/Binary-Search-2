// Time Complexity : O(log(n)) Binary search applied for searching the peak element in array
// Space Complexity : O(1) no extra space used other than constants
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class FindPeakElement {
    public int findPeakElement(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length -1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == high || arr[mid]> arr[mid+1]) )
            {
                return mid;
            }
            else if(mid != high && arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }
            else{

                high = mid -1;
            }
        }
        return 544556;
    }
}
