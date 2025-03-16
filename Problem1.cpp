// 1. Find given target using binary search
// 2. If got target check if its corner element or move in either left or right. 
// 3. Perform binary search again while moving in either direction

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int f=0,l=nums.size()-1;
        int mid = (f+l)/2;
        int a=-1;
        while(f<=l){
            mid = (f+l)/2;
            if(nums[mid]==target){
                a=mid;break;
            }
            else if(nums[mid]>target){
                l=mid-1;
            }
            else{
                f=mid+1;
            }
        }
        vector<int> ans;
        int rt=a;
        if(a==-1){
            ans.push_back(-1);ans.push_back(-1);
            return ans;
        }
        while((a-1)>0 && nums[a-1]==target){
            a--;
        }
        if(nums[0]==target){
            a=0;
        }
        while((rt+1)<nums.size()-1 && nums[rt]==nums[rt+1]){
            rt++;
        }
        if(nums[nums.size()-1]==target){
            rt=nums.size()-1;
        }
        ans.push_back(a);
        ans.push_back(rt);
        return ans;
    }
};