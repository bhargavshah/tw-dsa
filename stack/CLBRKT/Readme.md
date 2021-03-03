# Problem Statement Link
https://www.codechef.com/problems/CLBRKT

## Approach

### Naive approach
1. Ignore all closing brackets if any while starting

```java
while(i < s.length() && s.charAt(i) == ')') {
    i++;
}
```
2. Keep incrementing counter for opening brackets till we get
```java
while(i < s.length() && s.charAt(i) == '(') {
    i++;
    cnt++;
}
```
3. Keep decrementing counter for closing brackets till we get
```java
while(i < s.length() && s.charAt(i) == ')' && cnt > 0) {
    i++;
    cnt--;
}  
```
4. Return current time if count is zero i.e. balanced brackets found
```java
if(cnt == 0) {
    return i;
}
```
5. Continue till we reach end of string. 

We perform above steps for each query. 
#### Time Complexity
Q = Number Of Queries
N = String length
> O(QN)

For each query, we loop through entire string in worst case. 
As Q ~ N, Complexity is quadratic. 

#### Space Complexity
> O(1)
As we just used local variable, not allocated any additional space which can grow with input. 

##### See naiveApproach.java file to view entire code. 

### Optimized approach
1. We need to preprocess to reduce query time.
2. Allocate separate array to store when can chef ready to attack each ith time.
```java
int[] attacks = new int[s.length()];
Arrays.fill(attacks, -1);
```
3. Start processing array from right to left, as we will build our answer based on previously calculated ans. 
```java
for(int i = attacks.length-1; i >= 0; i--) { 
```

4. For each opening bracket at ith, we should know latest closing bracket which is unused. 
To find that store all closing brackets position in stack and same time previous time when you saw balanced brackets.
```java
if(s.charAt(i) == ')') {
    stack.push(i);
    attacks[i] = recentlyBalancedAt;
    continue;
}
```
5. If current bracket is opening, means we need to find correspoding closing bracket position using Stack.  
```java
if(!stack.isEmpty()) {
    attacks[i] = stack.pop()+1;
}
```
6. Update recent time we saw balanced brackets accordingly. 
```java
recentlyBalancedAt = attacks[i];
```
7. For answering each query, we can get from preprocessed array in O(1)
```java
int q = sc.nextInt();
pr.println(attacks[q-1]);
```
#### Time Complexity
N = String length
> O(N)

We just loop through string one time, to get preprocessed array and get answer in O(1) for each query.
As Q ~ N, Complexity is linear. 

#### Space Complexity
> O(N)
To store preprocessed array. 

##### See optimizedApproach.java file to view entire code. 
