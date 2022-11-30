public class First_Last_pos_ele_sortedArray {
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int ans[] = new int[2];

        while (left <= right) {
            int pivot = left + (right-left) / 2;

            if (nums[pivot] < target) {
                left = pivot + 1;
            }
            else if (nums[pivot] > target) {
                right = pivot - 1;
            }
            else if (nums[pivot] == target) {
                int ptr1 = pivot, ptr2 = pivot;
                while (ptr1 > -1 && nums[ptr1] == target) {
                    ans[0] = ptr1;
                    ptr1--;
                }
                while (ptr2 < nums.length && nums[ptr2] == target) {
                    ans[1] = ptr2;
                    ptr2++;
                }
                return ans;
            }
        }
        return new int[] {-1,-1};
    }
}
