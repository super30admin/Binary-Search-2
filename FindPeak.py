class FindPeak:
	def findElement(self, arr):
		low = 0
		high = len(arr) - 1
		while low <= high:
			mid = low + (high - low)//2
			if (mid == 0 or arr[mid] > arr[mid - 1]) and (mid == len(arr) - 1 or arr[mid] > arr[mid + 1]):
				return mid
			elif mid > 0 and arr[mid] < arr[mid - 1]:
				high = mid - 1
			else:
				low = mid + 1
		return -1

if __name__ == "__main__":
	fp = FindPeak()
	arr = [1,2]
	print(fp.findElement(arr))