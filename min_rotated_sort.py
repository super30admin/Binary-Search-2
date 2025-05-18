# find minimum element from rotated sorted array
# the codition we check against is, nums[mid] <= nums[r]
# that way, we will be discarding one half of array and will process the right subpart
# lg(n) is the time complexity.

def find_minimum_element(nums) -> int:
    l = 0
    r = len(nums) - 1
    while (l < r):
        mid = int(l + (r - l)/2)
        if nums[mid] <= nums[r]:
            r = mid
        else:
            l = mid + 1
    return nums[l]

if __name__ == "__main__":
    nums = [4,5,6,7,0,1,2]
    print(find_minimum_element(nums))