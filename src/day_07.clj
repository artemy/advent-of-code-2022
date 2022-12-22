(ns day_07
  (:require 
    [utils :refer [open-resource parse-int]]
    [clojure.string :refer [starts-with? split]]))

(def input-file "day_07.txt")

(def data (->> input-file open-resource))

(defn is-command? [x] (starts-with? x "$"))

(defn calculate-total-size [x] (->> x
                                 (tree-seq map? #(interleave (keys %) (vals %)))
                                 (filter map?)
                                 (filter #(contains? % :size))
                                 (keep :size)
                                 (reduce +)))

(defn build-tree [x]
  (->> (loop [[current & rest] x
              tree {}
              stack (vector)]
         (if current
           (if (is-command? current)
             (let [[_ cmd arg] (split current #" ") ]
               (if (= cmd "cd")
                 (if (= arg "..")
                   (recur rest 
                     tree
                     (pop (pop stack)))
                   (let [new-stack (conj stack :contents arg)]
                     (recur rest 
                       (assoc-in
                         tree
                         new-stack
                         {:type "dir" :contents {}})
                       new-stack)))
                 (recur rest tree stack)))
             (if (starts-with? current "dir")
               (recur rest tree stack)
               (let [[size name] (split current #" ")]
                 (recur rest 
                   (assoc-in
                     tree
                     (conj stack :contents name) 
                     {:size (parse-int size) :type "file"})
                   stack))))
           tree))))

(defn find-dir-sizes [x] 
  (->> x
    build-tree 
    :contents
    (tree-seq map? #(interleave (keys %) (vals %)))
    (filter map?)
    (filter #(contains? % :contents))
    (map calculate-total-size)))

(defn part-01 [input]
  (->> input
    find-dir-sizes
    (filter #(> 100000 %))
    (reduce +)))

(defn part-02 [input]
  (let [dir-sizes (find-dir-sizes input)
        free-space (- 70000000 (apply max dir-sizes))
        space-to-free-for-update (- 30000000 free-space)]
    (->> 
      dir-sizes
      (filter #(< space-to-free-for-update %))
      (apply min))))

(defn -main [& _]
  (println "Day 07:")
  (println "\t-> Part 1: " (part-01 data))
  (println "\t-> Part 2: " (part-02 data)))