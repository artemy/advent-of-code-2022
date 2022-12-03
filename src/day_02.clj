(ns day_02
  (:require 
    [utils :refer [open-resource]]
    [clojure.string :refer [split]]))

(def input-file "day_02.txt")

(def data (let [split-by-space #(split % #" ")]
            (->> input-file
              open-resource
              (map split-by-space))))

; A/X = rock, B/Y = paper, C/Z = scissors


(def scores {"X" 1
             "Y" 2
             "Z" 3})


(def result {"AX" 3
             "BY" 3
             "CZ" 3
             
             "BX" 0
             "CY" 0
             "AZ" 0
             
             "CX" 6
             "AY" 6
             "BZ" 6})

; X = lose, Y = draw, Z = win

(def cheating-result {"AX" "Z"
                      "BX" "X"
                      "CX" "Y"
             
                      "AY" "X"
                      "BY" "Y"
                      "CY" "Z"
             
                      "AZ" "Y"
                      "BZ" "Z"
                      "CZ" "X"})

(defn part-01 [input]
  (->> input 
    (map (fn [x] (+
                   (get scores (second x)) 
                   (get result (apply str x)))))
    (reduce + )))

  
(defn part-02 [input]
  (->> input 
    
    (map (fn [x] (vector
                  (first x)
                  (get cheating-result (apply str x))
                  )))
    (map (fn [x] (+
                   (get scores (second x)) 
                   (get result (apply str x)))))
    (reduce + )))

(defn -main [& _]
  (println "Day 02:")
  (println "\t-> Part 1: " (part-01 data))
  (println "\t-> Part 2: " (part-02 data)))