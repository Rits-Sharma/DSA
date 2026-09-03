def totalNumbers(digits: list[int]) -> int:
    total = {}
    count = 0

    for i in range(len(digits)):
        for j in range(len(digits)):
            for k in range(len(digits)):
                if (i == j or j == k or k == i):
                    continue
                if digits[i] == 0:
                    continue
                if digits[k] % 2 != 0:
                    continue
                num = digits[i]*100 + digits[j]*10 + digits[k]
                if (not total.get(num, 0)):
                    total[num] = 1
                    count += 1
    return count

print(totalNumbers([2,0,2])[1])
