#include<iostream>
#include<vector>

using namespace std;
class FirstAndLast{
public:

    int BinaryFirst(vector<int>& nums, int low, int high, int target){
        
        while(low<=high){
            int mid=(low+high)/2;
             
            if(nums[mid]==target){
                if(mid!=0 && nums[mid]==nums[mid-1]){
                    high = mid-1;
                }
                else {
                    return mid;
                }
            }

            else if(nums[mid]>target){
                high=mid-1;
            }

            else {
                low = mid+1;
            }

            

            
            

        }
        return -1;

    }

    int BinaryLast(vector<int>& nums, int low, int high, int target){
        while(low<=high){
            int mid=(low+high)/2;
             
            if(nums[mid]==target){
                if(mid!=high && nums[mid]==nums[mid+1]){
                    low=mid+1;
                }
                else {
                    return mid;
                }
            }

            else if(nums[mid]>target){
                high=mid-1;
            }

            else {
                low = mid+1;
            }

            

            
            

        }
        return -1;

    }
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size()==0){
            return {-1,-1};
        }
        int low=0;
        int high=nums.size()-1;

        int first = BinaryFirst(nums, low, high, target);

        if (first == -1){
            return {-1,-1};
        }

        int last = BinaryLast(nums,first, high, target);

        return {first,last};


        

        
    }
};