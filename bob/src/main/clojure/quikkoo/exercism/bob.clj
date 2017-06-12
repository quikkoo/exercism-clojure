(ns quikkoo.exercism.bob)

(def ^:const fine #"^[\s\v\u00A0\u2002]*$")

(def ^:const whoa #"^[^\p{Ll}]*[A-Z][^\p{Ll}]*$")

(def ^:const sure #"^.*\?$[\s\v]*")

(defn hey [question]
  (cond
    (re-matches fine question) "Fine. Be that way!"
    (re-matches whoa question) "Whoa, chill out!"
    (re-matches sure question) "Sure."
    :else "Whatever."))
