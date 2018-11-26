(ns tests.day-10-knot-hash)

(defn get-result-of-multiplying-the-first-two-numbers-in-the-list? [circular-list input-lengths]
  (let [first-length-selects (take (first input-lengths) circular-list)
        after-reversing-that-section (into (take-last (- (count circular-list) (first input-lengths)) circular-list) first-length-selects )]
    after-reversing-that-section
    )
  )