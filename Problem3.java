/*
 * TC: O(log(n))
 * SC: O(1)
 * 
 * This algo finds mid and compares the mid with mid-1 and mid+1 except for two cases
 * when mid==0 and mid==n-1. This algo adjusts low and high as per adjacent values to mid.
 * Also checks that if we are at the end points (0 and n-1), and if the adjacent values are lower
 * it returns mid as its peak ele in that case.
 */


class Problem3 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int high = n-1;
        int low = 0;

        if(nums == null || nums.length == 0)
                return -1;
        if(n==1) return 0;

        while(low<=high){
            int mid = low + (high-low)/2;
            //the condition here avoids ArrayIndexOutOfBoundsException: Index -1 for the left side and 
            //  avoids ArrayIndexOutOfBoundsException: Index n for the right side using the OR condition..please read and understand carefully 
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid == n-1 || nums[mid]>nums[mid+1]))
                return mid;
            else if(nums[mid+1]>nums[mid])
                low = mid + 1;
            else high = mid - 1;

        }
        return -1;
    }


    public static void main(String[] args){
        int nums[] = {4,5,6,7,0,1,2};
        Problem3 s = new Problem3();
        System.out.println(s.findPeakElement(nums));
    }
}