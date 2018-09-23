(ns bing-statistics.core
  (:gen-class)
  (:require [bing-statistics.api.http.server :refer [start-server]]
            [bing-statistics.config :refer [http-port config]]))

(defn run []
  (start-server [{:port (http-port (config))}]))

;;
; Application entry point.
;;
(defn -main [& _]
  (run))