// Time Complexity : Log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*

We implement binary search to find min element as it is a sorted array
we calculate mid, if element at mid is less than element at right, it can mean that either entire array
is sorted or only right half is sorted
In both the cases, minimum lies in first half.
If element at mid > element at right, it means array is in second half
We modify both pointers according to the above conditions and reach the min element.
* */

class FindMinInRotatedSortedArray {

         public int findMin(int[] arr) {
             int left=0;
             int right = arr.length - 1;
             while(left<right)
             {
                 int mid=left + (right - left)/2;
                 if(arr[mid]<arr[right])
                 {
                     right = mid;
                 }
                 else
                 {
                     left = mid + 1;
                 }
             }
             return arr[left];
         }

}
