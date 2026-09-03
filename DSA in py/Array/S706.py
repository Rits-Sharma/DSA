def intersectionArray(nums1: list[int], nums2: list[int]) -> list[int]:
    ans = []
    i, j = 0, 0
    m, n = len(nums1), len(nums2)

    while(i < m and j < n):
        if(nums1[i] == nums2[j]):
            ans.append(nums1[i])
            i += 1
            j += 1
        elif nums1[i] < nums2[j]:
            i += 1
        else:
            j += 1

    return ans

nums1 = [2, 2, 3, 5]
nums2 = [1, 2, 2, 3, 3]

print(intersectionArray(nums1, nums2))