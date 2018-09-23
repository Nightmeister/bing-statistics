(ns bing-statistics.api.http.server
  (:require [compojure.core :refer :all]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.params :as p]
            [bing-statistics.api.http.routes :as r]))

(def http-routes
  (-> r/all-routes
      p/wrap-params))

(defn start-server
  [{:keys [http-port] :or {http-port 8080}}]
  (run-jetty http-routes {:port http-port}))