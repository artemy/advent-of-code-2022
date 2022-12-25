(ns day_08-test
  (:require 
    [clojure.test :refer [deftest is]]
    [day_08 :refer [part-01 part-02]]))


(def test-data ["30373"
                "25512"
                "65332"
                "33549"
                "35390"])

(deftest part-01-test
  (let [expected 21]
    (is (= expected (part-01 test-data)))))

(deftest part-02-test
  (let [expected 8]
    (is (= expected (part-02 test-data)))))