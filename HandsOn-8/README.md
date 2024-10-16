HandsOn-6 ( Sachin Pundalik Malik - 1002202264 )
--------------------------------------------------------------------------------------------------------------------------------
**1. Quicksort(ith order statistic)**

*Explanation:*

i. randomizedPartition:

* This function picks a random pivot element, places it at the end, and then partitions the array around the pivot. Elements smaller than or equal to the pivot are moved to the left, and elements greater than the pivot are moved to the right.


ii. randomizedQuickSelect:
* This is the main logic for finding the ith smallest element (ith order statistic). 
* It recursively partitions the array and narrows down the search to the part that contains the ith smallest element.

iii. main function:
* Initializes the array and calls the randomizedQuickSelect function to find the 5th order statistic (5th smallest element).

*Example:*

For the array {12, 45, 23, 51, 19, 33, 28, 36}, the output will be,
  The 4th order statistic of the array is: 28


