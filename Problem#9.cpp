#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        
        int l =0;
        int r = nums.size()-1;
        
        while (l<r)
        {
            int mid = (l+r)/2;
            
            if (nums[mid] > nums [mid+1])
                
                r = mid;
            else 
                l = mid+1;
        }
       
        return l;
    }
};

int main()
{

    Solution s;
    vector <int> v ={1,2,1,3,5,6,4};

//   for (auto it = v.begin(); it != v.end(); ++it)
      cout << " Peak element is :"<<s.findPeakElement(v)  << endl;

   return 0;
}  

