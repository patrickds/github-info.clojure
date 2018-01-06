(ns usecase.get-formatted-profile
  (:require [core.profile-fetcher :refer [get-profile]]))

(def user-not-found-error
  "This user probably doesn't exist, but could be any other error since I didn't read the github api  ¯\\_(ツ)_/¯")

(defn get-formatted-profile
  [http-client format-profile username]
  (let [fetch-profile (partial get-profile http-client)]
    (try
      (-> username
          fetch-profile
          format-profile)
      (catch Exception e user-not-found-error))))
