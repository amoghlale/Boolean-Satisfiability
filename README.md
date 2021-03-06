# Boolean-Satisfiability
This program will be worth twice the normal amount (6%), and there is no fixed algorithm that you will need to implement. Your job is to think about the problem, think of some strategies, and come up with the best solution that you can. There are a number of known methods that are pretty good (Davis & Putnam, Chaff, Grasp, ...).
Many problems you will run into in the real world are NP-Complete. You will need to use heuristics. You will need to be clever. You will need to develop your own solutions. Not everything in life is simply Googling to get source code, or having a friend write it for you.
The input files will be 3-CNF Satisfiability problems. The first line will tell you the number of variables, and the number of clauses. The remaining lines will tell you the variables in each clause. The variables are numbered 1 through n (note -- we start at 1). A "true" value for the variable is positive, a "false" version is negative.
For example, if we have a problem with one clause, and three variables (we'll call A, B, and C), the problem might be "(A + !B + !C)." The equation evaluates to true if A is true, or if B or C are false.
The input might look like this.
  3 1
  1 -2 -3
  
The first variable, A, is true (and positive). The next two are negated, (and are negative).
Your program should read in the input file, and try to find a setting of the variables that makes the entire equation evaluate to true. With more clauses... it's harder than it looks.
If you find a way to satisfy the equation, print the true or false settings for each variable (in order, from 1 to n). Print them out as zero or one. For example, the problem above would have this as one possible answer.
1
1
0
This corresponds to A and B being true, and C being false. Both the first and third variable would satisfy the clause.
I will be checking carefully for originality in this assignment. Come up with your own code. A working program will get 50% of the total possible score. I will run your programs on a few large inputs; the remaining points will be allocated based on run times (the faster programs will get more points). Make sure you comment your code, and give a bit of explanation as to what you are doing, and why.  Put your name in the code too, so that if you come up with a clever way to solve the Satisfiability problem, you can be correctly credited as one of the most brilliant minds in history!
•	Sat 1: lots of ways to answer, "1 0 0" would be another correct way.
•	Sat 2: not satisfiable
•	Sat 3: not satisfiable (three variables, every possible combination required)
•	Sat 4
•	Sat 5
•	Sat 6
