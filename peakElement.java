// T.C -> O(logn)
// S.C -> O(1)

// Does it pass LC: Yes
// Here I have tried to check prev and next element and if an element is greater than it is a peak element

public class peakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int m;
        int n = nums.length;
        while (l <= h) {
            m = l + (h - l) / 2;
            if ((m == 0 || nums[m] > nums[m - 1]) && (m == n - 1 || nums[m] > nums[m + 1]))
                return m;
            else if (nums[m + 1] > nums[m])
                l = m + 1;
            else
                h = m - 1;
        }
        return -1;

    }
}
