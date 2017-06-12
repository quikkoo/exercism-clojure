(ns quikkoo.exercism.anagram
  (:require [clojure.string :as string]))

(defn is-same? [lhs, rhs]
  (= lhs rhs))

(defn has-same-size? [lhs, rhs]
  (= (count lhs) (count rhs)))

(defn has-same-elements? [lhs, rhs]
  (= lhs rhs))

(defn matches [subject, candidates]
  (let [
    lsub (string/lower-case subject)
    ssub (sort lsub)]
    (filter (fn [candidate]
      (let [
        lcan (string/lower-case candidate)
        scan (sort lcan)]
        (and (has-same-size? lsub lcan) (not (is-same? lsub lcan)) (has-same-elements? ssub scan))))
      candidates)))
