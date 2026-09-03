def minOperations(nums: list[int], x: int) -> int:
    count = 0

    if(nums[0] > x and nums[-1] > x):
        return -1

    while nums:
        first = nums.pop(0)   # remove first element
        last = nums.pop(-1) if nums else None  # remove last if still exists
        if x - first > 0:
            x -= first
            print(first)
            count += 1
        if last is not None and x - last > 0:
            x -= last
            print(last)
            count += 1

    return count


nums = [1,1,4,2,3]
x = 5

print(minOperations(nums, x))