(ns server.main
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer [GET defroutes]]
            [clj-http.client :as http]
            [cheshire.core :as json]
            [usecase.get-formatted-profile :refer :all]))

(def get-profile-as-json
  (make-get-formatted-profile
   http/get
   json/generate-string))

(defroutes handler
  (GET "/" [] "Hi pretty ( ͡° ͜ʖ ͡°)")
  (GET "/:username" [username] (get-profile-as-json username)))

(defn json-content-type-middleware [handler]
  (fn [request]
    (let [response (handler request)]
      (assoc-in response [:headers "Content-Type"] "application/json"))))

(def server
  (-> handler
      json-content-type-middleware))

(defn -main [& args]
  (run-jetty server {:port 3000}))
