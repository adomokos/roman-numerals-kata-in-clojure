(ns roman-numerals.printer)

(def roman-numerals-conversions [
    {:arabic 500 :roman "D"}
    {:arabic 400 :roman "CD"}
    {:arabic 100 :roman "C"}
    {:arabic 90 :roman "XC"}
    {:arabic 50 :roman "L"}
    {:arabic 40 :roman "XL"}
    {:arabic 10 :roman "X"}
    {:arabic 9 :roman "IX"}
    {:arabic 5  :roman "V"}
    {:arabic 4  :roman "IV"}
    {:arabic 1  :roman "I"}])

(defn- find-highest-reducer [for-number]
  (let [highest-reducer (first (filter #(>= for-number (:arabic %)) roman-numerals-conversions))]
    (if (nil? highest-reducer)
      (last roman-numerals-conversions)
      highest-reducer)))

(defn convert
  "Converts the provided arabic number to roman numeral"
  ([input]
    (convert input ""))
  ([input converted]
    (let [highest-reducer (find-highest-reducer input)
          converted-number (str converted (:roman highest-reducer))
          decremented-input (- input (:arabic highest-reducer))]
      (if (= 0 input)
          converted ;; No need to convert more - exit
          (convert decremented-input converted-number)))))
