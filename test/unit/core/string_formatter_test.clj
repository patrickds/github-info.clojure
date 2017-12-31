(ns core.string-formatter-test
  (:require [midje.sweet :refer :all]
            [core.string-formatter :as formatter]))

(facts
 (fact "It formats a repository to a pretty string"
       (formatter/format-repositories '({:name "android.experimental" :stargazers_count 0})) =>
       "Name: android.experimental\tStars: 0\n")
 (fact "It formats padding the fields to match the biggest field"
       (formatter/format-repositories
        '({:name "android.experimental" :stargazers_count 0}
          {:name "chat" :stargazers_count 1})) =>
       (str "Name: android.experimental\tStars: 0\n"
            "Name: chat                \tStars: 1\n")))
