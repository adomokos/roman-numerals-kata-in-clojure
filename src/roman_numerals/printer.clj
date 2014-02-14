(ns roman-numerals.printer
  (use [clojure.string :only (join)]))

(defn- chop-one [[converted number]]
  (if (= number 0)
    converted
    (chop-one [(str converted "I") (dec number)])))

(defn- chopper [chop-by-number roman-numeral]
   (fn [[converted number]]
      (cond
        (= number chop-by-number) [(str converted roman-numeral) 0]
        (= number (dec chop-by-number)) [(str "I" roman-numeral) 0]
        (< number chop-by-number) [converted number]
        :else [(str converted roman-numeral) (- number chop-by-number)])))

(defn convert
  "Converts the provided arabic number to roman numeral"
  [input]
    (-> ((chopper 10 "X") ["" input])
        ((chopper 10 "X"))
        ((chopper 5 "V"))
          chop-one))
