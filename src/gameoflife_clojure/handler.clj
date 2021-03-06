(ns gameoflife-clojure.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [cheshire.core :refer :all]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/info/" [] {:status 200
                   :headers {"Access-Control-Allow-Origin" "*"}
                   :body (generate-string {:Author "Dave Cahill"
                                           :Language "Clojure"
                                           :SourceCodeURL "https://github.com/davecahill/gameoflife-clojure"
                                           :LiveColor "#71A1F5"
                                           :DeadColor "#9EF0A0"})})
  (OPTIONS "/step/" [] {:status 200
                        :headers {"Access-Control-Allow-Origin" "*"
                         "Access-Control-Allow-Headers" "Origin, X-Requested-With, Content-Type, Accept"}})
  (POST "/step/" request {:status 200
                          :headers {"Access-Control-Allow-Origin" "*"}
                          :body (slurp (:body request))})
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
