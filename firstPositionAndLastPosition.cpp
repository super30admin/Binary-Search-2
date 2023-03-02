class Solution {
public:
    int ceilIndex(vector<int> nums,int target){
        int start = 0;
        int end = nums.size()-1;
        int mid;
        cout<<"here";
        while(start<=end){
            mid = (end-start)/2 +start;
            if(nums[mid]> target) end =mid-1;
            else if (nums[mid]<target) start = mid+1;
            else {
                 if(mid == nums.size()-1 || nums[mid]!=nums[mid+1]) {return mid;}
                 else start=mid+1;
            }
        }
        return -1;
    }

    int floorIndex(vector<int> nums,int target){
        int start = 0;
        int end = nums.size()-1;
        int mid;
        while(start<=end){
            mid = (end-start)/2 +start;
            if(nums[mid]> target) end =mid-1;
            else if (nums[mid]<target) start = mid+1;
            else {
                 if(mid==0 || nums[mid]!=nums[mid-1]) {return mid;}
                 else end=mid-1;
            }
        }
         
        return -1;

    }
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> indices;
        int low, high;
        low = floorIndex(nums,target);
         high = ceilIndex(nums,target);
      
        indices.push_back(low);
        indices.push_back(high);
        return indices;

    }
};