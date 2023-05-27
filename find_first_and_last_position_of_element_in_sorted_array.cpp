/*
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
coming up how to divide the array to perform the binary search,

// Your code here along with comments explaining your approach in three sentences only
First find if the element exist in the array or not .
If does find the first idx in the left side of the array (sub array before the initial index) using binary search 
and similarly find the last idx in the right sub-array.
*/



#include<iostream>
#include<vector>

using namespace std;
// index of the target using binary search
int search(vector<int> &arr,int low,int high,int target){
    while(low<=high){
        int mid{low+(high-low)/2};
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid]<target){
            low = mid+1;
        }
        else if(arr[mid]>target){
            high = mid-1;
        }
    }
    return -1;
}

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {

        vector<int> pos(2,-1);
        int vec_len{static_cast<int>(nums.size())};
        // if vector exists.
        if (vec_len==0){
            return pos;
        }
    
        int low{0};
        int high{vec_len-1};
        // if the element lies inside the range of the array
        if(nums[0]>target || nums[vec_len-1]<target){
            return pos;
        }
        int init_pos = search(nums,low,high,target);
        cout<<init_pos<<endl;
        if (init_pos == -1)
            return pos;
        pos.at(0) = init_pos;
        pos.at(1) = init_pos;
        //finding the first and last idx by taking sub arrays and going left and right side of the array.
        while(true){
            int first_id{};
            first_id = search(nums,low,pos.at(0)-1,target);
            // flag if element is found.
            if(first_id == -1){
                break;
            }
            pos.at(0) = first_id;
        }
        while(true){
            int last_id{};
            last_id = search(nums,pos.at(1)+1,high,target);
            //flag if element is found.
            if(last_id == -1){
                break;
            }
            pos.at(1) = last_id;
        }

        return pos;
        
    }

};

int main(int argc, char const *argv[]){
    



    return 0;
}
