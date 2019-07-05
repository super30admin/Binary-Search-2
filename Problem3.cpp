//
// Created by shazmaan on 7/6/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    int prob(vector<int>& nums){
        return findPeek(nums,0,nums.size()-1);
    }
private:
    int findPeek(vector<int>& nums,int low, int high){
        int mid;
        while(low!=high){
            mid = (low)+(high-low)/2;
            if((mid+1)<nums.size() && nums[mid+1]>nums[mid]){
                low = mid + 1;
            }else if((mid-1)>=0 && nums[mid-1]>nums[mid]){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return low;
    }
};

int main(){
    vector<int> vec{1,2,3,1};
    Solution s; cout<<s.prob(vec);
    return 0;
}