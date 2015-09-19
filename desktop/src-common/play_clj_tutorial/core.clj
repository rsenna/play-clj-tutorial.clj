(ns play-clj-tutorial.core
  (:require [play-clj.core :refer :all]
            [play-clj.g2d :refer :all]))

(defscreen main-screen
  :on-show
  (fn [screen entities]
    (update! screen :renderer (stage))
    (assoc (texture "8-bit-mario-medium.png")
           :x 50 :y 50 :width 100 :height 100
           :angle 45 :origin-x 0 :origin-y 0))

  :on-render
  (fn [screen entities]
    (clear!)
    (render! screen entities))

  :on-key-down
  (fn [screen entities]
    (cond
      (= (:key screen) (key-code :dpad-up))
      (println "up")
      (= (:key screen) (key-code :dpad-down))
      (println "down")
      (= (:key screen) (key-code :dpad-right))
      (println "right")
      (= (:key screen) (key-code :dpad-left))
      (println "left")))

  :on-touch-down
  (fn [screen entities]
    (cond
      (> (game :y) (* (game :height) (/ 2 3)))
      (println "up")
      (< (game :y) (/ (game :height) 3))
      (println "down")
      (> (game :x) (* (game :width) (/ 2 3)))
      (println "right")
      (< (game :x) (/ (game :width) 3))
      (println "left"))))

(defgame play-clj-tutorial-game
  :on-create
  (fn [this]
    (set-screen! this main-screen)))
