(ns day_05
  (:require 
    [utils :refer [open-resource parse-int]]
    [clojure.string :refer [blank?]]))

(def input-file "day_05.txt")

(def data 
  (let [letter? #(or (Character/isLetter %) (Character/isDigit %))
        to-map (fn [[f & r]] (hash-map (keyword f) r))
        parse-command (fn [[amount from to]] (hash-map :amount (parse-int amount) :from (keyword from) :to (keyword to)))
        clean-input (partition-by blank? (->> input-file open-resource))
        stack (->> clean-input
                first
                reverse
                (apply mapv vector)
                (map #(filter letter? %))
                (remove empty?)
                (map #(map str %))
                (map to-map)
                (into {}))
        commands (->> clean-input
                   last
                   (map #(re-seq #"\d+" %))
                   (map parse-command))]
    (hash-map 
      :stack stack
      :commands commands)))

(defn part-01 [input]
  (let [process (fn [{stack :stack commands :commands}]
                  (loop [stack stack
                         commands commands]
                    (let [[command & rest] commands
                          new-stack (->> stack
                                      (#(update-in
                                          %
                                          [(:to command)]
                                          concat
                                          (reverse 
                                            (take-last 
                                              (:amount command)
                                              ((:from command) %)))))
                                      (#(update-in
                                          %
                                          [(:from command)]
                                          (fn [x] (drop-last (:amount command) x)))))]
                      (if rest
                        (recur new-stack rest)
                        new-stack))))]
    (->> input
      process
      (into (sorted-map))
      vals
      (map last)
      (apply str))))

(defn part-02 [input]
  (let [process (fn [{stack :stack commands :commands}]
                  (loop [stack stack
                         commands commands]
                    (let [[command & rest] commands
                          new-stack (->> stack
                                      (#(update-in
                                          %
                                          [(:to command)]
                                          concat
                                          (take-last 
                                            (:amount command)
                                            ((:from command) %))))
                                      (#(update-in
                                          %
                                          [(:from command)]
                                          (fn [x] (drop-last (:amount command) x)))))]
                      (if rest
                        (recur new-stack rest)
                        new-stack))))]
    (->> input
      process
      (into (sorted-map))
      vals
      (map last)
      (apply str))))

(defn -main [& _]
  (println "Day 05:")
  (println "\t-> Part 1: " (part-01 data))
  (println "\t-> Part 2: " (part-02 data)))