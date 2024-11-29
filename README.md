# Task Management API with Tags

### Overview
The Task Management API will allow users to create, manage, and organize tasks while
associating them with tags. Each task can have multiple tags, and tags can be linked to
multiple tasks. This API will enable users to create tasks, add tags, update task statuses, and
delete tasks, while managing relationships between tasks and tags.
Other :
- Authentication
- Advanced Filtering
- Tag Management:
- Audit Logs
- Controlled access for tasks only
- pagination & sorting (audit logs)
###### TODOs
###### - role based access...

## 1. Clone the Repository

Clone the repository and navigate to project folder:

```bash
git clone git@github.com:humphrey-mutuma/tasks-mgt-api.git
cd /tasks-mgt-api
```
## 3. Build the Project
Ensure you have Maven and java 17+ installed on your machine. 
Build the project and skip tests for now (if needed):

- NOTE: The project has a Postgres DB setup by default for testing, it will be deleted later
- If you wish, you can use a local postgres DB or pull an image

```bash
mvn clean install -DskipTests
```
### 4. Run the Application
After the build is complete, run the Spring Boot application using the following command:
``` bash
java -jar target/tasks-0.0.1-SNAPSHOT.jar
```
### 5. Access the Application on Swagger
Once the application starts, access it at:


- http://localhost:8080/swagger-ui.html

## 
 
