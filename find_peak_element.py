# find peak element
# go on dropping one half of the array, if next element to mid is greater or lesser
# peak element can be found in -- lg(n) times.

def find_peak_element(nums) -> int:
    l = 0
    r = len(nums) - 1
    while (l < r):
        mid = int(l + (r - l)/2)
        if nums[mid] > nums[mid+1]:
            r = mid
        else:
            l = mid + 1
    return l

if __name__ == "__main__":
    nums = [0,2,3]
    print(find_peak_element(nums))