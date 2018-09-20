# Golang server

### Running

Make sure your `GOPATH` variable contains this `golang` directory,
then run `go install extreme_startup` to compile and `bin/extreme_startup` to run.

In one line (from this directory):

```sh
GOPATH=${PWD}:${GOPATH} go install extreme_startup && bin/extreme_startup
```

Ideally, you would have a file watcher to look after every `.go` file and to re-run this line after each change.

### Testing

The default server runs on port **9000**.
You may query it using cURL:

```sh
curl "http://localhost:9000?q=123:what%20is%20your%20favorite%20language"
```

### Implementing

- [`main.go`](/golang/src/extreme_startup/main.go) contains the low-level server code, for HTTP request handling: parsing and writing response. You probably won't need to edit this file.

- [`answer.go`](/golang/src/extreme_startup/answer.go) contains the `answer()` function, which you need to reimplement: use the given question (and, if necessary, the HTTP request object) to generate the answer to send to the client.
