def isConsecutive(arr):
    arr.sort()
    for i in range(1, len(arr)):
        if arr[i] != arr[i - 1] + 1:
            return False
    return True


print(isConsecutive([3, 4, 5, 3, 3, 7]))