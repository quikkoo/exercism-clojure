(ns quikkoo.exercism.word-count-test
  (:require
    [clojure.test :refer [deftest is]]
    [quikkoo.exercism.word-count :as word-count]))

(deftest should-count-one-word
  (is (= {"word" 1} (word-count/calculate "word"))))

(deftest should-count-one-of-each
  (is (= {
      "one" 1
      "of" 1
      "each" 1
    } (word-count/calculate "one of each"))))

(deftest should-count-multiple-occurrences
  (is (= {
      "one" 1
      "fish" 4
      "two" 1
      "red" 1
      "blue" 1
    } (word-count/calculate "one fish two fish red fish blue fish"))))

(deftest should-count-everything-just-once
  (is (= {
      "all" 2
      "the" 2
      "kings" 2
      "horses" 1
      "and" 1
      "men" 1
    } (word-count/calculate "all the kings horses and all the kings men"))))

(deftest should-ignore-punctuation
  (is (= {
      "car" 1
      "carpet" 1
      "as" 1
      "java" 1
      "javascript" 1
    } (word-count/calculate "car : carpet as java : javascript!!&@$%^&"))))

(deftest should-handle-cramped-lists
  (is (= {
      "one" 1
      "two" 1
      "three" 1}
    (word-count/calculate "one,two,three"))))

(deftest should-include-numbers
  (is (= {
      "testing" 2
      "1" 1
      "2" 1
    } (word-count/calculate "testing, 1, 2 testing"))))

(deftest should-normalize-case
  (is (= {"go" 3} (word-count/calculate "go Go GO"))))

(deftest should-allow-apostrophes
  (is (= {
      "first" 1
      "don't" 2
      "laugh" 1
      "then" 1
      "cry" 1
    } (word-count/calculate "First: don't laugh. Then: don't cry."))))

(deftest should-treat-symbols-as-separators
  (is (= {
      "hey" 1
      "my" 1
      "spacebar" 1
      "is" 1
      "broken" 1
    } (word-count/calculate "hey,my_spacebar_is_broken."))))

(deftest should-counts-words-with-quotations
  (is (= {
      "joe" 1
      "can't" 1
      "tell" 1
      "between" 1
      "large" 2
      "and" 1
    } (word-count/calculate "Joe can't tell between 'large' and large."))))
