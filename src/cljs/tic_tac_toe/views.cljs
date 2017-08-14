(ns tic-tac-toe.views
  (:require [re-frame.core :as re-frame]))

(defn cell-draw [row-idx col-idx cell]
  [:div.game-cell {:style {:display "inline-block" :width "40px" :text-align "center"
                           :border "1px solid red" :font-size "20px" :padding "40px"}
                         :on-click #(re-frame/dispatch [:cell-click row-idx col-idx])}
                           (name cell) ])

(defn row-panel [idx row]
  (into [:div ] (map-indexed (partial cell-draw idx) row)))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        game-board (re-frame/subscribe [:game-board])]
    (fn []
      [:div
        [:h1 {:style {:display "inline"}} "Tic Tac Toe"]
        [:button {:style {:margin-left "180px"} :on-click #(re-frame/dispatch [:reset])} "reset" ]
        [:div (map-indexed row-panel @game-board)]])))
