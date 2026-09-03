def leaders(nums: list[int]) -> list[int]:
    ans = []
    nums.reverse()

    ans.append(nums[0])
    maximum = max(nums[0], nums[1])

    for x in range(2, len(nums)):
        if nums[x] > maximum:
            ans.append(nums[x])
            maximum = nums[x]

    return ans.reverse()



nums = [1, 2, 5, 3, 1, 2]
print(leaders(nums))