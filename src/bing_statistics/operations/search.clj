(ns bing-statistics.operations.search
  (:require [bing-statistics.misc.bing :as bing]
            [cemerick.url :refer (url)]
            [clojure.string :as str]))

(defn- remove-sub-domains [host]
  "Remove subdomains and return only 1,2 level"
  (str/join "." (take-last 2 (str/split host #"\."))))

(defn- extract-unique-hosts [links]
  "Extract uniqueness hosts from links"
  (map (comp remove-sub-domains :host url) (distinct links)))

(defn- count-unique-hosts [links]
  "Count unique host names for given links"
  (frequencies (extract-unique-hosts links)))

(defn search [search-keys]
  "Return query statistic for keys from Bing service"
  (count-unique-hosts
    (bing/search-links-by-keys search-keys)))