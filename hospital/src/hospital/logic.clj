(ns hospital.logic)

; existe um problema de condicional quando o departamento não existe
;(defn cabe-na-fila?
;  [hospital departamento]
;  (-> hospital
;      departamento
;      count
;      (< 5)))


; funciona para o caso de não ter o departamento
;(defn cabe-na-fila?
;  [hospital departamento]
;  (when-let [fila (get hospital departamento)]
;    (-> fila
;        count
;        (< 5))))


; desvantagem/vantagem "menos explicito"
(defn cabe-na-fila?
  [hospital departamento]
  ;(count(get hospital departamento))
  ;some-> vai 'threadeando at'e encontrar um nulo
  (some-> hospital
      departamento
      count
      (< 5)))



(defn chega-em
  [hospital departamento pessoa]
  (if (cabe-na-fila? hospital departamneto)
    (update hospital departamento conj pessoa)
    (throw (IllegalStateException. "Não cabe ninguém neste departamento.")))
  )
