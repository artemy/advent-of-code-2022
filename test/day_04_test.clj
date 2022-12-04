(ns day_04-test
  (:require 
    [clojure.test :refer [deftest is]]
    [day_04 :refer [part-01 part-02]]))


(deftest part-01-test
  (let [test-data [[2 4 6 8]
                   [2 3 4 5]
                   [5 7 7 9]
                   [2 8 3 7]
                   [6 6 4 6]
                   [2 6 4 8]]
        expected 2]
    (is (= expected (part-01 test-data)))))


(deftest part-02-test
  (let [test-data [[2 4 6 8]
                   [2 3 4 5]
                   [5 7 7 9]
                   [2 8 3 7]
                   [6 6 4 6]
                   [2 6 4 8]]
        expected 4]
    (is (= expected (part-02 test-data)))))