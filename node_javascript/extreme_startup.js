var http = require("http");
var url = require("url");

/* Reimplement this function to answer questions. */
var answer = function(question) {
    return "Bodil";
};

http.createServer(function(req, res) {
    var a, q;
    res.writeHead(200, { "Content-Type": "text/plain" });
    q = url.parse(req.url, true).query.q;
    a = answer(q);
    console.log("Q: " + q + " A: " + a);
    res.end(a);
}).listen(1337, "0.0.0.0");

console.log("Server running on http://0.0.0.0:1337/");

