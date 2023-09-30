// T.C -> O(logn)
// S.C -> O(1)

// Does it pass LC: Yes
// Intiution behind this problem is to work separately on two arrays
// from mid go only to left half to continiously find the element and store the idx at which it was found earlier.
// In this way you will find first idx and similarly go right and find last idx

public class firstAndLastElementInSortedArr {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int m;
        int st = -1;
        int ed = -1;

        while (l <= h) {
            m = l + (h - l) / 2;
            if (nums[m] == target) {
                st = m;
                h = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        l = 0;
        h = nums.length - 1;

        while (l <= h) {
            m = l + (h - l) / 2;
            if (nums[m] == target) {
                ed = m;
                l = m + 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return new int[] { st, ed };

    }
}
