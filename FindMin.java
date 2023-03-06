// In this problem, we are using binary search algorithm to determine the
// minimum value from the list of elements in an array
// the time complexity of this implementation is O(log n)
public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 1, 3};
        FindMin solution = new FindMin();
        int min = solution.findMin(nums);
        System.out.println("Minimum value: " + min);
    }
}
