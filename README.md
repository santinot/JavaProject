# SmartCIty: Rilevazione Dati   
Il progetto consiste nel realizzare un architettura client-server che permetta di ricevere dei dati in input ogni tot tempo
(ipotizzando che vengano inviati da dei rilevatori/sensoridi una SmartCity),
comunicarli ad una piattaforma che si occuperà di trasferirli ad un Database in cui questi dati verranno raccolti.
Il tutto dovrà essere realizzato secondo implementazione MultiThreading. 
Riguardo alla generazione dei dati, quindi il client, questi devono essere ottenuti tramite l'utilizzo della Serializzazione, quindi ci sarà una classe base che genererà i dati in maniera
randomica all'interno di un certo intervallo, che verrà estesa da una superclasse Misurazione, dalla quale discenderanno le altre classi rappresentanti le singole
rilevazioni (es. temperatura, inquinamento aria, ...).
Riguardo il server invece, questo dovrà avere una classe astratta GestoreDatabase che permetta la comunicazioni dei dati, in modo che sia possibile l'indipendeza del
sistema dal database utilizzato, così da generalizzare il tutto per un qualsiasi db utilizzato (nel progetto verrà utilizzato mongodb).
I dati all'interno del database dovranno essere memorizzati sotto forma di JSON. ( non so bene come ma credo con i file)
Verrà utilizzato XML per via del gestore delle classi MAVEN e per le API utilizzate per le comunicazioni.



Requisiti progetto:
-Information Hiding
-Client/Server
-Multithreading
-Database
-XML
-UML delle classi.

GL.


Classe sensore astratto, da cui derivano i vari che sensori.
Classe misurazione astratta da cui derivano le varie misurazioni specifiche, che serializza i dati e sarà integrata in sensore.
