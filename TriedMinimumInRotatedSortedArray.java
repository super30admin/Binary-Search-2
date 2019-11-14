/*package whatever //do not write package name here */
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int findMin(int[] nums) 
    {   //taking var temp as 0 and index as 0
        int index=0;
        int temp=nums[index];
        //iterate until end of the array
        while(index<nums.length-1)
        {   index+=1;
         //if smaller number is found, temp is updated
            if(nums[index]<temp)
            {
                temp=nums[index];
            }
        }
        return temp;
    }
}