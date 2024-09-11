# Hands-On2

**Sachin Malik**

**Student ID : 1002202264**




**Proof of Correctness**

To prove the correctness of selection sort, we need to show that:

•	Preservation of Elements:  The algorithm does not lose or duplicate elements.

•	Sortedness:  The final output list is sorted.



**Loop Invariant**

A loop invariant is a condition that holds true before and after each iteration of a loop. 
For selection sort, the loop invariant can be stated as follows:

**Invariant:**  At the start of each iteration of the outer loop, the subarray before the current index is sorted, and every element in this subarray is less than or equal to every element in the remaining subarray.

Let’s break down the proof into three parts: 
Initialization, Maintenance and Termination.

**Initialization** 

At the first iteration, ( i = 0 ), the sublist to the left of ( i ) is empty. It is reasonable to say that an empty sublist is ordered and obeys the loop invariant. This means that before the first iteration, the sublist ( A[0…i-1] ) is empty and thus trivially sorted.

**Maintenance** 

At the start of any arbitrary iteration ( i ), no element from ( 0 ) to ( i-1 ) can ever be disturbed again. During this step, the inner loop will find the smallest element in (A[i…n-1]) and swap it with the element at (A[i]). This element is swapped into the (i)-th position.

•	Finding the Minimum:   The inner loop scans the sublist (A[i…n-1]) to find the smallest element.

•	Swapping:   The smallest element found is swapped with (A[i]).

•	Post-Swap:    After the swap, the new (A[i]) element cannot be smaller than any element in (A[0…i-1]) because the loop invariant is true prior to the start of the iteration. Therefore, it will simultaneously be the smallest element from ( i ) to the right and no smaller than any element to its left. This ensures that the loop invariant is preserved.

**Termination**

When the last iteration of the algorithm terminates, the loop counter will be on ( n-2 ). If the ( i )-th element is smaller, it will be exchanged with the ( n-1 )st element. Given that the sublist to the left of ( i ) is already sorted and neither (A[n-2]) nor (A[n-1]) can be smaller than any item in (A[0…n-2]) because of the loop invariant, the combined list will be in sorted order. If the ( i )-th element is not smaller, the list is already sorted.
The loop terminates when the unsorted subarray is empty, meaning the entire list is sorted.

**Conclusion** 

By ensuring that the loop invariant holds at initialization, is maintained through each iteration and holds at termination, it shows that selection sort correctly sorts the list.
