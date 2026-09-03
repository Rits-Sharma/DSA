def reverseDegree(s: str) -> int:
    n = len(s)
    ch = []
    for i in range(n):
        ch.append(ord(s[i]) - 96)
    
    sum = 0
    for i in range(len(ch)):
        sum += ((i+1) * (27 - ch[i]))

    return sum


print(reverseDegree("zaza"))