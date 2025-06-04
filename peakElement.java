//T.C: O(logn) n: length of nums[]
//S.c: O(1) No extra data structure is used except few variables to store my pointers which is constant.

/*Approach: I am implementing by using modifed binary search where i will have a condition to check 
*the left most neighbor whos value should be less than the element at current position. I will return low 
* because it will point to the last elment in nums[] which would be satisfy the above conditon. 
* as the following element wont satisfies which proves thats the peak.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int low = -1;
        int high = nums.length;

        while(high - low > 1){
            int mid = low + (high - low)/2;

            if(mid == 0 || nums[mid] > nums[mid - 1])  low = mid;
            else high = mid;
        }

    return low;
    }
}