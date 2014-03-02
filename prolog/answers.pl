:- module(answers, [answer/2]).
:- use_module(library(dcg/basics)).
:- use_module(library(arithmetic)).

%%  q parsers the string from the request into the ID part and the
%%  Question part.
q(question(ID,Question)) -->
    %%  The assumtion is that the ID part of the question is a
    %%  hexadecimal-number.
    xinteger(ID), ": ", string(Question).

%%  Answer is the only publicly available predicate in this module. It
%%  takes a atom/string from the dispatch server and should return the
%%  answer as an atom/string.
answer(String, Answer) :-
    %%  It is easier to parse codes than atoms as they can be broken
    %%  apart.
    atom_codes(String, Codes),
    %%  Seperates the question from the ID. Here, the ID is not used.
    phrase(q(question(_, Question)), Codes),
    %%  Parse the Question with the what-parser.
    phrase(what(Answer), Question).


%% Parses a string similar to "the sum of 2 and 4".
arithmetic_expr(+(A,B)) --> "the sum of ", integer(A), " and ", integer(B).

%%  Parses code lists of the type "what is sum of 2 and 5" and returns
%%  the answer. The answer in the example should be 3.
what(Answer) -->
    "what is ", arithmetic_expr(Expr),
    {
     arithmetic_expression_value(Expr, Answer)
    }.
