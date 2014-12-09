(ns garden.arithmetic
  "Generic arithmetic operators for computing sums, differences,
  products, and quotients between values including, but not limited
  to, numbers."
  (:refer-clojure :exclude [+ - * /])
  (:require
   [clojure.core :as clj]
   [garden.units :as u :refer [Unit]]
   [garden.color :as c :refer [RGB RGBA HSL HSLA]]))

(defn ^:private dispatch
  ([a]
     [(type a)])
  ([a b]
     [(type a) (type b)]))

;; ---------------------------------------------------------------------
;; Addition

(defmulti
  ^{:arglists '([a] [a b])
    :doc "Compute the sum of one or two values according to their type."}
  add
  dispatch)

;;; js/Number

(defmethod add [js/Number]
  [a]
  (clj/+ a))

(defmethod add [js/Number js/Number]
  [a b]
  (clj/+ a b))


;;; garden.units.Unit

(defmethod add [Unit]
  [a]
  (u/+ a))

(defmethod add [Unit Unit]
  [a b]
  (u/+ a b))

(defmethod add [Unit Unit]
  [a b]
  (u/+ a b))

(defmethod add [Unit js/Number]
  [a b]
  (u/+ a b))

(defmethod add [js/Number Unit]
  [a b]
  (u/+ a b))


;;; garden.color.RGB

(defmethod add [RGB]
  [a]
  (c/+ a))

(defmethod add [RGB RGB]
  [a b]
  (c/+ a b))

(defmethod add [RGB RGB]
  [a b]
  (c/+ a b))

(defmethod add [RGB Number]
  [a b]
  (c/+ a b))

(defmethod add [Number RGB]
  [a b]
  (c/+ a b))


;;; garden.color.RGBA

(defmethod add [RGBA]
  [a]
  (c/+ a))

(defmethod add [RGBA RGBA]
  [a b]
  (c/+ a b))

(defmethod add [RGBA RGBA]
  [a b]
  (c/+ a b))

(defmethod add [RGBA Number]
  [a b]
  (c/+ a b))

(defmethod add [Number RGBA]
  [a b]
  (c/+ a b))


;;; garden.color.HSL

(defmethod add [HSL]
  [a]
  (c/+ a))

(defmethod add [HSL HSL]
  [a b]
  (c/+ a b))

(defmethod add [HSL HSL]
  [a b]
  (c/+ a b))

(defmethod add [HSL Number]
  [a b]
  (c/+ a b))

(defmethod add [Number HSL]
  [a b]
  (c/+ a b))


;;; garden.color.HSLA

(defmethod add [HSLA]
  [a]
  (c/+ a))

(defmethod add [HSLA HSLA]
  [a b]
  (c/+ a b))

(defmethod add [HSLA HSLA]
  [a b]
  (c/+ a b))

(defmethod add [HSLA Number]
  [a b]
  (c/+ a b))

(defmethod add [Number HSLA]
  [a b]
  (c/+ a b))


;; ---------------------------------------------------------------------
;; Subtraction

(defmulti
  ^{:arglists '([a] [a b])
    :doc "Compute the difference of one or two values according to their type."}
  subtract
  dispatch)

;;; js/Number

(defmethod subtract [js/Number]
  [a]
  (clj/- a))

(defmethod subtract [js/Number js/Number]
  [a b]
  (clj/- a b))


;;; garden.units.Unit

(defmethod subtract [Unit]
  [a]
  (u/- a))

(defmethod subtract [Unit Unit]
  [a b]
  (u/- a b))

(defmethod subtract [Unit js/Number]
  [a b]
  (u/- a b))

(defmethod subtract [js/Number Unit]
  [a b]
  (u/- a b))


;;; garden.color.RGB

(defmethod subtract [RGB]
  [a]
  (c/- a))

(defmethod subtract [RGB RGB]
  [a b]
  (c/- a b))

(defmethod subtract [RGB RGB]
  [a b]
  (c/- a b))

(defmethod subtract [RGB Number]
  [a b]
  (c/- a b))

(defmethod subtract [Number RGB]
  [a b]
  (c/- a b))


;;; garden.color.RGBA

(defmethod subtract [RGBA]
  [a]
  (c/- a))

(defmethod subtract [RGBA RGBA]
  [a b]
  (c/- a b))

(defmethod subtract [RGBA RGBA]
  [a b]
  (c/- a b))

(defmethod subtract [RGBA Number]
  [a b]
  (c/- a b))

(defmethod subtract [Number RGBA]
  [a b]
  (c/- a b))


;;; garden.color.HSL

(defmethod subtract [HSL]
  [a]
  (c/- a))

(defmethod subtract [HSL HSL]
  [a b]
  (c/- a b))

(defmethod subtract [HSL HSL]
  [a b]
  (c/- a b))

(defmethod subtract [HSL Number]
  [a b]
  (c/- a b))

(defmethod subtract [Number HSL]
  [a b]
  (c/- a b))


;;; garden.color.HSLA

(defmethod subtract [HSLA]
  [a]
  (c/- a))

(defmethod subtract [HSLA HSLA]
  [a b]
  (c/- a b))

(defmethod subtract [HSLA HSLA]
  [a b]
  (c/- a b))

(defmethod subtract [HSLA Number]
  [a b]
  (c/- a b))

(defmethod subtract [Number HSLA]
  [a b]
  (c/- a b))


;; ---------------------------------------------------------------------
;; Multiplication

(defmulti
  ^{:arglists '([a] [a b])
    :doc "Compute the product of one or two values according to their type."}
  multiply
  dispatch)

;;; js/Number

(defmethod multiply [js/Number]
  [a]
  (clj/* a))

(defmethod multiply [js/Number js/Number]
  [a b]
  (clj/* a b))


;;; garden.units.Unit

(defmethod multiply [Unit]
  [a]
  (u/* a))

(defmethod multiply [Unit Unit]
  [a b]
  (u/* a b))

(defmethod multiply [Unit Unit]
  [a b]
  (u/* a b))

(defmethod multiply [Unit js/Number]
  [a b]
  (u/* a b))

(defmethod multiply [js/Number Unit]
  [a b]
  (u/* a b))


;;; garden.color.RGB

(defmethod multiply [RGB]
  [a]
  (c/* a))

(defmethod multiply [RGB RGB]
  [a b]
  (c/* a b))

(defmethod multiply [RGB RGB]
  [a b]
  (c/* a b))

(defmethod multiply [RGB Number]
  [a b]
  (c/* a b))

(defmethod multiply [Number RGB]
  [a b]
  (c/* a b))


;;; garden.color.RGBA

(defmethod multiply [RGBA]
  [a]
  (c/* a))

(defmethod multiply [RGBA RGBA]
  [a b]
  (c/* a b))

(defmethod multiply [RGBA RGBA]
  [a b]
  (c/* a b))

(defmethod multiply [RGBA Number]
  [a b]
  (c/* a b))

(defmethod multiply [Number RGBA]
  [a b]
  (c/* a b))


;;; garden.color.HSL

(defmethod multiply [HSL]
  [a]
  (c/* a))

(defmethod multiply [HSL HSL]
  [a b]
  (c/* a b))

(defmethod multiply [HSL HSL]
  [a b]
  (c/* a b))

(defmethod multiply [HSL Number]
  [a b]
  (c/* a b))

(defmethod multiply [Number HSL]
  [a b]
  (c/* a b))


;;; garden.color.HSLA

(defmethod multiply [HSLA]
  [a]
  (c/* a))

(defmethod multiply [HSLA HSLA]
  [a b]
  (c/* a b))

(defmethod multiply [HSLA HSLA]
  [a b]
  (c/* a b))

(defmethod multiply [HSLA Number]
  [a b]
  (c/* a b))

(defmethod multiply [Number HSLA]
  [a b]
  (c/* a b))


;; ---------------------------------------------------------------------
;; Division

(defmulti
  ^{:arglists '([a] [a b])
    :doc "Compute the quotient of one or two values according to their type."}
  divide
  dispatch)

;;; js/Number

(defmethod divide [js/Number]
  [a]
  (clj// a))

(defmethod divide [js/Number js/Number]
  [a b]
  (clj// a b))


;;; garden.units.Unit

(defmethod divide [Unit]
  [a]
  (u// a))

(defmethod divide [Unit Unit]
  [a b]
  (u// a b))

(defmethod divide [Unit Unit]
  [a b]
  (u// a b))

(defmethod divide [Unit js/Number]
  [a b]
  (u// a b))

(defmethod divide [js/Number Unit]
  [a b]
  (u// a b))


;;; garden.color.RGB

(defmethod divide [RGB]
  [a]
  (c// a))

(defmethod divide [RGB RGB]
  [a b]
  (c// a b))

(defmethod divide [RGB RGB]
  [a b]
  (c// a b))

(defmethod divide [RGB Number]
  [a b]
  (c// a b))

(defmethod divide [Number RGB]
  [a b]
  (c// a b))


;;; garden.color.RGBA

(defmethod divide [RGBA]
  [a]
  (c// a))

(defmethod divide [RGBA RGBA]
  [a b]
  (c// a b))

(defmethod divide [RGBA RGBA]
  [a b]
  (c// a b))

(defmethod divide [RGBA Number]
  [a b]
  (c// a b))

(defmethod divide [Number RGBA]
  [a b]
  (c// a b))


;;; garden.color.HSL

(defmethod divide [HSL]
  [a]
  (c// a))

(defmethod divide [HSL HSL]
  [a b]
  (c// a b))

(defmethod divide [HSL HSL]
  [a b]
  (c// a b))

(defmethod divide [HSL Number]
  [a b]
  (c// a b))

(defmethod divide [Number HSL]
  [a b]
  (c// a b))


;;; garden.color.HSLA

(defmethod divide [HSLA]
  [a]
  (c// a))

(defmethod divide [HSLA HSLA]
  [a b]
  (c// a b))

(defmethod divide [HSLA HSLA]
  [a b]
  (c// a b))

(defmethod divide [HSLA Number]
  [a b]
  (c// a b))

(defmethod divide [Number HSLA]
  [a b]
  (c// a b))



;; ---------------------------------------------------------------------
;; Operators

(defn +
  "Generic addition. Extensible via add."
  ([] 0)
  ([x]
     (add x))
  ([x y]
     (add x y))
  ([x y & more]
     (reduce add (add x y) more)))

(defn -
  "Generic subtraction. Extensible via subtract."
  ([x]
     (subtract x))
  ([x y]
     (subtract x y))
  ([x y & more]
     (reduce subtract (subtract x y) more))) 

(defn *
  "Generic multiplication. Extensible via multiply."
  ([] 1)
  ([x]
     (multiply x))
  ([x y]
     (multiply x y))
  ([x y & more]
     (reduce multiply (multiply x y) more)))

(defn /
  "Generic division. Extensible via divide."
  ([x]
     (divide x))
  ([x y]
     (divide x y))
  ([x y & more]
     (reduce divide (divide x y) more)))
