// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class findPeak {
     public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int low=0;
        int high= nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1])&&(mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return 434366;
    }

    public static void main(String[] args) {
    findPeak rs = new findPeak();
    int[] m1 = {1,2,3,1};
    int[] m2 = {1,2,1,3,5,6,};
    
    System.out.println(rs.findPeakElement(m1));  // ans = 2
    System.out.println(rs.findPeakElement(m2));  // ans = 5
}

}