class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low )/2;

            if((mid == 0 || nums[mid] > nums[mid -1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])){
                //case 1 : mid at 0th index and greater than the 1st index element
                //case 2 : mid at the last index and greater than the penultimate index element
                //case 3 : checking if the mid is greater than its neighbours or not
                return mid;
            }

            else if(mid < n-1 && nums[mid] < nums[mid+1]){
                // making sure mid doesnt go out of bounds
                // here mid is less than mid + 1,hence we move to the right of mid
                low = mid + 1;
            }

            else{ //if(nums[mid] > nums[mid+1])
                high = mid - 1;
            }
        }

        return -1;
    }
};