(ns core.profile-fetcher-test
  (:require [midje.sweet :refer :all]
            [mocks.http-client :as mock-http]
            [core.profile-fetcher :refer :all]))

(fact "It returns user repos for a given username"
      (let [get-profile (make-get-profile mock-http/get)]
        (get-profile "patrickds") =>
        '({:name "android.experimental" :stargazers_count 0}
          {:name "chat" :stargazers_count 1})))
