class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> first_last_index(2,-1);
        int n = nums.size();
        if(nums.empty()){
            return first_last_index;
        }
        int left = bsearch(nums,target,true);
        if(left == -1){
            return first_last_index;
        }
        int right = bsearch(nums,target,false);
        first_last_index[0] = left;
        first_last_index[1] = right;

    return first_last_index;
    }

    int bsearch(vector<int> nums,int target,bool findFirstIndex){
        int low = 0, high = nums.size()-1,result=-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                result = mid;
                if(findFirstIndex){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }
};
