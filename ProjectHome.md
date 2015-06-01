Constraint Satisfaction Problem solvers are usually written in some obscure logic language like Prolog, Lisp, Powerloom or other exotic variants of languages that no one has ever heard of.

In this implementation, I favoured the expression power of SQL over anything else and focused on creating a kind of "CSP engine" that would be capable of hiding the complexity of state management during solution finding, backtracking and the rest that is common to all CSP problems. Logic interpreters like Prolog do this automatically, but then you'd have to learn a new language :).

The speed is appalling for the smallest of problems. There is a possibility that the relative speed of problems becomes progressively better for much larger problems, but I doubt it.

The advantage of this approach is that you get valid solutions for particular problems within reasonable time frames without needing to code for the complexity.

The examples demonstrate the wide variety of problems that can be solved with this engine:
  * Sudoku (all problem difficulties)
  * Nqueens (the benchmarks against C are atrocious)
  * Scheduling problems (example demonstrates how to build a valid university schedule)
  * Travelling Salesman Problem
  * The zebra puzzle

The latter example shows that even logic problems can be solved with this engine, although the necessary incantations for that type of problems start to become a bit nauseous.

An interesting part about this approach is that you never get memory starvation and that databases help you organize your solution so far and you can index those solutions, allowing you to execute smarter queries on finding those values that can still combine towards a valid solution (you get smart indexing for free).

The objective for me to write this however is not to find methods to become faster in iterating through values, but on how clever you can get in eliminating invalid tupelizations as early as possible, versus brute-forcing through all possible combinations. Because of the network link involved and smarter queries, the total time towards a solution is still considerable... but if your problem is reasonably 'dividable' into sets of values, you may get a huge benefit here.

See the page: [how it works](http://code.google.com/p/cspdb/wiki/HowItWorks) for an explanation on how the engine works. The results, if there are any, are stored in the database itself. You'll also prepare the problem in the tables there. So you need no separate interface between this engine and your host language, except the capability of starting it as a process with the script as the parameter.