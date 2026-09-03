def isAnagram(a: str, b: str) -> bool:
    if len(a) != len(b):
        return False

    s, t = [0] * 26, [0] * 26

    for i in range(len(a)):
        s[ord(a[i]) - ord('a')] += 1
        t[ord(b[i]) - ord('a')] += 1

    for i in range(26):
        if s[i] != t[i]:
            return False

    return True


print(isAnagram("cat", "act"))