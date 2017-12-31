(ns usecase.get-formatted-profile
  (:require [core.profile-fetcher :refer [make-get-profile]]))

(defn make-get-formatted-profile
  [http-client format-profile]
  (let [fetch-profile (make-get-profile http-client)]
    (fn [username]
      (-> username
          fetch-profile
          format-profile))))
