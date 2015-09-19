(ns play-clj-tutorial.core.desktop-launcher
  (:require [play-clj-tutorial.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main
  []
  (LwjglApplication. play-clj-tutorial-game "play-clj-tutorial" 800 600)
  (Keyboard/enableRepeatEvents true))
