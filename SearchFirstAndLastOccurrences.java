import java.util.Arrays;

public class SearchFirstAndLastOccurrences {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = firstOccurence(nums, target);
        res[1] = lastOccurrence(nums, target);
        return res;
    }

    public int firstOccurence(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        int index = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                index = mid;
                end = mid-1;
            }
            else if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return index;
    }
    public int lastOccurrence(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        int index = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                index = mid;
                start= mid+1;
            }
            else if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return index;
    }

    public static void main(String[] args) {
        SearchFirstAndLastOccurrences obj = new SearchFirstAndLastOccurrences();
        int[] nums = new int[]{1,2,3};
        int target = 1;
        int[] res = obj.searchRange(nums, target);
        System.out.println("result --- " + Arrays.toString(res));
    }
}
