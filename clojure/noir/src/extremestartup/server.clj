(ns extremestartup.server
  (:use noir.core)
  (:require [noir.server :as server]
            [extremestartup.rules :as rules]))

(defpage "/" {:keys [q]} (rules/dispatcher q))

(defn -main [& m]
  (let [mode (keyword (or (first m) :prod))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'extreme-startup})))

