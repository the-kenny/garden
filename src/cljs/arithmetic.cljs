(ns garden.arithmetic
  "Generic arithmetic operators for computing sums, differences,
  products, and quotients between values including, but not limited
  to, numbers."
  (:refer-clojure :exclude [+ - * /])
  (:require
   [clojure.core :as clj]
   [garden.units :as u]
   [garden.color :as c]))

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

(defmethod add [u/Unit]
  [a]
  (u/+ a))

(defmethod add [u/Unit u/Unit]
  [a b]
  (u/+ a b))

(defmethod add [u/Unit u/Unit]
  [a b]
  (u/+ a b))

(defmethod add [u/Unit js/Number]
  [a b]
  (u/+ a b))

(defmethod add [js/Number u/Unit]
  [a b]
  (u/+ a b))


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

(defmethod subtract [u/Unit]
  [a]
  (u/- a))

(defmethod subtract [u/Unit u/Unit]
  [a b]
  (u/- a b))

(defmethod subtract [u/Unit js/Number]
  [a b]
  (u/- a b))

(defmethod subtract [js/Number u/Unit]
  [a b]
  (u/- a b))


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

(defmethod multiply [u/Unit]
  [a]
  (u/* a))

(defmethod multiply [u/Unit u/Unit]
  [a b]
  (u/* a b))

(defmethod multiply [u/Unit u/Unit]
  [a b]
  (u/* a b))

(defmethod multiply [u/Unit js/Number]
  [a b]
  (u/* a b))

(defmethod multiply [js/Number u/Unit]
  [a b]
  (u/* a b))


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

(defmethod divide [u/Unit]
  [a]
  (u// a))

(defmethod divide [u/Unit u/Unit]
  [a b]
  (u// a b))

(defmethod divide [u/Unit u/Unit]
  [a b]
  (u// a b))

(defmethod divide [u/Unit js/Number]
  [a b]
  (u// a b))

(defmethod divide [js/Number u/Unit]
  [a b]
  (u// a b))


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
