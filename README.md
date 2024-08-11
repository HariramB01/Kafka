
Kafka Implementation: Event-source

step 1:  Establishing zookeeper-server under kafka directory

C:\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

step 2: Establishing kafka-server uner kafka directory

C:\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties

step 3: Creating a topic under kafka/bin/windows

C:\kafka\bin\windows>kafka-topics.bat --create --bootstrap-server localhost:9092 --topic producer1
Created topic producer1.

step 4: Enable the kafka producer console

kafka-console-producer.bat --broker-list localhost:9092 --topic test

step 5: Stream the data

for example:

{"Name: "John", "Age":"31", "Gender":"Male"}
{"Name: "Emma", "Age":"27", "Gender":"Female"}
{"Name: "Ronald", "Age":"17", "Gender":"Male"}


