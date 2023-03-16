public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        int f = bfs(nums, target, 0, nums.Length - 1);
        if(f == -1){
            return new int[]{-1,-1};
        }
        int l = bfl(nums, target, f, nums.Length - 1);
        return new int[]{f,l};
    }

    public int bfs(int[] a, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(a[mid] == target){
                if(mid == 0 || a[mid] > a[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int bfl(int[] a, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) {
                if(mid == high || a[mid] < a[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (a[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}