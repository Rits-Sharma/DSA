def largestOddNumber(num: str) -> str:
    if(num[0] == '0'):
        num = num[1:]
    for i in range(len(num), 0, -1):
        if int(num[i-1]) % 2 != 0:
            return num[0:i]
    return ""

print(largestOddNumber("07234"))