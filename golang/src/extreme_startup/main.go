package main

import (
	"fmt"
	"log"
	"net/http"
	"strings"
)

const port = 9000

// main initializes the web server
func main() {
	http.HandleFunc("/", handler)
	log.Printf("Server listening on http://localhost:%d…\n", port)
	log.Fatal(http.ListenAndServe(fmt.Sprintf(":%d", port), nil))
}

// handler makes sure the request is valid and forward the question
// to the answer function
func handler(w http.ResponseWriter, req *http.Request) {
	log.Printf("Request received from %s\n", req.RemoteAddr)

	// parse query parameter q for question ID and text
	err := req.ParseForm()
	if err != nil {
		log.Printf("[Error] Could not parse request query values: %v\n", err)
		http.Error(w, http.StatusText(http.StatusBadRequest), http.StatusBadRequest)
		return
	}
	q := strings.TrimSpace(req.FormValue("q"))
	if q == "" {
		log.Println("[Error] No question in request")
		http.Error(w, http.StatusText(http.StatusBadRequest), http.StatusBadRequest)
		return
	}
	i := strings.Index(q, ":")
	if i <= 0 {
		log.Printf("[Error] Missing ID in question \"%s\"\n", q)
		http.Error(w, http.StatusText(http.StatusBadRequest), http.StatusBadRequest)
		return
	}
	id, question := strings.TrimSpace(q[:i]), strings.TrimSpace(q[i+1:])
	if question == "" {
		log.Printf("[Error] Question with ID \"%s\" empty", id)
		http.Error(w, http.StatusText(http.StatusBadRequest), http.StatusBadRequest)
		return
	}

	// answer question: reimplement this function in answer.go
	ans := answer(question, req)

	// log and return
	log.Printf("Q[%s]: %s\n", id, question)
	log.Printf("=> A: %s\n", ans)

	w.Write([]byte(ans))
}
