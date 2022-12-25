(ns utils
  (:require 
    [clojure.java.io :as io]
    [clojure.string :refer [split-lines]]))

(defn open-resource [input-file]
  (let [data-file (io/resource input-file)]
    (->> data-file slurp split-lines)))

(defn parse-int [v] (Integer/parseInt v 10))

; from https://groups.google.com/g/clojure-dev/c/NaAuBz6SpkY
(defn take-until
  "Returns a lazy sequence of successive items from coll until
   (pred item) returns true, including that item. pred must be
   free of side-effects."
  [pred coll]
  (lazy-seq
    (when-let [s (seq coll)]
      (if (pred (first s))
        (cons (first s) nil)
        (cons (first s) (take-until pred (rest s)))))))