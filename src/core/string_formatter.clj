(ns core.string-formatter
  (:require [core.pad-utils :as pad-utils]))

(defn -format-repository [largest-name-size repo]
  (let [name (:name repo)
        stars (:stargazers_count repo)
        name-size (count name)
        pad-size (- largest-name-size name-size)
        pad (apply str (repeat pad-size " "))]
    (format "Name: %s%s\tStars: %s\n" name pad stars)))

(defn format-repositories [repositories]
  (let [repo-names (map :name repositories)
        largest-name-size (pad-utils/largest-string-size repo-names)
        format-repository (partial -format-repository largest-name-size)]
    (apply str (map format-repository repositories))))
