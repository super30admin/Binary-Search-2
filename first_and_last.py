# find range of elements in sorted array
# this is done in log(n)
# two different conditions to find first occurrance and last occurrance.

# find first occurrance of the target
def Predicate1(mid, nums, target):
    if nums[mid] >= target:
        return True
    else:
        return False

# find last occurrance of the target
def Predicate2(mid, nums, target):
    if nums[mid] > target:
        return True
    else:
        return False

def find_range(nums, target) -> []:
    left = 0
    right = len(nums) - 1
    ans = []

    while (left < right):
        mid = int(left + (right - left) / 2)
        if Predicate1(mid, nums, target) is True:
            right = mid
        else:
            left = mid + 1
    ans.append(left)

    left = 0
    right = len(nums)

    while (left < right):
        mid = int(left + (right - left) / 2)
        if Predicate2(mid, nums, target) is True:
            right = mid
        else:
            left = mid + 1
    ans.append(left-1)
    return ans

if __name__ == "__main__":
    nums = [1,2,3,3,3,3,3]
    print(find_range(nums, 3))