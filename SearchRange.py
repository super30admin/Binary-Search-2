class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        
        def binSearchFirst():
            l = 0
            h = len(nums) -1

            while l <= h:
                mid = (l+h)//2
                if nums[mid] == target:
                    if mid != 0 and nums[mid-1] == target:
                        h = mid-1
                    else:
                        return mid
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid -1
            
            return -1

        def binSearchSecond():
            l = 0
            h = len(nums) -1

            while l <= h:
                mid = (l+h)//2
                if nums[mid] == target:
                    if len(nums)-1 != mid and nums[mid+1] == target:
                        l = mid+1
                    else:
                        return mid
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid -1
            
            return -1

        first = binSearchFirst()
        if first == -1:
            return [-1,-1]
        second = binSearchSecond()
        return [first,second]