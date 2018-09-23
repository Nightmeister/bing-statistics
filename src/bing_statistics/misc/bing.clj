(ns bing-statistics.misc.bing
  (:require [xml-in.core :as xml-in]
            [clojure.data.xml :as xml]
            [cemerick.url :refer (url)]
            [com.climate.claypoole :as cp]
            [clj-http.client :as http-client]))

(def search-url "https://www.bing.com/search?q=%s&format=rss&count=10")

(def connection-pool
  "Connection pool with concurrency control"
  (cp/threadpool 16))

(defn- build-request-url [search-key]
  "Build Bing request URL for given key"
  (format search-url search-key))

(defn- collect-result-links [rss]
  "Collect links from RSS."
  (xml-in/find-all rss [:rss :channel :item :link]))

(defn- get-request [url]
  "Do get request and return body"
  (:body (http-client/get url {:as :xml})))

(defn- do-bing-requests [search-keys]
  "Do requests to Bing service and return responses"
  (cp/pmap connection-pool get-request
           (map build-request-url search-keys)))

(defn search-links-by-keys [search-keys]
  "Search links for keys from Bing service."
  (flatten
    (map (comp collect-result-links xml/parse-str) (do-bing-requests search-keys))))