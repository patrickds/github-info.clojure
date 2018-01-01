(ns server.main
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer [GET defroutes]]
            [clj-http.client :as http]
            [core.string-formatter :as string-formatter]
            [usecase.get-formatted-profile :refer :all]))

(def get-profile-as-string
  (make-get-formatted-profile
   http/get
   string-formatter/format-repositories))

(defroutes server
    (GET "/" [] "Hi pretty ( ͡° ͜ʖ ͡°)")
    (GET "/:username" [username]
      (get-profile-as-string username)))

(defn -main [& args]
  (run-jetty server {:port 3000}))
