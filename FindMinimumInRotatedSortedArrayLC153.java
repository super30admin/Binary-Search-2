/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

Approach 1 - Brute force  - Traverse every element TC - O(N), SC- O(1)

Approach 2 - Binary search
SC - O(1)
TC - Same as binary search O(logN)
***** Base case *****
We can check if array is pivoted or not, if last element of an array is greater than first then array is not pivoted because its sorted array
if last element of an array is less than first element of an array then its pivoted
***** Algorithm*****
1) find mid of an array
2) comparison criteria
if(arr[mid] > arr[mid+1])
then arr[mid +1] would be the smallest

if(arr[mid-1] > arr[mid])
then arr[mid] would be smallest
3) if(nums[mid] > 0)
-> shift left to mid + 1
4) else shift right to mid -1
*/
class FindMinimumInRotatedSortedArrayLC153 {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        //initializing left and right
        int start = 0, end = nums.length -1;

        // We can check if array is pivoted or not, if last element of an array is greater than first then array is not pivoted because its sorted array
//if last element of an array is less than first element of an array then its pivoted
        if(nums[end] > nums[0]){
            return nums[0];
        }

        while(start <= end) {
            int  mid = start + (end - start) / 2;

            // if the mid element is greater than its next element then mid+1 element is the smallest
            // This point would be the point of change. From higher to lower value.
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }


            // if the mid element is lesser than its previous element then mid element is the smallest
            if(nums[mid-1] > nums[mid]) {
                return nums[mid];
            }


            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with elements
            // greater than nums[0]
            if(nums[mid] > nums[0]) {
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }
        return -1;

    }
}
