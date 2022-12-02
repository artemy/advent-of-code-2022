(ns day_01
  (:require 
    [utils :refer [open-resource parse-int]]
    [clojure.string :refer [blank?]]))

(def input-file "day_01.txt")

(def data (let [group-calories #(partition-by blank? %)
                all-blanks? #(every? (fn [x] (blank? x)) %)]
            (->> input-file
              open-resource
              group-calories
              (remove all-blanks?)
              (map #(map parse-int %)))))

(defn part-01 [input]
  (let [add #(reduce + 0 %)]
    (->> input (map add) (apply max))))
  
(defn part-02 [input]
  (let [add #(reduce + 0 %)]
    (->> input (map add) sort reverse (take 3) (reduce +))))


(defn -main [& _]
  (println "Day 01:")
  (println "\t-> Part 1: " (part-01 data))
  (println "\t-> Part 2: " (part-02 data)))