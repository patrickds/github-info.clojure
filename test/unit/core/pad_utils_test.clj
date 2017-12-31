(ns core.pad-utils-test
  (:require [midje.sweet :refer :all]
            [core.pad-utils :as pad-utils]))

(fact "It returns the largest string"
      (pad-utils/largest-string-size '("I have 20 characters" "medium" "small")) => 20
      (pad-utils/largest-string-size '("small" "medium" "I have 20 characters")) => 20
      (pad-utils/largest-string-size '()) => 0)
