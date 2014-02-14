(ns roman-numerals.printer
  (use [clojure.string :only (join)]))

(defn- find-highest-reducer [for-number]
  (cond
    (>= for-number 49) {:arabic 50 :roman "L"}
    (>= for-number 9) {:arabic 10 :roman "X"}
    (>= for-number 4)  {:arabic 5  :roman "V"}
    :else {:arabic 1 :roman "I"}))

(defn convert
  "Converts the provided arabic number to roman numeral"
  ([input]
    (convert input ""))
  ([input converted]
    (let [highest-reducer (find-highest-reducer input)
          decremented-product (str converted "I" (:roman highest-reducer))
          product (str converted (:roman highest-reducer))]
      (cond
        (= 0 input) converted
        (= input (dec (:arabic highest-reducer))) decremented-product
        :else (convert (- input (:arabic highest-reducer)) product)))))
