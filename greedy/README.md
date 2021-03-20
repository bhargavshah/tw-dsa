# Greedy 

## Problem 1: Chopsticks
https://www.codechef.com/problems/TACHSTCK

Approach 1 : 
Brute force - Try all possible pairs and find difference. Check if it is < D, if yes consider that pair else ignore. 

Approach 2 :
```java
Arrays.sort(L);
int count = 0;
for(int i = 0; i < L.length-1; i++) {
    long diff = L[i+1] - L[i];
    if(diff <= D) {
        count++;
        i++;
    }
}
```

## Problem 2 : Cleaning Tables
1. Fill tables till empty.
2. If all tables are filled, find customer who would not place any order in future. 
3. Remove that customer from table and place new customer. 
4. Increment cleaning count whenever customer is not already sitting on table.

```java
static int getTablesToBeCleaned(int[] C, int N) {
    Set<Integer> tables = new HashSet();
    int cleans = 0;
    for(int i = 0; i < C.length; i++) {
        int c = C[i];
        if(tables.contains(c)) {
            continue;
        }
        cleans++;
        if(tables.size() < N) {
            tables.add(c);
            continue;
        }
        tables.remove(getCustomerToBeRemoved(C, i, tables));
        tables.add(c);
    }
    return cleans;
}

static int getCustomerToBeRemoved(int[] C, int i, Set<Integer> tables) {
    Set<Integer> tmpTables = new HashSet<>(tables);
    for(int j = i+1; j < C.length; j++) {
        if(tmpTables.size() == 1) {
            break;
        }
        if(tmpTables.contains(C[j])) {
            tmpTables.remove(C[j]);
        }
    }
    return tmpTables.iterator().next();
}
```

