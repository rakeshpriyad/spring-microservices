https://algorithms.tutorialhorizon.com/category/dynamic-programming/

Wells Fargo:
Round 1 : Suresh

1. What is Generic?
2. What is Type inference
3. What is type errazor
4. Autoboxing
5. Delete vs Truncate (delete uses another table space, and once commit is done only delete is performed)
6. Microservice communication
7. Spring Boot advantages
8. How to handler if a spring boot has to be deployed on prod in tomcat, and local in embeded.
9. Maven Scope
10. What is ref cursor
https://www.oracletutorial.com/plsql-tutorial/plsql-cursor-variables/
11. Exception Handling
12. Exception propogation
13. constructor chaining incase of Super classa and sub class
14. if we provide simple constructor, what compiler does add
super
15. When static block is called
16. How many time a class is loaded?


Round 2: KK
1. How to achieve security like hdfc bank/ any other bank
2. Where encryption happens in browser?
3. inter communication between microservices?
5. What is 12 factor app?
6. Explaion the desing of microservice if we have to display Account Summary by just logging in
Account Service
Account Summary Service
User Service
Inter communication using apigateway, etc
7. why did you choose technology as Spring boot/Microservice
8. How to preprocess 20 GB file before putting into db
Spark
9. Why Spark, why not Flink 
Spark prior knowledge
10. Any idea about NoSQL
11. JMS/Kafka
12. What is the disadvantages if we have 10 Producer sending to same queuea and have only one consumer
if you have been given a chance, how would you re-design in JMS only
13. What are the 

Round 3:
1) How to find max if statement is not available in java
2) Explain Microservices architecture 
3) Advantages of Lambda
4) Any day you feel bad while returning from office
5) Why filter/map is faster of java8
6) Agile VS waterfall, which one you prefer and why?
7) Inter communication between microservices?





Java:
Threadpool vs Thread
Advantages of executor framework.
How to configure a job in CI CD/Jenkins
What are the content of Docker file
How to sort the file of 20 GB in 500MB ram?


How to do impact analysis, if field creditcard no will need to increase from 10 to 12 digits
Design an application of Credit Card, with asyncronous feature(Kafka)
How request is send to microservice from UI through Api gateway, explain the flow.
How do you handle risk ?

DBS:
1. How you deal with Performance tuning.
2. if you see, if any query is taking time, how you optimize it
3. How microservices communicate with each other.
4. Ho you handle security in microservices.
5. How change request works?
6. How the CI/CD works?
7. how you configure CI/CD in jenkins
8. How agile works?
9. How do you ensure your dev is done and it should be assign to QA?
10. Which Performance testing tool you are using.
11. Why did you decided to use Spring Boot.
12. How deployement happens in GKE



Updated DB and algo, Sys Design
Java8::
	1. Explain the functional Interface
	2. Explain the Lambda expression and its usage.
	3. Explain the difference between Stream and Colletion
	4. Write a program to sort the hashmap based on value
	5. Explain Concurrent HashMap changes (30 method added in java 8 in concrrent hashmap)
	6. Explain Diamond problem / What is the purpose of Default method (in interface)
	7. Hot to Convert List to Map
	8. Write a program to print the fibonacii number.
	Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
		.limit(10)
		.map(t -> t[0])
		.forEach(x -> System.out.println(x));
	9. Completeable future example 
		CompletableFuture<String> completableFuture
	  = CompletableFuture.supplyAsync(() -> "Hello");
	 
	CompletableFuture<Void> future = completableFuture
	  .thenAccept(s -> System.out.println("Computation returned: " + s));

	 
	future.get();
	10. Advantages and disadvantages of CompletableFuture
	11. Explain Stamped lock
	12. Write a program in java8 for fibonecii series.
	13. Explain MetaSpace in java8
	14. How Datetime api is different from old date time api, how calendar api is heavy weight?
	15. Will lambda expression not create duplicate code problem
	16. What is the advantages of Lambda, is any performance improvement due to Lambda
	17. 
Design:
	1. Design Lift Maintenance system (Elevator management).
	2. Design Resource bunder to read properties from properties file, yaml, and DB.
	3. Design LRU cache
	
Algo:
	1. What is the time complexity of Binary Search and explain how.
	2. What will be time complexity of TreeMap when contains key method is used. and explain how.
	3. Write a program to detect loop in linked list.
	4. Write a program to detect loop and break the loop
	5. Write a program to rotate the array.
	6. How to find the height of tree in non-recursive manner.

DB:
	1. What is ACID property in a database?
	2. What is the difference betbeen truncate and delete.
	3. How to remove duplicate rows from the table?
	4.	How to find count of duplicate rows? (95% asked in SQL queries for Interviews )
	5. Write an SQL Query to find maximum salary in each department of an organisation.
	6. How to display 1 to 100 Numbers with query?
	7. How to find Second highest salary in Employee table using self-join?
	8.How to Show the Max marks and min marks together from student table?
	9. How to calculate number of rows in table without using count function?
	10. How to fetch common records from two different tables which has not any joining condition.
	11. Display 4 to 7 records from Employee table.

TransactionManagement::
	1. How to handle transaction between multiple microservices
	2. What is the difference between Hibernate Transaction and Spring Transaction
	3. How to handler MDB transaction if MDB is receiving the data from the queue then publishing it to another queue and saving into db and sending mail (how to maintain atomicity).
	
DP :
	1. Explain Singleton desing Pattern, which one is best and why?
	2. Expalin Real life scenario where you used Decorator and why?
	3. Explain the Observer Design pattern
	4. Explainn the Template Design Pattern


Hibernate:
	1. Difference between update and merge
Docker and Kubernetes:
	1. Explain Kubernetes architecture
	2. How to do ssh in kubernetes container
	3. How to restart the container in docker
	4. Expalin the difference between save and export in docker command.
	5. Difference between docker and swarm.
Spring and MicroServices:
	1. Explain the difference between DI and IOC.
	2. Explain the difference between @Component and @Service
	3. Explain the Microservice Architecture
	4. How do you handle Distributed logging.
	5. How to convert Scheduler based monolithic application to microservice.
	6. if there is a singlton bean hodling prototype how will it behave and what will be the approach to fix it.
	7. if we have monolithic application how to convert it to microservice, key things to take care while converting it to microservice
	8. Explain the distributed logging management.
	9. Explain ELK (Elastic search, Logstash and Kibana)
	10. How do you deploy microservice in Kubernetes
Kafka:
	1. Explain the difference between Kafka and JMS
	2. Explain the Advantages and Disadvantages of Kafka.
Cache:
	1. Have you used Cache which one and why?
Performance Management:
	1. How to trace process in unix.
	2. How to handler OOM, explain your approach.
	3. if the web page loading take much time around 5 min, what will be the approach to solve it.
	4. What are the things to take care if part of code is identified as causing issue.
	