(defproject tiny-clj "0.1.0-SNAPSHOT"
  :description "URL shortener in Clojure"
  :url "http://tiny.clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [enlive "1.1.5"]
                 [hiccup "1.0.5"]
                 [ring/ring-jetty-adapter "1.2.2"]
                 [environ "0.5.0"]]
  :hooks [environ.leiningen.hooks]
  :plugins [[environ/environ.lein "0.2.1"]]
  :uberjar-name "tiny-clj-standalone.jar")
