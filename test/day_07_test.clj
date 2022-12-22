(ns day_07-test
  (:require 
    [clojure.test :refer [deftest is]]
    [day_07 :refer [part-01 part-02]]))


(def test-data ["$ cd /"
                "$ ls"
                "dir a"
                "14848514 b.txt"
                "8504156 c.dat"
                "dir d"
                "$ cd a"
                "$ ls"
                "dir e"
                "29116 f"
                "2557 g"
                "62596 h.lst"
                "$ cd e"
                "$ ls"
                "584 i"
                "$ cd .."
                "$ cd .."
                "$ cd d"
                "$ ls"
                "4060174 j"
                "8033020 d.log"
                "5626152 d.ext"
                "7214296 k"])

(deftest part-01-test
  (let [expected 95437]
    (is (= expected (part-01 test-data)))))

(deftest part-02-test
  (let [expected 24933642]
    (is (= expected (part-02 test-data)))))