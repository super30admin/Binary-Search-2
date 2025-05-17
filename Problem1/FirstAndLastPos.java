package Problem1;

import java.util.Arrays;

public class FirstAndLastPos {
    static int[] searchArr(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[] {-1, -1};

        int first = -1;
        int last = -1;

        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = (high - low) / 2 + low;

            if(nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(first != -1) low = first;
        else low = 0;
        high = n - 1;
        while(low <= high) {
            int mid = (high - low) / 2 + low;

            if(nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return new int[] {first, last};
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8,8,10,10};
        int target = 8;

        System.out.println("First and last index of "+ target +" is " + Arrays.toString(searchArr(nums, target)));
    }
}
