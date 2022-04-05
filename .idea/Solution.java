
// Time complexity= O(log(n))
//Space complexity =O(1) 
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0 || nums==null) return -1;
        int low= 0;
        int high=nums.length-1;
        while(low<=high){
            System.out.println("high "+high);
            int mid= low+(high-low)/2;
            System.out.println(mid);
            if((mid!=0) && (mid+1)!=nums.length && (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])){
                System.out.println("test -1 ");
                return mid;
            }
            else if(mid==0 && (mid+1)==nums.length){
                System.out.println("test 0 ");
                return mid;
            }

            else if((mid+1)==nums.length && nums[mid]>nums[mid-1]){
                System.out.println("test 1 ");
                return mid;
            }
            else if(mid==0 && nums[mid]>nums[mid+1]){
                System.out.println("test 2 ");
                return mid;
            }
            else if( mid==0 && nums[mid]<nums[mid+1])//going to left for 2 ele
            {
                System.out.println("test left ");
                low=mid+1;
            }
            else if( mid!=0 && nums[mid]<nums[mid-1])//going to left
            {
                System.out.println("test left ");
                high=mid-1;
            }
            else if((mid+1)!= nums.length && nums[mid]<nums[mid+1])//going to right
            {
                System.out.println("Inside going right "+mid);
                low=mid+1;
                System.out.println("value of low "+low);
            }

        }
        return -1;
    }
}