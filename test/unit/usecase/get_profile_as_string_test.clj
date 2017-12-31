(ns usecase.get-profile-as-string-test
  (:require [midje.sweet :refer :all]
            [mocks.http-client :as mock-http]
            [core.string-formatter :as string-formatter]
            [usecase.get-formatted-profile :refer [make-get-formatted-profile]]))

(def get-profile-as-string 
  (make-get-formatted-profile
    mock-http/get
    string-formatter/format-repositories))

(fact "it returns a formatted profile"
  (get-profile-as-string "patrickds") => 
    (str "Name: android.experimental\tStars: 0\n"
         "Name: chat                \tStars: 1\n"))
