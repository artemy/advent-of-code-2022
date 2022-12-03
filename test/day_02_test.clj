(ns day_02-test
  (:require 
    [clojure.test :refer [deftest is]]
    [day_02 :refer [part-01 part-02]]))

(deftest part-01-test
  (let [test-data [["A" "Y"]
                   ["B" "X"]
                   ["C" "Z"]]
        expected 15]
    (is (= expected (part-01 test-data)))))

(deftest part-02-test
  (let [test-data [["A" "Y"]
                   ["B" "X"]
                   ["C" "Z"]]
        expected 12]
    (is (= expected (part-02 test-data)))))