def main():
    test()

# Ansi signs used for natural deduction
# capitals are used for variables
# > is used for implication
# * is used for conjunction
# + is used for disjunction
# - is used for negation
# _ is used for bottom


# 

variables = {"A" : True, "B" : False}

def test():
    a = [["A", "*", "A"], "+", "B"]
    b = recSolver(a)
    print(b)

def recSolver(formula):
    if type(formula[0]) == type([]):
        for1 = recSolver(formula[0])
    else :
        for1 = variables[formula[0]]

    if type(formula[2]) ==  type([]):
        for2 = recSolver(formula[3])
    else :
        for2 = variables[formula[2]]

    if formula[1] == ">":
        return not for1 or for2
    elif formula[1] == "*":
        return for1 and for2
    elif formula[1] == "+":
        return for1 or for2
    elif formula[1] == "-":
        return not for1
    elif formula[1] == "_":
        return False


def enhancedRecSolve(formula):
    if type(formula[0]) == type([]):
        for1 = recSolver(formula[0])
    

if __name__ == "__main__":
    main()