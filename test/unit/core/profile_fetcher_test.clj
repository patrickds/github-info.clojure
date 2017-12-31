(ns core.profile-fetcher-test
  (:require [midje.sweet :refer :all]
            [core.profile-fetcher :refer :all]))

(def user-mock {:headers {}
                :body (slurp "resources/mocks/user.json")})

(def repos-mock {:headers {}
                 :body (slurp "resources/mocks/repos.json")})

(defn fake-http-get [url]
  (case url
    "https://api.github.com/users/patrickds" user-mock
    "https://api.github.com/users/patrickds/repos" repos-mock))

(fact "It returns user repos for a given username"
      (let [get-profile (make-get-profile fake-http-get)]
        (get-profile "patrickds") =>
        '({:name "android.experimental" :stargazers_count 0}
          {:name "chat" :stargazers_count 1})))
