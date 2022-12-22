(ns day_03
  (:require 
    [utils :refer [open-resource]]
    [clojure.set :refer [intersection]]))

(def input-file "day_03.txt")

(def data 
  (->> input-file
    open-resource))

(defn get-priority [letter] 
  (let [i (int letter)]
    (if (<= (int \a) i (int \z))
      (- i 96)
      (- i 38))))

(defn part-01 [input]
  (->> input
    (map #(partition (/ (count %) 2) %))
    (map #(map (fn [x] (set x)) %))
    (mapcat #(apply intersection %))
    (map get-priority)
    (reduce +)))

(defn part-02 [input]
  (->> input
    (partition 3)
    (map #(map (fn [x] (set x)) %))
    (mapcat #(apply intersection %))
    (map get-priority)
    (reduce +)))

(defn -main [& _]
  (println "Day 03:")
  (println "\t-> Part 1: " (part-01 data))
  (println "\t-> Part 2: " (part-02 data)))