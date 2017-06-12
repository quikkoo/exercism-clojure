(ns quikkoo.exercism.hello-world)

(defn greet
  ([]
    "Hello, World!")
  ([name]
    (cond
      (= name nil) (throw (IllegalArgumentException.))
      (= name "") "Hello, World!"
      :else (format "Hello, %s!" name))))
