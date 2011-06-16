http = require "http"
url = require "url"

# Reimplement this function to answer questions.
answer = (query) ->
  "Bodil"

http.createServer (req, res) ->
  res.writeHead 200, { "Content-Type": "text/plain" }
  q = (url.parse(req.url, true)).query.q
  a = answer q
  console.log "Q: #{q} A: #{a}"
  res.end a
.listen(1337, "0.0.0.0");
console.log "Server running on http://0.0.0.0:1337/"

