#### Problem Statement
```
Return List of index of two such elements that their sum matches the target

e.g.
- Input
    - nums: [2,6,3]
    - target: 5
- Result
    - [0, 2]
```

#### Solution Strategy
- When iterating elements in list we can always find a difference with target element and check the resulting element exist or not.
- If that element exist then we have found our solution.

#### Implementation Strategy
- **HashMap** will keep track of elements present in the list with their index.
- Then we iterate elements with index (**for loop**)
- Take difference with target and find if element exist or not (**containsKey** or **getOrDefault**)
- To save an iteration we add current element at last. (**HashMap.put**)
