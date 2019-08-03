class FindTargetRange:
	def StartPos(self, arr, target, low, high):
		while(low<=high):
			mid = low + (high - low)//2
			if arr[mid] == target:
				 if low == mid or arr[mid - 1] < arr[mid]:
				 	return mid
				 else:
				 	high = mid - 1
			elif arr[mid] > target:
				high = mid - 1
			else:
				low = mid + 1
		return -1
	
	def EndPos(self, arr, target, low, high):
		while(low<=high):
			mid = low + (high - low)//2
			if arr[mid] == target:
				 if high == mid or arr[mid] < arr[mid + 1]:
				 	return mid
				 else:
				 	low = mid + 1
			elif arr[mid] > target:
				high = mid - 1
			else:
				low = mid + 1
		return -1

	def Search(self, arr, target):
		firstPos = self.StartPos(arr, target, 0, len(arr) - 1)
		lastPos = self.EndPos(arr, target, 0, len(arr) - 1)
		return [firstPos, lastPos]

if __name__ == "__main__":
	nums = [1, 4, 4, 4, 5, 6, 7, 8, 9]
	target = 4
	FTR = FindTargetRange()
	print(FTR.Search(nums, target))