(ns usecase.get-formatted-profile
  (:require [core.profile-fetcher :refer [make-get-profile]]))

(def user-not-found-error
  "This user probably doesn't exist, but could be any other error since I didn't read the github api  ¯\\_(ツ)_/¯")

(defn make-get-formatted-profile
  [http-client format-profile]
  (let [fetch-profile (make-get-profile http-client)]
    (fn [username]
      (try
        (-> username
            fetch-profile
            format-profile)
        (catch Exception e user-not-found-error)))))
