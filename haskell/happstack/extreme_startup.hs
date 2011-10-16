-- To install required deps: 
-- $ cabal install happstack-server

module Main where

import Happstack.Server (ServerPart, look, nullConf, simpleHTTP, ok)

answerQuestion :: String -> String
answerQuestion question = "ohai " ++ question

server :: ServerPart String
server =
  do query <- look "q"
     ok $ answerQuestion query

main :: IO()
main = simpleHTTP nullConf $ server
