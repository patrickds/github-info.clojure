(ns cli.main
  (:require [clj-http.client :as http]
            [core.string-formatter :as string-formatter]
            [usecase.get-formatted-profile :refer :all]))

(def get-profile-as-string
  (make-get-formatted-profile
   http/get
   string-formatter/format-repositories))

(defn -main [& args]
  (println "Type :exit to exit")
  (loop []
    (println "Enter a github username")
    (let [username (read)]
      (println)
      (when (not= username :exit)
        (-> username
            get-profile-as-string
            println)
        (recur)))))
