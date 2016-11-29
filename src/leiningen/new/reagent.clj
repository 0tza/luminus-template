(ns leiningen.new.reagent
  (:require [leiningen.new.common :refer :all]))

(def reagent-assets
  [["src/cljs/{{sanitized}}/core.cljs" "reagent/src/cljs/core.cljs"]
   ["src/cljs/{{sanitized}}/ajax.cljs" "reagent/src/cljs/ajax.cljs"]])

(def reagent-dependencies
  [['reagent "0.6.0"]
   ['reagent-utils "0.2.0"]
   ['secretary "1.2.3"]
   ['cljs-ajax "0.5.8"]])

(defn reagent-features [[assets options :as state]]
  (if (some #{"+reagent"} (:features options))
    [(into (remove-conflicting-assets assets "core.cljs") reagent-assets)
     (append-options options :dependencies reagent-dependencies)]
    state))