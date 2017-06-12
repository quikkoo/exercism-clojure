(ns quikkoo.exercism.word-count
  (:require [clojure.string :as string]))

(def ^:const pattern #"[']?[^'a-zA-Z0-9]+[']?")

(defn calculate [phrase]
  (reduce (fn [acc word]
    (assoc acc word (+ (acc word 0) 1)))
  {} (string/split (string/lower-case phrase) pattern)))
