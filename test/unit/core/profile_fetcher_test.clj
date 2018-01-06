(ns core.profile-fetcher-test
  (:require [midje.sweet :refer :all]
            [mocks.http-client :as mock-http]
            [core.profile-fetcher :refer :all]))

(def fetch-profile (partial get-profile mock-http/get))

(fact "It returns user repos for a given username"
      (fetch-profile "patrickds") =>
      '({:name "android.experimental" :stargazers_count 0}
        {:name "chat" :stargazers_count 1}))

(fact "It throws an exception for a user not found"
      (fetch-profile "throws exception") => (throws Exception "Error"))
