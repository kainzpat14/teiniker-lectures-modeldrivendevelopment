# Metamodel Regular Expressions

## Task 

Create a metamodel based on the following domain description in any format you prefer (ex. PlantUML, Handdrawn)

## Domain

Regular Expressions are used quite often in software development. They allow matching of strings against the 
syntax of a regular language, enabling the programmer to ensure that the text is valid and enabling them to 
extract certain parts of it. 

This domain uses simplified regular expressions: 

Each regular expression contains a root group that can contain a sequence of other groups or matchers. 
Each child group has a multiplicity (0..1, 0..\*, 1, 1..\*, a fixed number or range). 
Each matcher consists of a token and a multiplicity.

Each token can either be a simple token like:
- a character (ex. "a")
- a range (ex. "a-z")
- any character (ie. the ".")

Or a composite token that contains simple tokens of which one must occur, for example [a-zA-Z_] allows 
either a character between a and z, A and Z or the character "_". 

Example:

The regular expression "Hal{2}o( [A-Z][a-z0-9]+)?([!\\.]+).*"
Has a root group, which consists of the matchers: 
- character H multiplicity 1
- character a multiplicity 1
- character l multiplicity 2
- character o multiplicity 1

Followed by a childgroup with multiplicity 0..1 containing the matchers:
- character " " multiplicity 1
- a composite token containing the range A-Z with the multiplicity 1
- a composite token containing the ranges a-z and 0-9 and multiplicity 1..*

This is then followed by another child group with multiplicity 1 containing a composite token with 
multiplicity 1..* having either:
- character ! 
- character . 

And finally we have any character with multiplicity 0..*