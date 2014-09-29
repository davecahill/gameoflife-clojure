(ns gameoflife-clojure.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/info/" [] {:status 200
                   :headers {"Access-Control-Allow-Origin" "*"}
                   :body "INFOOO"})

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
