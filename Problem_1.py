# // Time Complexity : O(log n) 
# // Space Complexity : O(1)
    
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        if(len(nums)==0):
            return [-1,-1]

        first = self.firstBinarySearch(nums,target)
        if(first == -1):
            return [-1,-1]
        second = self.secondBinarySearch(nums,target)
        print(first,second)
        return [first,second]

    def firstBinarySearch(self, nums: List[int], target: int):
        low = 0
        high = len(nums)-1

        while(low <= high):
            mid = low + (high-low)//2

            if(nums[mid] == target):
                
                if((mid-1 == -1) or (nums[mid-1] != nums[mid])):
                    print(mid,nums[mid],nums[mid-1])
                    return mid
                else:
                    high = mid-1
                    
            elif(nums[mid] > target):
                high = mid-1
            else:
                low = mid+1
        return -1
    
    def secondBinarySearch(self, nums: List[int], target: int):
        low = 0
        high = len(nums)-1

        while(low <= high):
            mid = low + (high-low)//2

            if(nums[mid] == target):
                if((mid+1 == len(nums)) or (nums[mid+1] != nums[mid])):
                    return mid
                else:
                    low = mid+1
            elif(nums[mid] > target):
                high = mid-1
            else:
                low = mid+1
        return -1
                
