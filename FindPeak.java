//time complexity is O(logn) since we are cuuting the search space by half in each iterations
//Here my approache is once we identify the mid
//to check which side of the mid, there is an inclined slope and we will make that as a search place
//since inclining towardsincrasing slope definitely gives a peak element
//space complexity runs in constant time;
class Solution {
    public int findPeakElement(int[] nums) {
       int low=0;
       int high=nums.length-1;
       while(low<=high){
        int mid=low+(high-low)/2;
        if((mid==low||nums[mid]>nums[mid-1])&&(mid==high||nums[mid]>nums[mid+1]))return mid;
        if(mid!=low && nums[mid]<nums[mid-1])high=mid-1;
        else low=mid+1;
       }
       return 222;//it wont reach here
    }
}
