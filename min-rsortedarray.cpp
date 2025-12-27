class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int low = 0 ;
        int high = nums.size() - 1;

        while(low <=high){
            if(nums[low]<= nums[high]) return nums[low];//only true when the array is sorted and not rotated

            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] < nums[mid -1]) && (mid == n-1 || nums[mid] < nums[mid + 1])) return nums[mid];
            //case 1: mid at 0th index
            //case 2: mid at last index
            //case 3: mid is somewhere in between and we are checking if neighbours are greater or not 

            else if(nums[low] <= nums[mid]){
                low = mid + 1;//minimum lies in right of mid
            }
            else{
                high = mid - 1;//minimum lies in the left of mid
            }
        }

        return -1;
    }
};