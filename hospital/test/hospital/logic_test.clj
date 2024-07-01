(ns hospital.logic-test
  (:require [clojure.test :refer :all])
  (:require [hospital.logic :refer :all]))


(deftest cabe-na-fila?-test

  ; boundary tests
  ; exatamente na borda e one off.

  ;borda do zero
  (testing "Que cabe na fila vazia"
    (is (cabe-na-fila? {:espera []}, :espera)))

  ;borda do limite
  (testing "Que nao cabe quando a fila esta cheia"
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5]}, :espera))))


  ;one off da borda do limite para cima
  (testing "Que nao cabe quando tem mais que uma fila cheia"
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5 6]}, :espera))))


  ; (testing "Que cabe quando tem pouco menos que uma fila cheia"
  ; (is (not (cabe-na-fila? {:espera [1 2 3 4]}, :espera))))

  ; (testing "Que cabe quando tem pouca fila"
  ; (is (not (cabe-na-fila? {:espera [1 2]}, :espera))))


  ;Os dois testes comentados poder ser unidos em apenas um testing:

  (testing "Que cabe quando a fila nao esta cheia"
    (is (cabe-na-fila? {:espera [1 2 3 4]}, :espera))
    (is (cabe-na-fila? {:espera [1 2]}, :espera)))


  (testing "Que ... quando o departamento nao existe"
    (is (not (cabe-na-fila? {:espera [1 2 3 4]}, :-raio-x))))
  )

