from flask import Flask, request
app = Flask(__name__)

@app.route("/")
def answer():
    q = request.args.get("q", "")
    return "Flask"

if __name__ == "__main__":
    app.run(debug=True)

