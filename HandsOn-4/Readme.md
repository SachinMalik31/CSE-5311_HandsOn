**Problem 0: Fibonacci Sequence**
-----------------------------------------------------------------------------------------------------------------------------
**Breakdown of how each recursive step works for fib(5):**

fib(5):  Invokes fib(4) and fib(3).

fib(4):  Invokes fib(3) and fib(2).

fib(3):  Invokes fib(2) and fib(1).

fib(2):  Invokes fib(1) and fib(0).

fib(1):  Reaches the base case and returns 1.

fib(0):  Reaches the base case and returns 0.

Returning to fib(2):
fib(2) = fib(1) + fib(0) = 1 + 0 = 1.

Returning to fib(3):
Calls fib(1) again.

fib(1): Reaches the base case again and returns 1.

Returning to fib(3):
fib(3) = fib(2) + fib(1) = 1 + 1 = 2.

Returning to fib(4):
Calls fib(2) again.

fib(2):  Invokes fib(1) and fib(0).

fib(1):  Returns 1 (base case).

fib(0):  Returns 0 (base case).

Returning to fib(2):
fib(2) = fib(1) + fib(0) = 1 + 0 = 1.

Returning to fib(4):
fib(4) = fib(3) + fib(2) = 2 + 1 = 3.

Returning to fib(5):
Calls fib(3) again.

fib(3):  Invokes fib(2) and fib(1).

fib(2):  Invokes fib(1) and fib(0).

fib(1):  Returns 1 (base case).

fib(0):  Returns 0 (base case).

Returning to fib(2):
fib(2) = fib(1) + fib(0) = 1 + 0 = 1.

Returning to fib(3):
Calls fib(1).

fib(1):  Returns 1 (base case).

Returning to fib(3):
fib(3) = fib(2) + fib(1) = 1 + 1 = 2.

Returning to fib(5):
fib(5) = fib(4) + fib(3) = 3 + 2 = 5.




**Problem 1: Merging K Sorted Arrays**
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Time Complexity Analysis:**

The time complexity of this approach is O(N * K log K), where:

* N is the number of elements in each array.
* K is the number of arrays. The priority queue operations take log K time, and we perform these operations for every element in all arrays, making the overall complexity O(N * K log K).


**Possible Improvements:**

* **Space Optimization:**   Currently, we store all elements in the result array, consuming O(N * K) space. We might try to reduce space usage by processing elements in place or streaming the output directly if that's feasible.
    
* **Parallel Processing:** If the input arrays are extremely large, parallelizing the merging of subarrays can improve performance on multi-core systems.



**Problem 2: Removing Duplicates from a Sorted Array**
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Time Complexity Analysis:**

The time complexity of this algorithm is O(N), where N is the number of elements in the array. 
The algorithm scans through the array once, comparing each element to its predecessor.
* Iteration: Looping through the array takes O(n) time.
* Slicing: Removing duplicates and slicing the array takes O(n) time.
* Total Time Complexity: T(n)=O(n)

**Possible Improvements:**

* **Memory Optimization:** The algorithm currently modifies the array in place, so it is already space-efficient with O(1) extra space. However, we could explore using a two-pointer technique more explicitly to make it clearer.
  
* **Early Termination:** If we encounter large blocks of repeated elements, we could terminate early once the rest of the array contains duplicates, optimizing for certain cases.








