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
Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [2]
12
T-
h-
is
is
e-
x-
t-
r-
e-
m-
e-
ly
s-
i-
m-
p-
le
t-
e-
x-
t.
J-
u-
st
f-
or
a-
u-
t-
o-
m-
a-
t-
i-
c-
a-
l-
ly
t-
e-
s-
t-
i-
ng
p-
u-
r-
p-
o-
s-
e-
s.

Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [4]
1234
This
is 
ext-
rem-
ely 
sim-
ple 
tex-
t.
Just
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

Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [8]
12345678
This is 
extreme-
ly 
simple 
text.
Just for
automat-
ically 
testing 
purpose-
s.   
Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [12]
123456789012
This is 
extremely 
simple 
text.
Just for au-
tomatically 
testing 
purposes.   
Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [16]
1234567890123456
This is 
extremely simple
text.
Just for 
automatically 
testing 
purposes.   
Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [24]
123456789012345678901234
This is extremely simple
text.
Just for automatically 
testing purposes.   
Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [32]
12345678901234567890123456789012
This is extremely simple 
text.
Just for automatically testing 
purposes.   
Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [40]
1234567890123456789012345678901234567890
This is extremely simple          text.
Just for automatically testing purposes.

Trying: 'This is extremely simple          text.
Just for automatically testing purposes.   ' [100]
1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
This is extremely simple          text.
Just for automatically testing purposes.   
Trying: 'test
Testing' [4]
1234
test
Tes-
ting
Trying: 'test
Testing' [5]
12345
test
Test-
ing
Trying: 'test
Testing' [50]
12345678901234567890123456789012345678901234567890
test
Testing


```
