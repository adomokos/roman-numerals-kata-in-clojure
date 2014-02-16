(ns roman-numerals.printer
  (use [clojure.string :only (join)]))

(defn- find-highest-reducer [for-number]
  (cond
    (>= for-number 100){:arabic 100 :roman "C"}
    (>= for-number 90) {:arabic 90 :roman "XC"}
    (>= for-number 50) {:arabic 50 :roman "L"}
    (>= for-number 40) {:arabic 40 :roman "XL"}
    (>= for-number 10)  {:arabic 10 :roman "X"}
    (= for-number 9)  {:arabic 9 :roman "IX"}
    (>= for-number 5)  {:arabic 5  :roman "V"}
    (= for-number 4)   {:arabic 4  :roman "IV"}
    :else {:arabic 1 :roman "I"}))

(defn convert
  "Converts the provided arabic number to roman numeral"
  ([input]
    (convert input ""))
  ([input converted]
    (let [highest-reducer (find-highest-reducer input)
          converted-number (str converted (:roman highest-reducer))
          decremented-input (- input (:arabic highest-reducer))]
      (cond
        (= 0 input) converted ;; No need to convert more - exit
        :else (convert decremented-input converted-number)))))
