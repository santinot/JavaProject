# SmartCIty: Rilevazione Dati   
Questo progetto è stato realizzato per approfondire lo studio del paradigma della
programmazione a oggetti, utilizzando l’omonimo linguaggio Java.
Il caso affrontato prevede di implementare un’architettura Client-Server per un’ipotetica
SmartCity, in cui il ruolo di client è svolto da dei Sensori di Rilevamento Dati, che si occupano
principalmente di raccogliere informazioni riguardo il valore della Temperatura, della Qualità
dell’Aria e della Qualità dell’Acqua del luogo in cui sono posizionati. Riguardo al server, questo
si occuperà di ricevere i dati inviati da ogni sensore e di inoltrarli ad un database, il quale li
organizzerà e conserverà in base al tipo di misurazione rilevata.
Per la comunicazione tra i sensori ed il server è stato utilizzato il protocollo di rete UDP (User
Datagram Protocol), in quanto si vuole dare una maggiore rilevanza alla velocità con cui i dati
vengono scambiati, piuttosto che alla garanzia che questi arrivino sicuramente a destinazione ed
in maniera ordinata; questo protocollo infatti permette di evitare la creazione di una connessione
“sicura” per ogni pacchetto inviato ed i relativi controlli (acknowledgement), riuscendo a snellire
il processo di comunicazione e ad aumentare il throughput. Inoltre, ogni misurazione che viene
effettuata dai sensori, prima di essere inviata, viene serializzata, in modo da convertirla in un
flusso di byte che poi verrà ricostruito a destinazione, e inserito all’interno del database sotto
forma di file JSON, per una migliore organizzazione delle informazioni raccolte.
Per la realizzazione del progetto viene infine utilizzato un approccio multithreading, in maniera
da rendere indipendente l’attività dei sensori. Ognuno di questi, quindi, lancerà un thread nel
momento in cui viene messo in esecuzione, tramite il quale riuscirà ad effettuare ed inviare le
proprie misurazioni.
