(ns tic-tac-toe.core)

(defn winner? [player game]
  (let [size (count game)
        idxs (range size)]
    (->> [[x idx] [idx y] [idx idx] [idx (- (dec size) idx)]]
         (map (fn [[x y]] ((game x) y)))
         (for [x idxs y idxs idx idxs])
         (apply mapcat list)
         (partition size)
         (some #(apply = player %)))))

; (winner? :x [[nil :x nil] [nil :x nil] [nil :x nil]])
