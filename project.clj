(defproject clojureapp "0.1.0-SNAPSHOT"
  :description "A very nice program where you input your github username and it shows you less information than github already shows you."
  :url "https://github.com/patrickds/github-info.clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.7.0"]
                 [cheshire "5.8.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [compojure "1.6.0"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]
                                  [ring/ring-devel "1.6.3"]]
                   :plugins [[lein-ring "0.12.1"]
                             [lein-midje "3.2.1"]
                             [lein-cljfmt "0.5.7"]
                             [jonase/eastwood "0.2.5"]
                             [lein-cloverage "1.0.10"]]}}
  :ring {:handler server.main/server}
  :test-paths ["test/unit"]
  :aliases {"run:cli" ["run" "-m" "cli.main/-main"]
            "run:server" ["run" "-m" "server.main/-main"]
            "run:server:watch" ["ring" "server"]
            "test" ["midje"]
            "test:watch" ["midje" ":autotest"]
            "format" ["cljfmt" "fix"]
            "lint" ["eastwood"]
            "coverage" ["cloverage" "--runner" ":midje"]})
