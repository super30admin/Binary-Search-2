// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.*;

public class peakElement {
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length;
        int mid;
        
        if(nums.length == 1) 
            return 0;

        while(start <= end) {
            mid = start + (end-start)/2;
            
            if(mid==0 && nums[mid]>nums[mid+1]) {
                return mid;
            }
            if(mid==nums.length-1 && nums[mid]>nums[mid-1]) {
                return mid;
            }
            if(mid-1>=0 && nums[mid-1]<nums[mid] && mid+1<nums.length && nums[mid+1]<nums[mid]){
                return mid;
            }

            if(mid-1>=0 && nums[mid-1]>nums[mid]){
                end = mid-1;
            }
            else if(mid+1<nums.length && nums[mid+1]>nums[mid]){
                start = mid-1;
            } 

        }
        return start;
    }

    public static void main(String args[]) {
        int numbers[] = {1,2,1,3,5,6,4};
        //int numbers[] = {5,10,20,15};
        int result;
        result = findPeakElement(numbers);
        System.out.println("The element is present at index: " + result);
    }
    
}
