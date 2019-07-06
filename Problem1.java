/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]*/

public class Day4Problem1 {

    public static void main(String[] args){

        int nums[] =  {5,7,7,8,8,10};
        int target=8;

        Day4Solution s = new Day4Solution();
        int result[] = s.search(nums,target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}




class Day4Solution{

    int[] search(int[] nums, int target){

        int res[] = new int[2];

        int l = 0;
        int r = nums.length - 1; // {5,7,7,8,8,10};

        int mid=0;
        while(l<=r){

            mid = l +(r-l)/2 ;
            if(nums[mid] == target){    // The problem here we once we find the target either it will be high position or the low position
            							// this can be handled with following if and else condion.
                if(nums[mid+1] ==  target) {
            	res[0] = mid;
                res[1] = mid+1;
                }else {
                	res[0] = mid-1;
                    res[1] = mid;
                }

                return res;

             }
            else if(target<= nums[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }

}

