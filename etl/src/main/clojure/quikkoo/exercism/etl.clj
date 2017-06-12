(ns quikkoo.exercism.etl
  (:require [clojure.string :as string]))

(defn transform [data]
  (reduce
    (fn [acc [key values]]
      (reduce conj acc
        (map (fn [value]
          [(string/lower-case value) key])
        values)))
    {} data))
