import java.util.Scanner;

class DFA {
    int[] states;
    char[] alphabet;
    int[][] transition_function;
    int[] final_states;
    char[][] QxQ;

    public DFA(int n, char[] alphabet, int[][] transition_function, int[] final_states) {
        this.states = new int[n];
        for (int i = 0; i < n; i++) {
            this.states[i] = i;
        }

        this.alphabet = alphabet;
        this.transition_function = transition_function;
        this.final_states = final_states;
        this.QxQ = new char[n][n];

        // Initialize QxQ with a blank space character
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.QxQ[i][j] = ' ';
            }
        }
    }

    public void initialMarking() {
        for (int row = 0; row < this.states.length; row++) {
            for (int column = 0; column < row; column++) {
                boolean rowInFinal = numberInList(final_states, row);
                boolean columnInFinal = numberInList(final_states, column);

                // Mark pairs as non-equivalent if one is final and the other is not
                if (rowInFinal != columnInFinal) {
                    this.QxQ[row][column] = 'X';
                }
            }
        }
    }

    public void collapse() {
        boolean changed;

        do {
            changed = false;
            for (int row = 0; row < this.states.length; row++) {
                for (int column = 0; column < row; column++) {
                    if (this.QxQ[row][column] == 'X') {
                        continue;
                    }

                    boolean equivalent = true;
                    for (char a : this.alphabet) {
                        int rowTransition = transition_function[row][getAlphabetIndex(a)];
                        int columnTransition = transition_function[column][getAlphabetIndex(a)];

                        if (this.QxQ[rowTransition][columnTransition] == 'X') {
                            this.QxQ[row][column] = 'X';
                            changed = true;
                            equivalent = false;
                            break;
                        }
                    }

                    if (equivalent) {
                        this.QxQ[row][column] = ' ';
                    }
                }
            }
        } while (changed);
    }

    private int getAlphabetIndex(char a) {
        for (int i = 0; i < this.alphabet.length; i++) {
            if (this.alphabet[i] == a) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid symbol: " + a);
    }

    public static boolean numberInList(int[] list, int number) {
        for (int index = 0; index < list.length; index++) {
            if (list[index] == number) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the number of cases
        int cases = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        for (int c = 0; c < cases; c++) {
            // Reading number of states
            int n = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            // Reading the alphabet
            int alphabetSize = scanner.nextInt();
            char[] alphabet = new char[alphabetSize];
            for (int i = 0; i < alphabetSize; i++) {
                alphabet[i] = scanner.next().charAt(0);
            }

            // Reading final states
            int finalStatesCount = scanner.nextInt();
            int[] final_states = new int[finalStatesCount];
            for (int i = 0; i < finalStatesCount; i++) {
                final_states[i] = scanner.nextInt();
            }

            // Reading transition table
            int[][] transition_function = new int[n][alphabetSize];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < alphabetSize; j++) {
                    transition_function[i][j] = scanner.nextInt();
                }
            }

            // Initialize the DFA
            DFA dfa = new DFA(n, alphabet, transition_function, final_states);

            // Step 1: Initial marking
            dfa.initialMarking();

            // Step 2: Collapsing pairs recursively
            dfa.collapse();

            // Output the result
            System.out.println("Equivalent state pairs:");
            boolean found = false;
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < row; column++) {
                    if (dfa.QxQ[row][column] != 'X') {
                        System.out.println(row + " " + column);
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("No equivalent states found.");
            }
            System.out.println(); // Blank line after each case
        }

        scanner.close();
    }
}
