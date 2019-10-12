#implemented binary search method
# time complexity is o(logn)
# yes my code ran on leeet code

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def leftsearch(A,x):
            left=0
            right=len(A)-1
            while left<=right:
                mid=left+(right-left)//2
                if x>A[mid]:
                    left=mid+1
                else:
                    right=mid-1
            return left
        def rightsearch(A,x):
            left=0
            right=len(A)-1
            while left<=right:
                mid=left+(right-left)//2
                if x>=A[mid]:
                    left=mid+1
                else:
                    right=mid-1
            return right
        left,right=leftsearch(nums,target),rightsearch(nums,target)
        return (left,right) if left<=right else [-1,-1]
                    