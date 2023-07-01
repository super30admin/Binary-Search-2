# -Time Complexity : O(logN)
# -Space Complexity : O(1)
# -Did this code successfully run on Leetcode : Yes
# -Any problem you faced while coding this : No

# -Your code here along with comments explaining your approach
# 1.  Search for left most index in the array using Binary Search.
#     If not found, return -1 else, check if it's the left most element (either index=0 or the left neighbour is different). 
#     If yes, return Index, else keep moving left.
# 2.  Search for right most index in the array using Binary Search.
#     If not found, return -1 else, check if it's the right most element (either index=len(arr)-1 or the right neighbour is different). 
#     If yes, return Index, else keep moving left.
#     Here, unlike left most index search, we don't need to run check from 0th index to end, we can do it from leftmost to end.
# 3. return the [leftmost Index, rightmost Index]
    


class Solution:
    def BinarySearchLeft(self,low,high,target,nums):
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==0 or nums[mid]!=nums[mid-1]: #left most index is mid
                    return mid
                else:
                    high=mid-1          #keep moving left
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1
        return -1

    def BinarySearchRight(self,low,high,target,nums):
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==len(nums)-1 or nums[mid]!=nums[mid+1]: #right most index is mid
                    return mid
                else:
                    low=mid+1 #keep moving right
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1
        return -1
        

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums)==0 or nums[0]>target or nums[-1]<target: return [-1,-1] 
        low=0
        high=len(nums)-1
        leftindex=self.BinarySearchLeft(low,high,target,nums)
        if leftindex==-1:
            return [-1,-1]
        rightindex=self.BinarySearchRight(leftindex,high,target,nums) #once left most index is found no need to start from 0th index again
        return [leftindex,rightindex]