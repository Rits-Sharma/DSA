def rotateString(s: str, goal: str) -> bool:
    if len(s) != len(goal):
        return False
    for i in range(len(s)):
        if s == goal:
            return True
        s = rotateByOne(s)
    return False


def rotateByOne(s: str) -> str:
    s = list(s)
    char = s[-1]
    for i in range(len(s) - 1, 0, -1):
        s[i] = s[i - 1]
    s[0] = char
    return ''.join(s)

print(rotateString("abcde", "cdeab"))