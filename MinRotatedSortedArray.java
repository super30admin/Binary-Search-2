/*Approach : 
1. Use BS : Condition to reject one half of the array -> side that is sorted move to other half.
2. Check if mid is less than both the adjoining elements if yes thats the minimum.
*/
class MinRotatedSortedArray {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            if(nums[low]<=nums[high]) return nums[low]; // check if the range of elements are sorted
            int mid = low +(high-low)/2;//get the mid

            //here we need to check if both the adjoining 
            //values of mid is greater than mid bingo you have the min
            if((mid==0 ||nums[mid]<nums[mid-1]) && nums[mid]<nums[mid+1]){
                return nums[mid];
                
            }//otherwise check which side is sorted
            else if(nums[mid]<=nums[high]){ // right side is sorted so move to left
                high = mid-1;
            }else{// left side is sroted move to right
                low = mid+1;
            }

        }
        //return any random value
        return -1;
    }
}