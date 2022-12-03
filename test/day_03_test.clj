(ns day_03-test
  (:require 
    [clojure.test :refer [deftest is]]
    [day_03 :refer [part-01 part-02]]))


(deftest part-01-test
  (let [test-data ["vJrwpWtwJgWrhcsFMMfFFhFp"
                   "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
                   "PmmdzqPrVvPwwTWBwg"
                   "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"
                   "ttgJtRGJQctTZtZT"
                   "CrZsJsPPZsGzwwsLwLmpwMDw"]
        expected 157]
    (is (= expected (part-01 test-data)))))


(deftest part-02-test
  (let [test-data ["vJrwpWtwJgWrhcsFMMfFFhFp"
                   "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
                   "PmmdzqPrVvPwwTWBwg"
                   "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"
                   "ttgJtRGJQctTZtZT"
                   "CrZsJsPPZsGzwwsLwLmpwMDw"]
        expected 70]
    (is (= expected (part-02 test-data)))))