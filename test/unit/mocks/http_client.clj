(ns mocks.http-client
  (:refer-clojure :exclude [get]))

(def user-mock {:headers {}
                :body (slurp "resources/mocks/user.json")})

(def repos-mock {:headers {}
                 :body (slurp "resources/mocks/repos.json")})

(defn get [url]
  (case url
    "https://api.github.com/users/patrickds" user-mock
    "https://api.github.com/users/patrickds/repos" repos-mock
    "https://api.github.com/users/throws exception" (throw (Exception. "Error"))))
