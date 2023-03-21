class Solution {
    public int findMin(int[] nums) {
        //3, 4, 5, 1, 2

        //if the right is smaller than left 
        //THEN move the left to the right. 

        //Another way to put this is, there is only going to be 1 drop in the whole array. 

        //If your MID is greater than left then keep moving the left towards the right.
			
			//Time complexity : O(log n)

        int left = 0;
        int right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while(left < right){

            int mid = (right + left) / 2;


            if(nums[mid] <= nums[right]){
                right = mid;
            }

            else{

                left = mid + 1;

            }

        }
        return nums[left];
    }
}