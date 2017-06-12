(ns quikkoo.exercism.bob-test
  (:require
    [clojure.test :refer [deftest is]]
    [quikkoo.exercism.bob :as bob]))

(deftest should-respond-to-a-statement
  (is (= "Whatever." (bob/hey "Tom-ay-to, tom-aaaah-to."))))

(deftest should-respond-to-shouting
  (is (= "Whoa, chill out!" (bob/hey "WATCH OUT!"))))

(deftest should-respond-to-questions
  (is (= "Sure." (bob/hey "Does this cryogenic chamber make me look fat?"))))

(deftest should-respond-to-questions-ending-with-numbers
  (is (= "Sure." (bob/hey "You are what, like 15?"))))

(deftest should-respond-to-forceful-talking
  (is (= "Whatever." (bob/hey "Let's go make out behind the gym!"))))

(deftest should-respond-to-acronyms-in-regular-speech
  (is (= "Whatever." (bob/hey "It's OK if you don't want to go to the DMV."))))

(deftest should-respond-to-forceful-questions-as-shouting
  (is (= "Whoa, chill out!" (bob/hey "WHAT THE HELL WERE YOU THINKING?"))))

(deftest should-respond-to-shouting-with-special-characters
  (is (= "Whoa, chill out!" (bob/hey "ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))))

(deftest should-respond-to-numbers-when-shouting
  (is (= "Whoa, chill out!" (bob/hey "1, 2, 3 GO!"))))

(deftest should-respond-to-numbers-as-speech
  (is (= "Whatever." (bob/hey "1, 2, 3"))))

(deftest should-respond-to-questions-with-only-numbers
  (is (= "Sure." (bob/hey "4?"))))

(deftest should-respond-to-shouting-with-no-exclamation-mark
  (is (= "Whoa, chill out!" (bob/hey "I HATE YOU"))))

(deftest should-respond-to-statement-containing-question-mark
  (is (= "Whatever." (bob/hey "Ending with ? means a question."))))

(deftest should-respond-to-prattling-on
  (is (= "Sure." (bob/hey "Wait! Hang on. Are you going to be OK?"))))

(deftest should-respond-to-silence
  (is (= "Fine. Be that way!" (bob/hey ""))))

(deftest should-respond-to-prolonged-silence
  (is (= "Fine. Be that way!" (bob/hey "          "))))

(deftest should-respond-to-others-blank-characters
  (is (= "Fine. Be that way!" (bob/hey "\n\r \t\u000B\u00A0\u2002"))))

(deftest should-respond-to-multiple-line-questions
  (is (= "Whatever." (bob/hey "\nDoes this cryogenic chamber make me look fat?\nno"))))

(deftest should-respond-to-non-letters-with-question-test
  (is (= "Sure." (bob/hey ":) ?"))))
