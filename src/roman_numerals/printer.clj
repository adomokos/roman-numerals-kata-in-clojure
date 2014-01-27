(ns roman-numerals.printer
  (use [clojure.string :only (join)]))

(defn- chop-one [[converted number]]
  (if (= number 0)
    converted
    (chop-one [(str converted "I") (dec number)])))

(defn chopper [chop-by-number roman-numeral]
   (fn [[converted number]]
      (cond
        (< number chop-by-number) [converted number]
        (= number chop-by-number) [(str converted roman-numeral) 0]
        :else [(str converted roman-numeral) (- number chop-by-number)])))

;(defn- chop-five [[converted number]]
  ;(cond
    ;(< number 5) [converted number]
    ;(= number 5) [(str converted "V") 0]
    ;:else [(str converted "V") (- number 5)]))

;(defn- chop-ten [number]
  ;(cond
    ;(< number 10) ["" number]
    ;(= number 10) ["X" 0]
    ;:else ["X" (- number 10)]))

(defn convert
  "Converts the provided arabic number to roman numeral"
  [input]
  (cond
    (< input 4) (chop-one ["" input])
    (= input 4) "IV"
    (= input 9) "IX"
    :else (-> ((chopper 10 "X") ["" input])
              ((chopper 5 "V"))
              chop-one)))
