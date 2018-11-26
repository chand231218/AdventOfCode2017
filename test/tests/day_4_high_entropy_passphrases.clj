(ns tests.day-4-high-entropy-passphrases)

(defn count-valid-passphrase-must-contain-no-duplicate-words [& passphrases]
  "To ensure security, a valid passphrase must contain no duplicate words.

For example:

aa bb cc dd ee is valid.
aa bb cc dd aa is not valid - the word aa appears more than once.
aa bb cc dd aaa is valid - aa and aaa count as different words."
  (count (filter #(let [passphrase-vec (clojure.string/split % #" ")]
                    (= (count passphrase-vec) (count (distinct passphrase-vec)))
                    ) passphrases))

  )