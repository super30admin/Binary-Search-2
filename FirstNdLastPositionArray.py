from pip import List
#Time Complexity = O(logn)
#Space Complexity = O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(len(nums)==0):
            return [-1,-1]
        elif(target<nums[0] or target>nums[-1]):
            return [-1,-1]
        first = self.BinarySearchFirstOccurence(nums,target)
        if(first ==-1):
            return [-1,-1]
        last = self.BinarySearchLastOccurence(nums,target)
        return [first,last]

    def BinarySearchFirstOccurence(self, nums: List[int], target: int):
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = int(low + (high-low)/2)
            if(nums[mid]==target):
                if(mid ==0 or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    high = mid-1
            elif(target<nums[mid]):
                high = mid-1
            else:
                low = mid + 1
        return -1
    
    def BinarySearchLastOccurence(self, nums: List[int], target: int):
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = int(low + (high-low)/2)
            if(nums[mid]==target):
                if(mid == len(nums)-1 or nums[mid+1]>nums[mid]):
                    return mid
                else:
                    low = mid+1
            elif(target>nums[mid]):
                low = mid+1
            else:
                high = mid -1
        return -1

#s = Solution()
#print(s.searchRange([5,7,7,8,8,8,10],8))
                