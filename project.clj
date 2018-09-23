(defproject bing-statistics "0.1.0-SNAPSHOT"
  :name "Bing statistics service"
  :description "Web service for Bing searching statistics"
  :dependencies [[aero "1.1.3"]
                 [clj-http "3.9.1"]
                 [compojure "1.6.1"]
                 [tolitius/xml-in "0.1.0"]
                 [com.cemerick/url "0.1.1"]
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/data.xml "0.0.8"]
                 [org.clojure/data.json "0.2.6"]
                 [com.climate/claypoole "1.1.4"]
                 [ring/ring-jetty-adapter "1.7.0"]]
  :resource-paths ["resources"]
  :main bing-statistics.core
  :aot [bing-statistics.core])