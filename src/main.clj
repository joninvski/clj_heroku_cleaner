(ns cleaner
  (:require [cheshire.core :as json]
            [semantic-csv.core :as sc]
            [clj-http.client :as http]))

(def apps
  (->>
    (http/get "https://api.heroku.com/apps"
              {:accept "application/vnd.heroku+json; version=3"
               :oauth-token ""
               :as :json})
    :body))

(sc/spit-csv "all_apps.csv"
             apps)
