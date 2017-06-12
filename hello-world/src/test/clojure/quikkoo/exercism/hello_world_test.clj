(ns quikkoo.exercism.hello-world-test
  (:require
    [clojure.test :refer [deftest is]]
    [quikkoo.exercism.hello-world :as hello-world]))

(deftest without-name
  (is (= "Hello, World!" (hello-world/greet))))

(deftest with-empty-name
  (is (= "Hello, World!" (hello-world/greet ""))))

(deftest with-name-clojure
  (is (= "Hello, Clojure!" (hello-world/greet "Clojure"))))

(deftest with-name-exercism
  (is (= "Hello, Exercism!" (hello-world/greet "Exercism"))))

(deftest with-null-name
  (is (thrown? IllegalArgumentException (hello-world/greet nil))))
