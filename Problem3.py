# T.c -> O(log n)
# S.c -> O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums is None or len(nums)==0:
            return int(sys.maxsize)
        low= 0
        high= len(nums)-1

        while low<=high:
            mid= low + (high-low)//2

            # If mid is peek element.
            if (mid== low or nums[mid-1] < nums[mid]) and (mid== high or nums[mid+1] < nums[mid]):
                return mid
            elif nums[mid]<nums[mid+1]:
                low= mid+1
            else:
                high= mid-1
