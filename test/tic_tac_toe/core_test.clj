(ns tic-tac-toe.core-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.core :refer :all]))

(deftest sanity
  (testing "sanity"
    (is (= true (winner? :x [[nil :x nil] [nil :x nil] [nil :x nil]])))))
