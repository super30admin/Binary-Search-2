class Solution {

    public int minTarget ( int target, int A[]){
        int l = 0;
        int h = A.length-1;
        int min =Integer.MAX_VALUE;
        while(l<=h){
            int  mid = l + (h-l)/2;
            if (A[mid] == target){
                h = mid - 1;
                min = Math.min(min,mid);
            }
            else if(A[mid] > target){
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        if (min == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return min;
        }
    }

    public int maxTarget(int target, int A[]){
        int l = 0;
        int h = A.length-1;
        int max =Integer.MIN_VALUE;
        while(l<=h){
            int  mid = l + (h-l)/2;
            if (A[mid] == target){
                l = mid + 1;
                max = Math.max(max,mid);
            }
            else if(A[mid] > target){
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        if (max == Integer.MIN_VALUE){
            return -1;
        }
        else{
            return max;
        }
    }

    public int[] searchRange(int[] A, int target) {
        int min1, max1;
        min1 = minTarget(target,A);
        max1 = maxTarget(target,A);
        int[] B = new int[2];
        B[0] = min1;
        B[1] = max1;
        return B;
    }

}


class Solution {
    public int findMin(int[] A) {
        int l=0;
        int h = A.length-1;
        while (l <= h) {
            int mid = l + (h - l) / 2;

            // Handle the case when the array is not rotated
            if (A[l] <= A[h]) return A[l];

            // Prevent out of bounds
            if ((mid == 0 || A[mid] < A[mid - 1]) && (mid == A.length - 1 || A[mid] < A[mid + 1])) {
                return A[mid];
            }

            // Decide which side to search
            if (A[mid] >= A[l]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1; // Just in case
    }
}



class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // low == high is the peak index
        return low;
    }

}
