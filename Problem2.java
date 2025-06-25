/*
 * TC: O(log(n))
 * SC: O(1)
 * Array could be divided in two parts containing sorted and unsorted part or both sorted parts,
 * so each time we trim down the unsorted part and reach a point where low == high, and thats where 
 * the minimum element lies.
 */

class Problem2 {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        if(nums.length == 0 || nums == null)
            return -1;

        while(l<h){
            int mid = l + (h - l)/2;

            if(nums[mid]>nums[h])        //arr is unsorted
                l = mid + 1;
            else h = mid;
        }
        return nums[l];
    }

    public static void main(String[] args){
        int nums[] = {4,5,6,7,0,1,2};
        Problem2 p = new Problem2();
        System.out.println(p.findMin(nums));
    }
}