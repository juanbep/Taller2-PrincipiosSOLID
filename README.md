# Taller2-PrincipiosSOLID
Laboratorio de ingeniería del Software II - Taller número 2 sobre principios SOLID  

Aplicación sencilla que permita guardar y recuperar vehículos y además, facturar el pago de camiones, carros y motos de un parqueadero público.

Las reglas del negocio para ello son:

1.Todas las tarifas se deben redondear a la centena más cercana por encima. Por ejemplo, unatarifa de $15.283 se aproxima a $15.300.

2.Las motos pagan un valor fijo de $1.000 por la primera hora. Si está menos de una hora, se lecobra $1.000. Después de la primera hora, 
pagará una tarifa de $500 la hora o su fracción(regla de tres simple). Por ejemplo, si estuvo 1 hora y media,
pagaría: 1.000 + 250 = $1.250 =$1.300 (por el redondeo).

3.Los carros pagan un valor fijo de $2.000 por cada hora. Si el vehículo estuvo menos de unahora, se cobra un valor de $2.000. 
Después de la primera hora, pagará una tarifa de 1.000 lahora   o   su   fracción   (regla   de   tres   simple).   
Por   ejemplo,   si   estuvo   dos   horas   y   10   minutos,pagaría: 2.000 + 1.000 + 166 = 3166 = $3200 (por el redondeo). 

4.Los camiones pagan un valor de $15.000 por un día completo (de 24 horas). Si el camión estámenos o igual de 12 horas se le cobra un valor de $10.000,
entre 12 y 24 horas paga $15.000.En adelante de las 24 horas, pagará $15.000 por cada día y por las horas restantes se le cobra la fracción de tiempo respecto
a los $15.000 (regla de tres simple). Por ejemplo, si estuvo tresdías completos y 1 hora, pagaría: 15000x3 + 625 = 45625 = $45.700 (por el redondeo).

Específicamente para los  camioneros, los  cuales son el mercado objetivo, se hace todas  lasveces un sorteo (Por ejemplo, acertarle a un número aleatorio 
de entre 1 y 1000), en caso desalir beneficiado, el costo sería 0. Queda a la imaginación proponer los detalles del sorteo.

Aplicación que permita grabar y listar en una base de datos los vehículos que ingresan al parqueadero y calcular el valor a pagar de un vehículo cualquiera 
que sea su tipo. Aplicar los principios SOLID. 
