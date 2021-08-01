This KTor project is made for the Tech Vidhya session on Clean Code.

Pre-requisites :
1. JDK
2. Docker
3. Postgres

Steps To Follow:
1. sudo docker-compose up --build
2. if build is failing due to port 5432 already being used
	a. sudo ss -lptn 'sport = :5432' // To find the process
	b. kill <pid> // Kill the process and go to step 1
3. sudo docker exec -t -i clean-code-app ./gradlew -t installDist
