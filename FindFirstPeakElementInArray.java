// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
public class FindFirstPeakElementInArray {
    public int findPeakElement(int[] arr) {
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if((mid==0 || arr[mid] > arr[mid-1]) &&
                    (mid==arr.length-1 || arr[mid] > arr[mid+1])){
                return mid;
            }
            else if(mid==0 || arr[mid] < arr[mid-1]){
                h = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return 1;
    }
}