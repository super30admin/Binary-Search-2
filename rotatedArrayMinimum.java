// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class rotatedArrayMinimum {
      public int findMin(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid-1]>nums[mid])&&(mid==nums.length-1 || nums[mid+1]>nums[mid])){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return 43466; // return anything because as long as we have some elements in the array, we will always have a mid element , so we will never reach here
    }

    public static void main(String[] args) {
    rotatedArrayMinimum rs = new rotatedArrayMinimum();
    int[] m1 = {3,4,5,1,2};
    int[] m2 = {4,5,6,7,0,1,2};
    int[] m3 = {11,13,15,17};
    
    System.out.println(rs.findMin(m1));  // ans = 1
    System.out.println(rs.findMin(m2));  // ans = 0
    System.out.println(rs.findMin(m3));  // ans = 11
}

}