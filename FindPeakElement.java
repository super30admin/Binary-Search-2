// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class FindPeakElement {

    /**
     * If mid == peak, return mid
     * else move to the side which is greater than mid element
     *
     * @param arr the array
     * @return    the peak element in the array
     */
    public int findPeakElement(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || arr[mid] > arr[mid - 1])
                && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])
            ) return mid;
            else if (mid > 0 && arr[mid] < arr[mid - 1]) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        final FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(new int[]{1,2,1,3,5,6,4})); //returns 5
        System.out.println(findPeakElement.findPeakElement(new int[]{1,2,1,3,5,6,7})); //returns 6
        System.out.println(findPeakElement.findPeakElement(new int[]{1})); //returns 0
    }
}
