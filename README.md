# Wrap text function - exercise
## Description
The 'Wrap text' function should:
- Receive a string and a length as parameters.
- Return the string, but with new lines ("\n") added to ensure that no line is longer than $length characters. 
- Always wrap at word boundaries if possible, 
- only break a word if it is longer than $length characters. 
- When breaking at word boundaries, replace all the whitespace between the two words with a single newline character. 
- Any unbroken whitespace should be left unchanged.

## Running output 
```
Trying: 'This is extremely simple          text for automatically testing purposes.   ' [4]
1234
This
is
ext-
rem-
ely
sim-
ple
text
for
aut-
oma-
tic-
ally
tes-
ting
pur-
pos-
es.

Trying: 'This is extremely simple          text for automatically testing purposes.   ' [8]
12345678
This is
extreme-
ly
simple
text
for aut-
omatica-
lly
testing
purpose-
s.

Trying: 'This is extremely simple          text for automatically testing purposes.   ' [12]
123456789012
This is
extremely
simple
text for au-
tomatically
testing
purposes.

Trying: 'This is extremely simple          text for automatically testing purposes.   ' [16]
1234567890123456
This is
extremely
simple
text for
automatically
testing
purposes.

Trying: 'This is extremely simple          text for automatically testing purposes.   ' [24]
123456789012345678901234
This is extremely
simple          text
for automatically
testing purposes.

Trying: 'This is extremely simple          text for automatically testing purposes.   ' [32]
12345678901234567890123456789012
This is extremely simple
text for automatically testing
purposes.

Trying: 'This is extremely simple          text for automatically testing purposes.   ' [40]
1234567890123456789012345678901234567890
This is extremely simple          text
for automatically testing purposes.

Trying: 'This is extremely simple          text for automatically testing purposes.   ' [100]
1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
This is extremely simple          text for automatically testing purposes.

```
