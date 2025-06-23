# Time Complexity: O(log n)
# Space Complexity: O(1)


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def FindFirst(nums, target,l,h):
            while l<=h:
                mid =(h+l)//2
                if nums[mid]==target:
                    if mid==0 or nums[mid-1]!=target:
                        return mid
                    else:
                        h=mid-1
                elif nums[mid] > target:
                    h=mid-1
                else:
                    l=mid+1
            return -1

        def FindSecond(nums: List[int], target: int,l:int,h:int):
            while l<=h:
                mid =(h+l)//2
                if nums[mid]==target:
                    if mid==len(nums)-1 or nums[mid+1]!=target:
                        return mid
                    else:
                        l=mid+1
                elif nums[mid] > target:
                    h=mid-1
                else:
                    l=mid+1
        first=FindFirst(nums,target,0,len(nums)-1)
        if first==-1:
            return [-1,-1] 
        second=FindSecond(nums,target,first,len(nums)-1)
        return [first,second]
        
    

        