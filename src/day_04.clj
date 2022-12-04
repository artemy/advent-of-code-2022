(ns day_04
  (:require 
    [utils :refer [open-resource parse-int]]
    [clojure.string :refer [split]]))

(def input-file "day_04.txt")

(def data 
  (->> input-file
    open-resource
    (map #(split % #"(-|,)"))
    (map #(map parse-int %))))

(defn part-01 [input]
  (let [included (fn [x] (let [s1 (nth x 0)
                               e1 (nth x 1)
                               s2 (nth x 2)
                               e2 (nth x 3)]
                           (or (<= s1 s2 e2 e1) (<= s2 s1 e1 e2))))]
    (->> input
      (filter included)
      (count))))

(defn part-02 [input]
  (let [included (fn [x] (let [s1 (nth x 0)
                               e1 (nth x 1)
                               s2 (nth x 2)
                               e2 (nth x 3)]
                           (or 
                             (<= s1 s2 e1 e2)
                             (<= s2 s1 e2 e1)
                             (<= s1 s2 e2 e1)
                             (<= s2 s1 e1 e2))))]
    (->> input
      (filter included)
      (count))))

(defn -main [& _]
  (println "Day 04:")
  (println "\t-> Part 1: " (part-01 data))
  (println "\t-> Part 2: " (part-02 data)))