(ns tic-tac-toe.db)

(def default-db
  {:name "re-frame"
  :game-board    [[:empty :empty :empty]
                  [:empty :empty :empty]
                  [:empty :empty :empty]]
  :current-player :x})
