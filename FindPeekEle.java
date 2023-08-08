public class FindPeekEle {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        FindPeekEle target = new FindPeekEle();

        int obj1 = target.peak(arr);

        System.out.println("peek element " + obj1);
    }

    private int peak(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;

    }
}