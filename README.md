# DFA Minimization Project

## Group Members

- **Marbin Yesid Rivera Ciro**

## Versions and Tools

- **Operating System**: The version of the operating system is the one used by Replit.
- **Programming Language**: Java
- **Tools**: None specified; the implementation uses the Java standard library.


NOTE: The Java code is in the `master` branch, not `main`, as I haven't yet learned to use GitHub properly :((

## Code Description

The program performs two main steps to minimize a DFA:

1. **Initial Marking**: Initially marks state pairs as non-equivalent if one of the states is final and the other is not.
2. **Collapse**: Checks all unmarked state pairs and verifies if they transition to pairs of states that have already been marked as non-equivalent. If so, they are marked as non-equivalent.

### Input Format

1. **Number of Cases**:
   - An integer indicating the number of data sets to process.

2. **For Each Case**:
   - **Number of States**:
     - An integer specifying the total number of states in the DFA.
   - **Alphabet Size**:
     - An integer representing the number of symbols in the DFA's alphabet.
   - **Alphabet Symbols**:
     - A line with the alphabet symbols, separated by spaces.
   - **Number of Final States**:
     - An integer indicating how many states are final.
   - **Transition Table**:
     - A matrix describing the DFA transitions. Each row represents a state, and each column represents a symbol in the alphabet. The values in the matrix indicate the state transitioned to with the corresponding symbol.
   - **Final States**:
     - A line with the indices of the final states, separated by spaces.

### Example Input
1
4
2
a b
2
0 1
1 2
2 3
3 3
0 1 2 3


### Code Explanation

1. **Class `DFA`**:
   - **`states`**: Array of DFA states.
   - **`alphabet`**: Array of characters representing the DFA's alphabet.
   - **`transition_function`**: Matrix defining the DFA transitions. `transition_function[i][j]` indicates the state to which state `i` transitions with symbol `j`.
   - **`final_states`**: Array containing the indices of the final states.
   - **`QxQ`**: Matrix used to mark pairs of states as equivalent or non-equivalent.

2. **Methods**:
   - **`initialMarking()`**:
     - Marks pairs of states as non-equivalent if one is final and the other is not.
   - **`collapse()`**:
     - Checks unmarked pairs of states. If both states transition to pairs of states already marked as non-equivalent, the states are marked as non-equivalent.
   - **`getAlphabetIndex(char a)`**:
     - Returns the index of the symbol in the alphabet.
   - **`numberInList(int[] list, int number)`**:
     - Checks if a number is in a list of integers.

3. **Class `Main`**:
   - **Input**: Reads input data from the console.
   - **Process**:
     - Initializes the DFA.
     - Performs initial marking and collapsing of state pairs.
     - Prints the equivalent state pairs found.
   - **Output**:
     - Displays the equivalent state pairs found or indicates if no equivalent pairs were found.



