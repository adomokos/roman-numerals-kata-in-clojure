(ns roman-numerals.printer-test
  (:require [clojure.test :refer :all]
            [roman-numerals.printer :refer :all]))

(deftest convert-test
  (testing "the roman numeral converter"
    (println (macroexpand-1 `(chopper 5 "V")))
    (are [x y] (= x y)
      "I"     (convert 1)
      "II"    (convert 2)
      "III"   (convert 3)
      "IV"    (convert 4)
      "V"     (convert 5)
      "VI"    (convert 6)
      "VII"   (convert 7)
      "VIII"  (convert 8)
      "IX"    (convert 9)
      "X"     (convert 10)
      "XI"    (convert 11)
      "XII"   (convert 12)
      "XIII"  (convert 13)
    )))