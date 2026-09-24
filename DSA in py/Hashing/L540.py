from collections import Counter

def singleNonDuplicate(nums: list[int]) -> int:
    my_dict = Counter(nums)
    print(my_dict)
    for num in my_dict:
        if my_dict[num] == 1:
            return num


nums = [1,1,2,3,3,4,4,8,8]
print(singleNonDuplicate(nums))