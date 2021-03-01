#5-Hanoi-Pegs

Hanoi Project using 5 Pegs and specific rules; written in **Java**

**Problem:** 
Solve the Towers of Hanoi game for the following graph G=(V,E) with V={Start,Aux1,Aux2,Aux3,Dest} and E={(Start,Aux1),(Aux1,Aux2),(Aux2,Aux1),(Aux2,Aux3),(Aux3,Aux2),(Aux3,Dest)}
(a)Design an algorithm and determine the time and space complexities of moving n disks from Start to Dest.
(b)Implement this algorithm whereby your program prints out each of the moves of every disk. Show the output for n=1,2,3,4,5,6,7,8,9, and 10.

**Input:**
Input an integer n, where n is the number of disks you want to use to solve the above stated problem.

**Assumptions:** 
n is a number between 1 and 10, inclusive. Disks can only move to adjacent pegs, the Start peg cannot be moved onto again, and the Dest peg cannot be moved off of once the disk has been moved onto it. 

**Time Complexity:**
The time complexity for this algorithm is O(3n). I implemented a method called hanoiStart, which is called from the constructor of the Towers class. This method moves disk 1 from Start to Aux1, and then calls on method H1, which moves all disks except disk 1 from Start to Dest. Method H1 has 3 recursive calls, which is where the time complexity of O(3n) is derived from. After H1 has been executed, hanoiStart moves disk 1 from Aux3 to Dest, thus solving the unique Hanoi problem. The complete algorithm for this program was 2n+3n-1. The 2n comes from moving the disks from Start to Aux1, and also from moving them from Aux3 to Dest, whereas the 3n-1 comes from the recursive method to move all the disks from Aux1 to Aux3. 

**Space Complexity:** 
**Bipul**
Two arrays were used in this program to store whether a disk had moved from Start to Aux1 and from Aux3 to Dest respectively. The arrays were of size 12 to allow for checks without error, and 0s were assigned to indexes that matched the disks that hadn’t been moved yet. Once the disks had been moved, the 0s were changed to 1s. No stacks or any other data structures were used, and move statements were printed as soon as they were run. Due to the 2 arrays being the only factors, and the size of the arrays not changing the space complexity of this algorithm is O(n), due to only the stack storing the recursive calls changing. The recursive stack grows and shrinks linearly with n.


