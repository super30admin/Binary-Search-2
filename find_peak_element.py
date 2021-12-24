#time complexity is o(log(n))
#we compare the elemtns next to mid to see if the mid is the peak element, if not we run binary search 
#on either side of mid to find the peak element.

def findPeakElement(nums):
    length = len(nums)
    low = 0
    high = length - 1
    while (low <= high):     
        middle = (low + high) // 2
        if ((middle == 0 or nums[middle - 1] <= nums[middle]) and (middle == length - 1 or nums[middle] >= nums[middle + 1])):
            return middle
        elif (middle > 0 and nums[middle - 1] > nums[middle]):
            high = middle - 1
        else:
            low = middle + 1
    return -1

print(findPeakElement([1,2,3,1]))
