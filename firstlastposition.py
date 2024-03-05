## Time complexity is O(logN) and space complexity is O(1)
class FirstLastPosition:
    def findposition(self, nums, target):
        left = self.binarySearch(nums, target, True)
        right = self.binarySearch(nums, target, False)
        return [left, right]
        
    def binarySearch(self, nums, target, leftBias):
        l = 0
        r = len(nums)-1
        i = -1
        
        while l<=r:
            mid = (l+r)//2
            if target < nums[mid]:
                r = mid-1
            elif target > nums[mid]:
                l = mid+1
            else:
                i = mid
                if leftBias:
                    r = mid-1
                else:
                    l = mid+1
        return i
                    
            
        