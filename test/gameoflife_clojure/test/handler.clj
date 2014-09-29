(ns gameoflife-clojure.test.handler
  (:require [clojure.test :refer :all]
            [gameoflife-clojure.handler :refer :all]
            [ring.mock.request :as mock]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "info route"
    (let [response (app (mock/request :get "/info/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "INFOOO"))))
  
  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
