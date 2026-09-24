def longestSubarrayWithSumK(nums, k):
    prefix_sum = 0
    max_len = 0
    seen = {0: -1}  # prefix_sum -> earliest index
    
    for i, num in enumerate(nums):
        prefix_sum += num
        
        # Check if there's a previous prefix_sum that makes current sum - k
        if (prefix_sum - k) in seen:
            max_len = max(max_len, i - seen[prefix_sum - k])
        
        # Store earliest occurrence of prefix_sum
        if prefix_sum not in seen:
            seen[prefix_sum] = i
    
    return max_len

nums = [10, 5, 2, 7, 1, 9]
k = 15
print(longestSubarrayWithSumK(nums, k))