(ns day_05-test
  (:require 
    [clojure.test :refer [deftest is]]
    [day_05 :refer [part-01 part-02]]))


(deftest part-01-test
  (let [test-data 
        {:stack {:1 '("Z" "N"), :2 '("M" "C" "D"), :3 '("P")}
         :commands [{:amount 1 :from :2 :to :1}
                    {:amount 3 :from :1 :to :3}
                    {:amount 2 :from :2 :to :1}
                    {:amount 1 :from :1 :to :2}]}
        
        expected "CMZ"]
    (is (= expected (part-01 test-data)))))


(deftest part-02-test
  (let [test-data 
        {:stack {:1 '("Z" "N"), :2 '("M" "C" "D"), :3 '("P")}
         :commands [{:amount 1 :from :2 :to :1}
                    {:amount 3 :from :1 :to :3}
                    {:amount 2 :from :2 :to :1}
                    {:amount 1 :from :1 :to :2}]}
        
        expected "MCD"]
    (is (= expected (part-02 test-data)))))