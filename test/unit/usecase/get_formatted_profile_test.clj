(ns usecase.get-formatted-profile-test
  (:require [midje.sweet :refer :all]
            [mocks.http-client :as mock-http]
            [cheshire.core :as json]
            [core.string-formatter :as string-formatter]
            [usecase.get-formatted-profile :refer [get-formatted-profile]]))

(def get-profile-as-string
  (partial get-formatted-profile
    mock-http/get
    string-formatter/format-repositories))

(def get-profile-as-json
  (partial get-formatted-profile
   mock-http/get
   json/generate-string))

(facts
 (fact "it returns a formatted profile"
       (get-profile-as-string "patrickds") =>
       (str "Name: android.experimental\tStars: 0\n"
            "Name: chat                \tStars: 1\n"))

 (fact "it returns a json formatted profile"
       (get-profile-as-json "patrickds") =>
       (str "[{\"name\":\"android.experimental\",\"stargazers_count\":0},"
            "{\"name\":\"chat\",\"stargazers_count\":1}]"))

 (fact "it shows a error message when exception is thrown"
       (get-profile-as-json "throws exception") =>
       "This user probably doesn't exist, but could be any other error since I didn't read the github api  ¯\\_(ツ)_/¯"))
