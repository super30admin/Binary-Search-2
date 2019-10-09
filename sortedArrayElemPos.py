# Couldn't find the approach. Not clear on how to store& update first and last index and iterate over the array
class Solution:
    def search(self,nums, target):
        if not nums:
            return -1
        left = 0
        right = len(nums)-1
        first , last= -1,-1

        while left<len(nums):
            mid = (left+right)//2
            print(mid, left,right)

            if target < nums[mid]:
                print("c")
                right = mid-1
            elif target > nums[mid]:
                print("d")
                left = mid+1
            elif target == nums[mid]:
                if first == -1 and last == -1:
                    first, last = mid,mid
                    if target < nums[right]:
                        right = right-1
                    elif target > nums[left]:
                        left = left + 1
                if first > left:
                    print("e")
                    first = left
                right= mid-1
                if last < right:
                    print("f")
                    last = right
                left = mid+1

        return first,last
s = Solution()
print(s.search([5,7,8,9,9,10],9))
print(s.search([5,7,7,8,8,10],4))
