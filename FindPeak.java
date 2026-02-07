public class FindPeak {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, MID;
        boolean leftCheck;
        boolean rightCheck;

        while (left <= right) {
            MID = left + (right - left) / 2;
            // check left side then check right side also
            leftCheck = (MID == 0) || nums[MID] > nums[MID - 1];
            rightCheck = (MID == nums.length - 1) || nums[MID] > nums[MID + 1];

            if (leftCheck && rightCheck) {
                return MID;
            }

            if (MID > 0 && nums[MID - 1] > nums[MID]) {
                right = MID - 1;
            } else {
                left = MID + 1;
            }
        }

        return -1;
    }
}