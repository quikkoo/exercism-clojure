(ns quikkoo.exercism.anagram-test
  (:require
    [clojure.test :refer [deftest is]]
    [quikkoo.exercism.anagram :as anagram]))

(deftest should-detect-no-matches
  (is (=
    []
    (anagram/matches "diaper" ["hello" "world" "zombies" "pants"]))))

(deftest should-detect-simple-anagram
  (is (=
    ["tan"]
    (anagram/matches "ant" ["tan" "stand" "at"]))))

(deftest should-detect-multiple-anagrams
  (is (=
    ["stream" "maters"]
    (anagram/matches "master" ["stream" "pigeon" "maters"]))))

(deftest should-not-confuse-different-duplicates
  (is (=
    []
    (anagram/matches "galea" ["eagle"]))))

(deftest should-not-include-identical-words
  (is (=
    ["cron"]
    (anagram/matches "corn" ["corn" "dark" "Corn" "rank" "CORN" "cron" "park"]))))

(deftest should-eliminate-anagram-subsets
  (is (=
    []
    (anagram/matches "good" ["dog" "goody"]))))

(deftest should-eliminate-anagrams-with-same-checksum
  (is (=
    []
    (anagram/matches "mass" ["last"]))))

(deftest should-detect-anagram
  (is (=
    ["inlets"]
    (anagram/matches "listen" ["enlists" "google" "inlets" "banana"]))))

(deftest should-detect-more-multiple-anagrams
  (is (=
    ["gallery" "regally" "largely"]
    (anagram/matches "allergy" ["gallery" "ballerina" "regally" "clergy" "largely" "leading"]))))

(deftest should-treat-subject-anagrams-as-case-insensitive
  (is (=
    ["carthorse"]
    (anagram/matches "Orchestra" ["cashregister" "carthorse" "radishes"]))))

(deftest should-treat-candidate-anagrams-as-case-insensitive
  (is (=
    ["Carthorse"]
    (anagram/matches "orchestra" ["Cashregister" "Carthorse" "Radishes"]))))
