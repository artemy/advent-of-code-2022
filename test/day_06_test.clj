(ns day_06-test
  (:require 
    [clojure.test :refer [deftest are]]
    [day_06 :refer [part-01 part-02]]))

(deftest part-01-test
  (are [input expected]
    (= (part-01 input) expected)
    "mjqjpqmgbljsphdztnvjfqwrcgsmlb" 7
    "bvwbjplbgvbhsrlpgdmjqwftvncz" 5
    "nppdvjthqldpwncqszvftbrmjlhg" 6
    "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" 11))

(deftest part-02-test
  (are [input expected]
    (= (part-02 input) expected)
    "mjqjpqmgbljsphdztnvjfqwrcgsmlb" 19
    "bvwbjplbgvbhsrlpgdmjqwftvncz" 23
    "nppdvjthqldpwncqszvftbrmjlhg" 23
    "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" 29
    "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" 26))