(ns extremestartup.rules
  (:use clojure.test))

(defmacro testrule
  "Tests a sequence of questions and expected answers."
  [& pairs]
  `(deftest testanswer#
     ~@(for [pair (partition 2 pairs)]
         (let [question (first pair)
               expected (fnext pair)]
           `(is (= ~expected (~'dispatcher ~question)))))))

(defn dispatcher [q] (str "ohai " q "!"))

(testrule "bird" "ohai bird!"
          "pig" "ohai pig!")

