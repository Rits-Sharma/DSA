# **Recursion**
---
Recursion is a programming technique where a function calls itself directly or indirectly to solve a problem, by breaking it down into smaller subproblems until it reaches a base case that stops further calls.

## What is Stack Overflow in Recursion?
Whenever recursion calls are executed, they’re simultaneously stored in a **recursion stack** where they wait for the completion of the recursive function. A recursive function can only be completed if a base condition is fulfilled and the control returns to the parent function. 

But, when there is no base condition given for a particular recursive function, it gets called indefinitely which results in a Stack Overflow i.e., exceeding the memory limit of the recursion stack and hence the program terminates giving a Segmentation Fault error.

![[Pasted image 20260531114152.png|186]]


