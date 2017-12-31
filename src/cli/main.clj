(ns cli.main
  (:require [clj-http.client :as http]
            [core.profile-fetcher :refer :all]))

(def get-profile (make-get-profile http/get))

(defn -main [& args]
  (println "Type :exit to exit")
  (loop []
    (println "\nEnter a github username")
    (let [username (read)]
      (when (not= username :exit)
        (-> username
            get-profile
            println)
        (recur)))))
