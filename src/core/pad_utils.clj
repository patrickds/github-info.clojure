(ns core.pad-utils)

(defn largest-string-size [strings]
  (if (empty? strings)
    0
    (apply max (map count strings))))
