m = 69
n = 4

# def nthRoot(n: int, m: int) -> int:
#         low = 1
#         high = m

#         while low <= high:
#             mid = (low + high) // 2
            
#             # Compute mid^n
#             power = mid ** n

#             if power == m:
#                 return mid  # Found exact integer Nth root
#             elif power < m:
#                 low = mid + 1  # Try larger values
#             else:
#                 high = mid - 1 # Try smaller values

#         return -1  # Nth root is not an integer

def nthRoot(n, m):
        # Loop from 1 to m
        for i in range(1, m + 1):
            # Compute i^n
            power = i ** n

            # If equal to m, return i
            if power == m:
                return i

            # If exceeds m, break
            if power > m:
                break

        # If not found, return -1
        return -1

print(nthRoot(n,m))
