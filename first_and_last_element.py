"""
time complexity:firstPos : O(n)
				lastPos:O(n)
				overall time complexity: O(n)
				
space complexity: O(1)
did your code run on leetcode: yes
issues faced: return -1 statement was included inside while loop, so always my output was [-1,-1], later i corrected it. 
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        startPos = self.firstPos(nums,target,0,len(nums)-1 )
        lastPos =self.endPos(nums,target,0,len(nums)-1 )
        return [startPos,lastPos]

    def firstPos(self,nums,target,low,high):
        while(low<= high):
            mid = low +(high-low)//2
            # print("mid1 =",mid)
            if nums[mid] == target:
                if low==mid or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    high = mid -1
                    # print("high1=",high)
            elif nums[mid]> target:
                high = mid -1
                # print("high1=",high)
            else:
                low = mid +1
                # print("low1=",low)
        return -1


    def endPos(self,nums,target,low,high):
        while(low<=high):
            mid = low+(high-low)//2
            # print("mid=",mid)
            if nums[mid] == target:
                if high == mid or nums[mid] < nums[mid +1]:
                    return mid
                else:
                    low = mid+1
                    # print("low=",low)
            elif nums[mid] > target:
                high = mid -1
                # print("high=",high)
            else:
                low = mid +1
                # print("low=",low)
        return -1

        
