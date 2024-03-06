//Time complexity: O(logn)
//Space Complexity: O(1) 
/*Approach:
we use two functions to find first and last occurence separately. Apply binary search.
Keep moving the ledt and right pointers towards the decreasing values to find the first occurence and
towards increasing values to find last occurence.
for first occurence we compare target to mid, if it matched we compare mid to mid -1 and similary for
last occurence compare to mid and then mid + 1
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) { 
            return new int[]{-1,-1};
            }
        int n = nums.length;
        int first = binarySearchFirst(nums, 0, n-1, target);
        if (first==-1){
            return new int[]{-1,-1};
        }
            int last = binarySearchLast(nums, first, n-1, target);
        return new int[]{first,last};

    }

    private int binarySearchFirst( int nums[], int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low )/2;
            if (nums[mid] == target){
                if (  mid == 0 || nums[mid]>nums[mid-1]){ 
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if (nums[mid]> target){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }
    private int binarySearchLast( int nums[], int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low )/2;
            if (nums[mid] == target){
                if (  mid == high || nums[mid]<nums[mid+1]){ 
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if (nums[mid]> target){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }
}