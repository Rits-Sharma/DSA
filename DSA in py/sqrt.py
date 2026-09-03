import math
a = 26

# print(math.floor(a ** 0.5))
# print(int(a**0.5))
# print(int(math.sqrt(a)))


def sqrtNum (a: int):
    ans = 0
    for i in range(1, a+1):
        if i*i <= a:
            ans = i
        else:
            break
    return ans

print(sqrtNum(36))