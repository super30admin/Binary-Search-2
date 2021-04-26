//Time complexity is: log(n);
//in this we have to use below algo: 
//first find the sorted space and then move to next side that is to the unsorted side side and repeate //the same thing until we get an element who is lesser than both of its neighbours.
//edge cases while removing 1 part at each iteration we may hit edge cases that are: may be mid becomes //zero or becomes equal to arr.lenth-1
​
class Solution {
     public static int findMin(int[] nums) {
​
        if (nums.length == 0) {
            return -1;
        }else{
            int low=0;
            int high=nums.length-1;
​
            while(low<=high){
                int mid=low+(high-low)/2;
                if (nums[mid]>nums[low] && nums[mid]<nums[high]) {
                    return nums[low];
                }else{
                    if ((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1]) ) {
                        return nums[mid];
                    }else if (nums[mid]<nums[high]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
            }
            return -1;
        }
    }
}
