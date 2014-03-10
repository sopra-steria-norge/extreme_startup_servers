:- module(server, []).
:- use_module(answers).
:- use_module(library(http/thread_httpd)).
:- use_module(library(http/http_dispatch)).
:- use_module(library(http/http_log)).

server(Port) :-
    http_server(http_dispatch, [port(Port)]).

%%  Set up a dispatch server on the 8080 port.
:- server(1337).

%%  A predicate that sends a request to our answering predicate.
response(Request) :-
    %%  The query string from the GET-request is split into
    %%  'name/value pairs'-list and is contained in the search
    %%  term. We get value of 'q' by claiming that Request contains
    %%  search as a member and that it has a list of 1 name/value
    %%  pair, which is the pair q=Question.
    member(search([q=Question]), Request),
    %%  Log the Question to the standard httpd.log file.
    http_log('~w ~n', [Question]),
    %%  Ask for the answer to the question. The answer predicate is
    %%  defined in the answers module.
    answer(Question, Answer),
    %%  answer should return an atom so we print that atom to the log
    %%  and to the response.
    %%  The response begins with content type text/plain.
    format('Content-type: text/plain~n~n'),
    http_log('~a~n', [Answer]),
    format('~a~n', [Answer]).

%% If the response fails, just return an empty message. It is better
%% to return the wrong thing than not return anything at all.
response(_) :-
    format('Content-type: text/plain~n~n'),
    format('The wrong answer~n').

%%  Add response as the handler for the / path.
:- http_handler(/, response, []).
