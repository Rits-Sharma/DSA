import bisect
from functools import cache
def maximumWeights(intervals: list[list[int]]) -> list[int]:
    intervalsi = {}
    for i, (start, end, weight) in enumerate(intervals):
        if not (start, end, weight) in intervalsi: intervalsi[(start, end, weight)] = i

    intervals = sorted(intervalsi)
    n = len(intervals)

    @cache
    def dp(i, rem):
        if rem == 0 or i == n:
            return 0, []
        skipw, skip_indices = dp(i+1, rem)
        start, end, weight = intervals[i]
        nexti = bisect.bisect_left(intervals, (end+1,))
        nextw, next_indices = dp(nexti, rem-1)
        takew = weight + nextw
        take_indices = next_indices + [intervalsi[intervals[i]]]
        take_indices.sort()

        if takew > skipw: return (takew, take_indices)
        elif skipw > takew: return (skipw, skip_indices)
        if take_indices < skip_indices: return (takew, take_indices)
        else: return (skipw, skip_indices)

    
    return dp(0, 4)[1]

print(maximumWeights([[1, 3, 2], [1, 4, 1], [2, 5, 4], [6, 7, 8]]))