(ns roman-numerals.printer-test
  (:require [clojure.test :refer :all]
            [roman-numerals.printer :refer :all]))

(deftest convert-test
  (testing "the roman numeral converter"
    ;(println (macroexpand-1 `(chopper 5 "V")))
    (are [x y] (= x y)
      "I"       (convert 1)
      "II"      (convert 2)
      "III"     (convert 3)
      "IV"      (convert 4)
      "V"       (convert 5)
      "VI"      (convert 6)
      "VII"     (convert 7)
      "VIII"    (convert 8)
      "IX"      (convert 9)
      "X"       (convert 10)
      "XI"      (convert 11)
      "XII"     (convert 12)
      "XIII"    (convert 13)
      "XIV"     (convert 14)
      "XV"      (convert 15)
      "XVI"     (convert 16)
      "XIX"     (convert 19)
      "XX"      (convert 20)
      "XXI"     (convert 21)
      "XXIII"   (convert 23)
      "XXIV"    (convert 24)
      "XXIX"    (convert 29)
      "XXXII"   (convert 32)
      "XXXIX"   (convert 39)
      "XL"      (convert 40)
      "XLI"     (convert 41)
      "XLIV"    (convert 44)
      "XLIX"    (convert 49)
      "L"       (convert 50)
      "LI"      (convert 51)
      "LIX"     (convert 59)
      "LXI"     (convert 61)
      "LXXIX"   (convert 79)
      "XC"      (convert 90)
      "C"       (convert 100)
      "CI"      (convert 101)
      "CXI"     (convert 111)
      "CXXXIX"  (convert 139)
      "CXL"     (convert 140)
      "CC"      (convert 200)
      "CCC"     (convert 300)
      "CCCI"    (convert 301)
      "CD"      (convert 400)
      "CDXCIX"  (convert 499)
      "D"       (convert 500)
      "DI"      (convert 501)
    )))
