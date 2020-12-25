(ns eat.core
  (:require [clojure.string :as cs]
            [eat.thesaurus :as t]))

(def search-term
  (.getElementById js/document "eat-input"))

(def button-to-use
  (.getElementById js/document "search-eat"))

(def eat-results-field
  (.getElementById js/document "eat-results"))

(def d (js->clj (.parse js/JSON t/words)))

(defn format-eat-output [eat-input]
  (let [results (get d (clojure.string/upper-case eat-input))
        im-results (->> results
                        (map vals)
                        (interleave (map keys results))
                        flatten
                        (partition 2))]
    (apply str
           (conj
             (vec
               (for [[w n] im-results]
                 (str "<B>" w "</B> " n "<BR>")))
             "<P></P> " (count results) " total terms"
            ))))

(defn find-eat-data! []
  (set! (.-innerHTML eat-results-field)
        (-> search-term
            .-value
            format-eat-output)))

(set! (.-onclick button-to-use) find-eat-data!)
