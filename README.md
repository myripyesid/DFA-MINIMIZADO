# DFA Minimization Algorithm in Java
Proyecto de Marbin Yesid Rivera Ciro, para la materia de Lenguajes formales y compiladores. El objetivo fue implementar el algoritmo que busca estados equivalentes en un DFA explicado en KOZEN 1997, Lecture 14.

## Descripción del Código

El programa realiza dos pasos principales para minimizar un DFA:

1. **Marcado Inicial**: Marca inicialmente los pares de estados como no equivalentes si uno de los estados es final y el otro no.
2. **Colapso**: Revisa todos los pares de estados no marcados y verifica si tienen transiciones a pares de estados que ya han sido marcados como no equivalentes. Si es así, se marcan como no equivalentes.

### Formato de Entrada

1. **Número de Casos**:
   - Un entero que indica la cantidad de conjuntos de datos que se procesarán.

2. **Para Cada Caso**:
   - **Número de Estados**:
     - Un entero que especifica el número total de estados en el DFA.
   - **Tamaño del Alfabeto**:
     - Un entero que representa el número de símbolos en el alfabeto del DFA.
   - **Símbolos del Alfabeto**:
     - Una línea con los símbolos del alfabeto, separados por espacios.
   - **Número de Estados Finales**:
     - Un entero que indica cuántos estados son finales.
   - **Tabla de Transiciones**:
     - Una matriz que describe las transiciones del DFA. Cada fila representa un estado, y cada columna representa un símbolo del alfabeto. Los valores en la matriz indican el estado al que se transiciona con el símbolo correspondiente.
     - **Estados Finales**:
     - Una línea con los índices de los estados finales, separados por espacios.

### Ejemplo de Entrada
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



### Explicación del Código

1. **Clase `DFA`**:
   - **`states`**: Arreglo de estados del DFA.
   - **`alphabet`**: Array de caracteres que representa el alfabeto del DFA.
   - **`transition_function`**: Matriz que define las transiciones del DFA. `transition_function[i][j]` indica el estado al que transiciona el estado `i` con el símbolo `j`.
   - **`final_states`**: Array que contiene los índices de los estados finales.
   - **`QxQ`**: Matriz utilizada para marcar pares de estados como equivalentes o no equivalentes.

2. **Métodos**:
   - **`initialMarking()`**:
     - Marca como no equivalentes los pares de estados en los que uno es final y el otro no.
   - **`collapse()`**:
     - Revisa los pares de estados no marcados. Si ambos estados tienen transiciones a pares de estados ya marcados como no equivalentes, los estados se marcan como no equivalentes.
   - **`getAlphabetIndex(char a)`**:
     - Devuelve el índice del símbolo en el alfabeto.
   - **`numberInList(int[] list, int number)`**:
     - Verifica si un número está en una lista de enteros.

3. **Clase `Main`**:
   - **Entrada**: Lee los datos de entrada desde la consola.
   - **Proceso**:
     - Inicializa el DFA.
     - Realiza el marcado inicial y el colapso de pares de estados.
     - Imprime los pares de estados equivalentes encontrados.
   - **Salida**:
     - Muestra los pares de estados equivalentes encontrados o indica si no se encontraron pares equivalentes.




