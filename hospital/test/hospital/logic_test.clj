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


(deftest chega-em-test
  (testing "Aceita pessoas enquanto cabem pessoas na fila"
    (is (= {:espera [1, 2, 3, 4, 5]}
           (chega-em {:espera [1, 2, 3, 4]}, :espera, 5)))

    (is (= {:espera [1, 2, 5]}
           (chega-em {:espera [1, 2]}, :espera, 5))))

  (testing "Nao aceita quando nao cabe na fila"
    ; verificando que uma exception foi jogada
    ; código clássico horrível. usamos uma exception GENERICA.
    ; mas qq outro erro generico vai jogar essa exception, e nós vamos achar que deu certo
    ; quando deu errado
    ;(is (thrown? clojure.lang.ExceptionInfo
    ;             (chega-em {:espera [1 35 42 64 21]}, :espera 76)))

    ; mesmo que eu escolha uma exception do genero, perigoso!
    ;(is (thrown? IllegalStateException
    ;             (chega-em {:espera [1 35 42 64 21]}, :espera 76)))

    ; outra abordagem, do nil
    ; mas o perigo so swap, teriamos que trabalhar em outro ponto a condicao de erro
    ;(is (nil? (chega-em {:espera [1 35 42 64 21]}, :espera 76)))
    )
  )

