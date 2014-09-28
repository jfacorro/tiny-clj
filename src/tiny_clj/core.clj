(ns tiny-clj.core
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]
            [net.cgrand.enlive-html :as html]))

(= 1)

(html/deftemplate base "templates/main.html"
  [title h1]
  [:head :title] (html/content title)
  [:body :h1] (html/content h1))

(defn home []
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (#'base "This is a test" "Wazzzup")})

(defn login
  []
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (#'base "Login" "Sux to be you")})

(defroutes app
  (GET "/" []
    (home))
  (GET "/login" []
    (login))
  (ANY "*" []
    (route/not-found (slurp (io/resource "404.html")))))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))
