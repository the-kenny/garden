(ns garden.arithmetic
  "Generic arithmetic operators for computing sums, differences,
  products, and quotients between values including, but not limited
  to, numbers."
  (:refer-clojure :exclude [+ - * /])
  (:require
   [clojure.core :as clj]
   [garden.units :as u]
   [garden.color :as c])
  (:import
   (garden.color RGB RGBA HSL HSLA)
   (garden.units Unit)))

(defn ^:private dispatch
  ([a]
     (if (number? a)
       [Number]
       [(class a)]))
  ([a b]
     (case [(number? a) (number? b)]
       [true true] [Number Number]
       [true false] [Number (class b)]
       [false true] [(class a) Number]
       [(class a) (class b)])))

;; ---------------------------------------------------------------------
;; Addition

(defmulti
  ^{:arglists '([a] [a b])
    :doc "Compute the sum of one or two values according to their type."}
  add
  dispatch)

;;; java.lang.Number

(defmethod add [Number]
  [a]
  (clj/+ a))

(defmethod add [Number Number]
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

(defmethod add [Unit Number]
  [a b]
  (u/+ a b))

(defmethod add [Number Unit]
  [a b]
  (u/+ a b))


;; ---------------------------------------------------------------------
;; Subtraction

(defmulti
  ^{:arglists '([a] [a b])
    :doc "Compute the difference of one or two values according to their type."}
  subtract
  dispatch)

;;; java.lang.Number

(defmethod subtract [Number]
  [a]
  (clj/- a))

(defmethod subtract [Number Number]
  [a b]
  (clj/- a b))


;;; garden.units.Unit

(defmethod subtract [Unit]
  [a]
  (u/- a))

(defmethod subtract [Unit Unit]
  [a b]
  (u/- a b))

(defmethod subtract [Unit Number]
  [a b]
  (u/- a b))

(defmethod subtract [Number Unit]
  [a b]
  (u/- a b))


;; ---------------------------------------------------------------------
;; Multiplication

(defmulti
  ^{:arglists '([a] [a b])
    :doc "Compute the product of one or two values according to their type."}
  multiply
  dispatch)

;;; java.lang.Number

(defmethod multiply [Number]
  [a]
  (clj/* a))

(defmethod multiply [Number Number]
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

(defmethod multiply [Unit Number]
  [a b]
  (u/* a b))

(defmethod multiply [Number Unit]
  [a b]
  (u/* a b))


;; ---------------------------------------------------------------------
;; Division

(defmulti
  ^{:arglists '([a] [a b])
    :doc "Compute the quotient of one or two values according to their type."}
  divide
  dispatch)

;;; java.lang.Number

(defmethod divide [Number]
  [a]
  (clj// a))

(defmethod divide [Number Number]
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

(defmethod divide [Unit Number]
  [a b]
  (u// a b))

(defmethod divide [Number Unit]
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
