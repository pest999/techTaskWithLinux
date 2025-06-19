# Technical Task: Calculator Testing

## Task Description

Choose one of the following tools that performs basic arithmetic operations (+, -, *, /) on numbers:

1. `expr 1 + 2`
2. `echo "3 * 4" | bc`
3. `awk 'BEGIN {print 5 / 7}'`
4. `python3 -c 'print(7-9)'`
5. `bash -c 'echo $((5 + 10 * 2))'`

## Requirements

1. Write unit tests for all basic arithmetic operations (+, -, *, /) on numbers
2. Tests must run on Linux command line
3. Tests should be written in Java
4. You can use any form of communication with the tested software:
   - Direct communication if your language allows it
   - Interprocess communication if needed
5. Find the limits of the given software
6. Check error reporting

## Implementation Details

### Chosen Tool
The project uses the `bc` calculator utility (option 2) because:
- It's a dedicated calculator tool
- Provides good precision for floating-point operations
- Widely available on Linux systems
- Has clear error reporting
- Easy to communicate with through process execution

## Running Tests
See README.md for detailed instructions on how to run the tests. 