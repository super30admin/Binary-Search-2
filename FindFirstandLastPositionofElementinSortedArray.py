'''
Initialized flag to use one Binary Search function
1st run to check the leftmost target occurrence
If not return [-1,-1]
2nd run to find the rightmost target occurrence.
Finally, return [l, r]
TC: O(logn)
SC: O(1)
'''
#Find the First and Last position of an element in a sorted array
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def binarySearch(l, r, res, flag):
            i,j = 0, len(nums)-1
            while i<=j:
                mid = (i+j)//2
                if nums[mid] == target:
                    if not flag:
                        res = min(res, mid)
                    else:
                        res = max(res, mid)
                if not flag:
                    if target <= nums[mid]:
                        j = mid-1
                    else:
                        i = mid+1
                else:
                    if target >= nums[mid]:
                        i = mid+1
                    else:
                        j = mid-1
            return res if res != float("inf") and res != -float("inf") else -1

        left = binarySearch(0, len(nums)-1, float("inf"), False)
        if left == -1:
            return [-1,-1]
        right = binarySearch(0, len(nums)-1, -float("inf"), True)
        return [left, right]