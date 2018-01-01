(defproject clojureapp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.7.0"]
                 [cheshire "5.8.0"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]
                   :plugins [[lein-midje "3.2.1"]
                             [lein-cljfmt "0.5.7"]
                             [jonase/eastwood "0.2.5"]
                             [lein-cloverage "1.0.10"]]}}
  :test-paths ["test/unit"]
  :aliases {"run:cli" ["run" "-m" "cli.main/-main"]
            "test" ["midje"]
            "test:watch" ["midje" ":autotest"]
            "format" ["cljfmt" "fix"]
            "lint" ["eastwood"]
            "coverage" ["cloverage" "--runner" ":midje"]})
