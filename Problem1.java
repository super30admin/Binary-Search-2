// Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

//Time complexity = O(logn)
//Space complexity = O(logn)
//solved in leetcode : Yes
// no issues faced :)
//approach : below in the comments


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){  //if there are no elements in the array return [-1,1]
            return new int[]{-1,-1}; 
        }
        int[] answer = {-1,-1};
        answer[0] = startingposition(nums,target);
        answer[1] = endingposition(nums,target);
        return answer;

        
    }
    private int startingposition(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        int firstposition = -1; //initially let the starting position be -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){ //if you found the target , should check if its first position or not , so should search the left side 
                firstposition = mid ; //store the index to firstposition;
                end = mid - 1;

            }
            else if(target > nums[mid]){start = mid + 1;}
            else{end = mid - 1;}
        }
        return firstposition;
    }
     private int endingposition(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        int endposition = -1; //initially let the ending position be -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){ //if you found the target , should check if its end position or not , so should search the right side 
                endposition = mid ; //store the index to endposition;
                start = mid + 1;

            }
            else if(target > nums[mid]){start = mid + 1;}
            else{end = mid - 1;}
        }
        return endposition;
    }

}