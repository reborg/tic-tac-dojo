(ns tic-tac-toe.events
  (:require [re-frame.core :as re-frame]
            [tic-tac-toe.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

 (re-frame/reg-event-db
  :reset
  (fn [_]
    db/default-db))


(defn get-lines [game-board]
  (let [rows game-board
        columns (apply map vector game-board)
        diags [(map #(get-in game-board %) [[0 0] [1 1] [2 2]])
               (map #(get-in game-board %) [[0 2] [1 1] [2 0]])]]
    (concat rows columns diags)))


(defn play-game
  ; todo
  ;  - detect end-game and restart
  ;  - detect winning move and restart
  ;  - NTH undo
  [db row-idx col-idx]
  (let [current-player (get-in db [:current-player])
        _ (println (get-lines (get-in db [:game-board])))]
    (if (= (get-in db [:game-board row-idx col-idx]) :empty);current cell is empty
      (-> db
          (assoc-in [:game-board row-idx col-idx] current-player)
          (assoc-in [:current-player]
                    (if (= current-player :x) :o :x)))
      db)))

(re-frame/reg-event-db
 :cell-click
(fn  [db [_ row-idx col-idx]]
  (println "You clicked on row " row-idx " col " col-idx)
  (play-game db row-idx col-idx)))
