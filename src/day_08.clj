(ns day_08
  (:require 
    [utils :refer [open-resource take-until]]
    [clojure.string :refer [join]]))

(def input-file "day_08.txt")

(def data 
  (->> input-file
    open-resource))

(defn find-visible 
  [input]
  (let [cols (-> input first count)
        rows (-> input count)
        build-coordinates (fn [i x] [[(rem i cols) (quot i rows)] (Character/digit ^char x 10)])
        coordinate-map (fn [in] (->> in join (map-indexed build-coordinates) (into {})))
        prepared-data (->> input coordinate-map)
      
        find-top (fn [[x y]] (mapv vector (repeat x) (range 0 y)))
        find-bottom (fn [[x y]] (mapv vector (repeat x) (range (inc y) rows)))
        find-left (fn [[x y]] (mapv vector (range 0 x) (repeat y)))
        find-right (fn [[x y]] (mapv vector (range (inc x) rows) (repeat y)))
      
        adjacent-coord-fns [find-top find-bottom find-left find-right]
      
        lower? #(fn [[_ height]] (< height %))
        visible-by? (fn [[coords height]]
                      #(let [to-compare (select-keys prepared-data (% coords))]
                         (or (empty? to-compare) (every? (lower? height) to-compare))))
        visible? (fn [v] (some true? (map (visible-by? v) adjacent-coord-fns)))
        ]
    (select-keys prepared-data (for [[k _ :as entry] prepared-data :when (visible? entry)] k))))


(defn part-01 [input]
  (->> input
    find-visible
    count))

(defn find-scenic-scores 
  [input]
  (let [cols (-> input first count)
        rows (-> input count)
        build-coordinates (fn [i x] [[(rem i cols) (quot i rows)] (Character/digit ^char x 10)])
        coordinate-map (fn [in] (->> in join (map-indexed build-coordinates) (into {})))
        prepared-data (->> input coordinate-map)
      
        find-top (fn [[x y]] (mapv vector (repeat x) (range (dec y) -1 -1)))
        find-bottom (fn [[x y]] (mapv vector (repeat x) (range (inc y) rows)))
        find-left (fn [[x y]] (mapv vector (range (dec x) -1 -1) (repeat y)))
        find-right (fn [[x y]] (mapv vector (range (inc x) rows) (repeat y)))
      
        adjacent-coord-fns [find-top find-bottom find-left find-right]
      
        lower? #(fn [[_ height]] (>= height %))
        find-visible-trees-by (fn [[coords height]] #(take-until (lower? height) (select-keys prepared-data (% coords))))
        find-viewing-distance (fn [v] (mapv (find-visible-trees-by v) adjacent-coord-fns))
        find-scenic-score (fn [v] (reduce * (map count (find-viewing-distance v))))]
    (->> prepared-data
      (map find-scenic-score))))

(defn part-02 [input]
  (->> input
    find-scenic-scores
    (apply max)))

(defn -main [& _]
  (println "Day 08:")
  (println "\t-> Part 1: " (part-01 data))
  (println "\t-> Part 2: " (part-02 data)))