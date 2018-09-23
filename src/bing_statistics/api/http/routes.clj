(ns bing-statistics.api.http.routes
  (:require [compojure.core :refer :all]
            [clojure.data.json :as json]
            [bing-statistics.operations.search :refer [search]]))

(defn- search-handler [search-keys]
  "Handler for GET /search request."
  (json/write-str
    (search (set search-keys))))

(defroutes all-routes
           "Service HTTP API routes definitions"
           (GET "/search" [query] (search-handler (if (sequential? query) query (list query)))))