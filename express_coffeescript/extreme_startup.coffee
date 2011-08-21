express = require 'express'

# Reimplement this function to answer questions.
answer = (query, req, res) ->
  "Bodil"

app = express.createServer()
app.use express.cookieParser()
app.use express.session
  secret: "bodilpwnz"

app.get '/', (req, res) ->
  q = req.param("q")
  a = answer q, req, res
  console.log "Q: \"#{q}\" A: \"#{a}\""
  res.end a

app.listen 1337, "0.0.0.0"
console.log "Server running on http://0.0.0.0:1337/"

