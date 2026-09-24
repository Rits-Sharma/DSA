def smallestIndex(nums: list[int]) -> int:
    for i in range(len(nums)):
        if i == digitSum(nums[i]):
            return i
    return -1


def digitSum(num: int) -> int:
    sum = 0

    while num > 0:
        rem = num % 10
        sum += rem
        num //=10

    return sum

nums = [1,10,11]
print(smallestIndex(nums))