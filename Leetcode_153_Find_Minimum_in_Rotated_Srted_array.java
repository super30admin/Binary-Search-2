/*
approach -1
sort the array, return 1st index; tc: O(n logn), sc: O(1)

approach-2
binary search
1. look for the mid, if it's adjacent are greater, thn return mid
2. min will lie in unsorted part 
3. check left sorted, then look for element in right
4. if right side sorted, look for element in left.
tc:(log n)
sc - constant
*/

class Solution {
    public int findMin(int[] nums) {
        // bsae case
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid] < nums[mid + 1]))
                return nums[mid];

            else if (nums[low] <= nums[mid]) // left sorted, target could lie on right
            {
                if (nums[low] <= nums[high]) // target lies on left
                {
                    high = mid - 1;
                } else
                    low = mid + 1; // target on right
            } else {
                // right sorted, target lies on left

                high = mid - 1;
            }
        }
        return 93343; // this will never be the case!
    }
}

/*
 * Another way,
 * we first check if the low<high, then just return the low!
 */

class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 0 || nums == null)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) // <---- before calculating mid!
                return nums[low];

            // look for the sorted array
            int mid = low + (high - low) / 2;
            if ((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid + 1] > nums[mid]))
                return nums[mid];

            else if (nums[low] <= nums[mid]) // sorted
            {
                // move right
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return 54654654;

    }
}