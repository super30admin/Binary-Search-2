#Time Complexity: O(2 log n )
#Space Complexity: O(1)

class Solution:
    def searchRange(self, nums, target):

        firstPos = self.startPos(nums, target, 0, len(nums) - 1)
        secondPos = self.endPos(nums, target, 0, len(nums) - 1)
        print("first position", firstPos)
        print("secondPos", secondPos)
        return [firstPos, secondPos]

    def startPos(self, nums, target, low, high):
        
        while low <= high:

            mid = low + (high - low) // 2

            if (nums[mid] == target):
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    return mid
                
                else:
                    high = mid - 1

            elif nums[mid] > target:
                high = mid - 1

            else:
                low = mid + 1
    
        return -1
    def endPos(self, nums, target, low, high):
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if (mid == high or nums[mid] < nums[mid+1]):
                    return mid
                else:
                    low = mid + 1

            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1

nums = [5,7,7,8,8,10]
target = 8    
res = Solution()
output = res.searchRange(nums, target)
print(output)