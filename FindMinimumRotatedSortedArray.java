// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class FindMinimumRotatedSortedArray {

    /**
     * Checks if the arr is sorted, return num at index 0
     * if middle element is the smallest, return middle element
     * if middle element > low , search on the left side
     * else search on the right side
     *
     * @param arr the array
     * @return    returns the min element in the array
     */
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[high]) return arr[low];
            else if ((mid == 0 || arr[mid] < arr[mid - 1])
                && (mid == arr.length - 1 || arr[mid] < arr[mid + 1])
            ) return arr[mid];
            else if (arr[low] <= arr[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return arr[low];
    }

    public static void main(String[] args) {
        final FindMinimumRotatedSortedArray findMinimumRotatedSortedArray = new FindMinimumRotatedSortedArray();
        System.out.println(findMinimumRotatedSortedArray.findMin(new int[] {4,5,6,7,0,1,2})); //returns 0
        System.out.println(findMinimumRotatedSortedArray.findMin(new int[] {1})); //returns 1
        System.out.println(findMinimumRotatedSortedArray.findMin(new int[] {3,4,5,1,2})); //returns 1
        System.out.println(findMinimumRotatedSortedArray.findMin(new int[] {11,13,15,17})); //returns 11
    }
}
