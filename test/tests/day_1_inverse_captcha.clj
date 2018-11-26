(ns tests.day-1-inverse-captcha)


(defn get-sum-of-all-digits-that-match-the-next-digit-in-the-circular-list [digit]
  (if (< digit 10)
    digit
    (let [digit-map (map (fn [^Character c] (Character/digit c 10)) (str digit)) ;; create a list from integer
          ]
      (loop [index 0 sum 0]
        (if (= index (- (count digit-map) 1))
          (if (= (nth digit-map index) (nth digit-map 0)) (+ sum (nth digit-map index)) sum)
          (let [sum-of-two-digit (if (= (nth digit-map index) (nth digit-map (+ index 1))) (nth digit-map index) 0)]
            (recur (+ index 1) (+ sum sum-of-two-digit)))
          )
        )
      )
    )
  )


(defn sum-of-all-digits-that-match-the-next-digit-in-the-circular-list [& digits]
  "find the sum of all digits that match the next digit in the list. The list is circular, so the digit after the last digit is the first digit in the list.
   For example:
   1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
   1111 produces 4 because each digit (all 1) matches the next.
   1234 produces 0 because no digit matches the next.
   91212129 produces 9 because the only digit that matches the next one is the last digit, 9.  "
  (map #(get-sum-of-all-digits-that-match-the-next-digit-in-the-circular-list %) digits)
  )



