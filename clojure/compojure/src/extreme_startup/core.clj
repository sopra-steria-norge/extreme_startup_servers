(ns extreme-startup.core
  (:use compojure.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]))

(defroutes main-routes
  (GET "/" [q] (str "ohai " q))
  (route/not-found "omg 404"))

(def app
  (handler/site main-routes))
