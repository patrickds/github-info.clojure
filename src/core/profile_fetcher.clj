(ns core.profile-fetcher
  (:require [cheshire.core :as json]))

(defn- parse-json [string]
  (json/parse-string string true))

(defn- url-for [username] (str "https://api.github.com/users/" username))

(defn get-profile [http-get username]
  (let [fetch-body-as-json (comp parse-json :body http-get)]
    (->> (url-for username)
          fetch-body-as-json
          :repos_url
          fetch-body-as-json
          (map #(select-keys % [:name :stargazers_count])))))
