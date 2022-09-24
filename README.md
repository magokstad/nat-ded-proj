# Untitled Nat-Ded Project

#### Intro
I think it is going to be a game eventually.
I worked on this early summer 2022, and forgor to make a repo. 

#### Generation
So far it generates all possible tautologies using X amount of variables, and a max depth D.
The recursive depth of the tautology definition cannot surpass D, meaning ( A and (A and (A and A)) is ok, but (A and ( A and (A and (A and A))) is not ok.
I have some parameters limiting what tautologies are generated, like (A and (A or B)) being equivalent with ((A or B) and A))

#### Settings
The default settings are:
- X=2 (two variables "A" and "B")
- D=3 (max "recursive depth" of 3)

#### Future
It kind of makes no sense to code this in java, other than that JVM is nice for cross compatibility. 
Both the syntax, and semantics of the program would feel more at home in a functional lisp-like programming language.
I might try clojure as a best of both worlds scenario, or choose something outside the JVM for BLAZINGLY FAST speed.
