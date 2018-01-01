(ns usecase.get-profile-as-string-test
  (:require [midje.sweet :refer :all]
            [mocks.http-client :as mock-http]
            [cheshire.core :as json]
            [core.string-formatter :as string-formatter]
            [usecase.get-formatted-profile :refer [make-get-formatted-profile]]))

(def get-profile-as-string
  (make-get-formatted-profile
   mock-http/get
   string-formatter/format-repositories))

(def get-profile-as-json
  (make-get-formatted-profile
   mock-http/get
   json/generate-string))

(fact "it returns a formatted profile"
      (get-profile-as-string "patrickds") =>
      (str "Name: android.experimental\tStars: 0\n"
           "Name: chat                \tStars: 1\n"))

(fact "it returns a json formatted profile"
      (get-profile-as-json "patrickds") =>
      (str "[{\"name\":\"android.experimental\",\"stargazers_count\":0},"
           "{\"name\":\"chat\",\"stargazers_count\":1}]"))
