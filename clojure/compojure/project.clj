(defproject extreme-startup "1.0.0-SNAPSHOT"
  :description "Extreme Startup server skeleton in Clojure"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [compojure "0.6.3"]]
  :dev-dependencies [[lein-ring "0.4.0"]]
  :ring {:handler extreme-startup.core/app})
