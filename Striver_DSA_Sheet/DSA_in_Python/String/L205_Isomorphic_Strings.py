def isIsomorphic(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False
    first, second = [0] * 256, [0] * 256
    n =len(s)

    for i in range(n):
        if first[ord(s[i])] != second[ord(t[i])]:
            return False
        first[ord(s[i])] = i+1
        second[ord(t[i])] = i+1

    return True


print(isIsomorphic("ppppg", "add"))