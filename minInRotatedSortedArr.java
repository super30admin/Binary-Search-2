// T.C -> O(logn)
// S.C -> O(1)

// Does it pass LC: Yes
// here the pivot element would be minimum element
// so if element at middle > element at high then the pivot element would be at right side
// otherwise at left position

public class minInRotatedSortedArr {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int m;
        while (l < h) {
            m = l + (h - l) / 2;

            if (nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[l];

    }
}
