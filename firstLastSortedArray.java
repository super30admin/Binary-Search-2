// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class firstLastSortedArray {
     public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[] {-1,-1};
        }
        int left=binarySearchLeft(nums,target);
        if(left==-1){
            return new int[] {-1,-1};
        }
        int right=binarySearchRight(nums,target);
        return new int[] {left,right};
    }

    private int binarySearchLeft(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=nums[mid]){ //mid ==0 means 1st element
                    return mid;
                }
                high=mid-1;
            }
            else if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

    private int binarySearchRight(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
                if(nums[mid]==target){
                    if(mid==nums.length -1 || nums[mid+1]!=nums[mid]){
                    return mid;
                }
                low=mid+1;
        }
        else if(target>nums[mid]){
            low=mid+1;
        }
         else{
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    firstLastSortedArray rs = new firstLastSortedArray();
    int[] matrix = {5,7,7,8,8,10};
    
    int[] result1 = rs.searchRange(matrix,8);
    System.out.println("[" + result1[0] + ", " + result1[1] + "]");  // ans = [3,4]

    int[] result2 = rs.searchRange(matrix,6);
    System.out.println("[" + result2[0] + ", " + result2[1] + "]");  // ans = [-1,-1]
}

}