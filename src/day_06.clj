(ns day_06
  (:require 
    [utils :refer [open-resource]]))

(def input-file "day_06.txt")

(def data 
  (->> input-file
    open-resource
    first))

(def test-data "mjqjpqmgbljsphdztnvjfqwrcgsmlb")

(defn find-marker [marker-length x]
  (loop [pos marker-length]
    (let [head (take pos x)
          packet (take-last marker-length head)]
      (if (or (< marker-length (count packet)) (apply distinct? packet))
        head
        (recur (inc pos))))))

(defn part-01 [input]
  (->> input
    (find-marker 4)
    count))

(defn part-02 [input]
  (->> input
    (find-marker 14)
    count))

(defn -main [& _]
  (println "Day 06:")
  (println "\t-> Part 1: " (part-01 data))
  (println "\t-> Part 2: " (part-02 data)))