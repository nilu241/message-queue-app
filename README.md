# **Message Queue Producer-Consumer Application**

## **Project Overview**

This is a simple message-driven Java application simulating a producer-consumer scenario using a custom message queue implementation. The application includes logging to track the total number of messages processed successfully and the number of errors encountered during processing.

Additionally, the project includes unit tests to verify both successful and failure scenarios.

---

## **Features**

- **Custom Message Queue**: A thread-safe queue implementation.
- **Producer-Consumer**: Multithreaded simulation of message production and consumption.
- **Error Handling**: Tracks successfully processed messages and errors.
- **Unit Testing**: Verifies application behavior in different scenarios.

---

## **Technologies Used**

- Java 11
- Maven (for dependency management)
- JUnit 5 (for testing)

---

## **Project Structure**

```
src/
├── main/
│   ├── java/
│   │   ├── MessageQueue.java
│   │   ├── Producer.java
│   │   ├── Consumer.java
│   │   └── Main.java
├── test/
│   ├── java/
│   │   └── MessageQueueTest.java
pom.xml
README.md
```

---

## **Prerequisites**

- **Java JDK 11** or later
- **Maven** (installed and added to your PATH)

---

## **Setup Instructions**

### **1. Clone the Repository**

Clone this project to your local machine:

```bash
git clone https://github.com/your-username/MessageQueueProducerConsumer.git
cd MessageQueueProducerConsumer
```

### **2. Build the Project**

Run the following Maven command to clean and build the project:

```bash
mvn clean install
```

### **3. Run the Application**

Run the application using Maven:

```bash
mvn exec:java -Dexec.mainClass="Main"
```

Alternatively, you can compile and run it manually:

```bash
javac src/main/java/*.java
java -cp src/main/java Main
```

---

## **Running Tests**

### **Using Maven**

Run the unit tests with the following command:

```bash
mvn test
```

### **Test Coverage**

- **Success Scenario**: Validates successful message processing.
- **Failure Scenario**: Simulates and verifies error handling during processing.

---

## **Application Output**

### **Successful Execution**

Upon running the application, you will see logs similar to the following:

```plaintext
Produced: Message-1
Produced: Message-2
Consumed: Message-1
Consumed: Message-2
Total Messages Processed: 10
Total Errors Encountered: 0
```

### **With Simulated Errors**

If errors occur during message processing (e.g., a message contains the word "Error"), the application will log errors and display the count:

```plaintext
Produced: Message-5
Consumed: Message-5
Error processing message: Simulated error for Message-5
Total Messages Processed: 9
Total Errors Encountered: 1
```

---

## **Customization**

- Modify the number of messages produced in the `Main.java` file by updating the `Producer` instantiation:

  ```java
  Producer producer = new Producer(queue, 20); // Produces 20 messages
  ```
- Simulate specific errors by adding messages containing "Error" in the `Producer` logic.

---

## **Contributing**

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m 'Add new feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Open a pull request.

---

## **License**

This project is licensed under the MIT License. See the `LICENSE` file for details.

---
