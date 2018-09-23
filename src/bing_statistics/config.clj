(ns bing-statistics.config
  (:require [aero.core :as aero]))

(defn config []
  "Read general application config"
  (aero/read-config (clojure.java.io/resource "config/config.edn")))

(defn http-port [config]
  "Get http-port server property"
  (get-in config [:port]))