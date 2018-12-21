#### Problem Statement
```
Return List of all triplets whose sum is equal to zero

E.g.
- Input
    - [-1,0,1,2,-1,-4]
- Output
    - [[-1,-1,2],[-1,0,1]]
```

#### Solution Strategy
- Sum of n number is 0 -> means there are negatives as well positives numbers in the array.
- Sorting arrange elements in ascending order so all negatives are in one side and positives are in other.
- Three Pointer strategy
  - For each current Position element (ptr1)
    - Loop between next element(ptr2: left pointer) to last element(ptr3: right ptr) until they cross each other.
  - Rules
    - if sum of all three < 0 -> Means Sum is not sufficient and we need to increment left pointer (ptr2)
    - if sum of all three < 0 -> Means Sum is excessive and we need to decrement right pointer (ptr3)
    - if sum == 0 -> found a valid triplet hence adding it to the set. and increment ptr2 and decrement ptr3
- As we are doing sorting our solution has following complexities:
  - Space O(1)
  - Time O(n^2)
- Other solution is keep a hashing maintaining a position then apply TwoSum Solution for each element which has following complexity
  - Space O(n)
  - Time O(n^2)
