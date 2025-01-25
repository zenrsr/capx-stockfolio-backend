# **Capx Stockfolio Backend**

This is the backend for the **Capx Stockfolio** application, built with **Spring Boot** and deployed on **Render**. It provides RESTful APIs for managing stock data, connecting to an **Azure MySQL** database.

---

## **Features**
- **CRUD Operations**: Create, Read, Update, and Delete stock data.
- **Database Integration**: Connects to an Azure MySQL database.
- **RESTful API**: Exposes endpoints for managing stocks.
- **Deployment**: Hosted on Render for scalability and reliability.

---

## **Technologies Used**
- **Spring Boot**: Backend framework.
- **MySQL**: Database for storing stock data.
- **Hibernate**: ORM for database interactions.
- **Render**: Cloud platform for deployment.
- **Postman**: API testing tool.

---

## **API Endpoints**

### **Stocks**
| **Method** | **Endpoint**              | **Description**                        |
|------------|---------------------------|----------------------------------------|
| `GET`      | `/api/stocks`             | Fetch all stocks.                      |
| `GET`      | `/api/stocks/{id}`        | Fetch a single stock by ID.            |
| `POST`     | `/api/stocks`             | Create a new stock.                    |
| `PUT`      | `/api/stocks/{id}`        | Update an existing stock.              |
| `DELETE`   | `/api/stocks/{id}`        | Delete a stock.                        |

---

## **Database Schema**

### **Table: `stocks`**
| **Column**       | **Type**                | **Description**                        |
|------------------|-------------------------|----------------------------------------|
| `id`             | `BIGINT` (Primary Key)  | Unique identifier for the stock.       |
| `buy_price`      | `DECIMAL(38,2)`         | The price at which the stock was bought.|
| `cat`            | `ENUM`                  | Category of the stock (e.g., TECHNOLOGY).|
| `current_price`  | `DECIMAL(38,2)`         | Current price of the stock.            |
| `name`           | `VARCHAR(255)`          | Name of the stock (e.g., Apple Inc).   |
| `profit_loss`    | `DOUBLE`                | Profit or loss on the stock.           |
| `quantity`       | `INT`                   | Quantity of the stock held.            |
| `ticker`         | `VARCHAR(255)`          | Stock ticker symbol (e.g., AAPL).      |

---

## **Setup and Deployment**

### **Prerequisites**
- **Java 17**: Ensure Java 17 is installed.
- **MySQL**: Set up an Azure MySQL database.
- **Maven**: For building the project.

### **Local Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/capx-stockfolio-backend.git
   ```
2. Navigate to the project directory:
   ```bash
   cd capx-stockfolio-backend
   ```
3. Update the `application.yml` file with your database credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://<your-database-url>:3306/capx?useSSL=true&requireSSL=true
       username: <your-username>
       password: <your-password>
   ```
4. Build the project:
   ```bash
   mvn clean package
   ```
5. Run the application:
   ```bash
   java -jar target/capx-0.0.1-SNAPSHOT.jar
   ```

### **Deployment to Render**
1. Create a new **Web Service** on Render.
2. Upload the JAR file (`capx-0.0.1-SNAPSHOT.jar`).
3. Set the following environment variables:
   - `SPRING_DATASOURCE_URL`: `jdbc:mysql://<your-database-url>:3306/capx?useSSL=true&requireSSL=true`
   - `SPRING_DATASOURCE_USERNAME`: `<your-username>`
   - `SPRING_DATASOURCE_PASSWORD`: `<your-password>`
   - `SPRING_PROFILES_ACTIVE`: `prod`
4. Deploy the application.

---

## **Testing the API**
You can test the API using **Postman** or any HTTP client.

### **Example Requests**

#### **1. Fetch All Stocks**
- **Method**: `GET`
- **URL**: `https://capx-stockfolio-backend.onrender.com/api/stocks`

#### **2. Create a New Stock**
- **Method**: `POST`
- **URL**: `https://capx-stockfolio-backend.onrender.com/api/stocks`
- **Body** (JSON):
  ```json
  {
    "buy_price": 220.00,
    "cat": "TECHNOLOGY",
    "current_price": 225.46,
    "name": "Apple Inc",
    "profit_loss": 0.0,
    "quantity": 2,
    "ticker": "AAPL"
  }
  ```

#### **3. Fetch a Single Stock**
- **Method**: `GET`
- **URL**: `https://capx-stockfolio-backend.onrender.com/api/stocks/1`

#### **4. Update a Stock**
- **Method**: `PUT`
- **URL**: `https://capx-stockfolio-backend.onrender.com/api/stocks/1`
- **Body** (JSON):
  ```json
  {
    "buy_price": 230.00,
    "current_price": 235.50,
    "quantity": 5
  }
  ```

#### **5. Delete a Stock**
- **Method**: `DELETE`
- **URL**: `https://capx-stockfolio-backend.onrender.com/api/stocks/1`

---

## **Contributing**
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

---

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## **Contact**
For questions or feedback, feel free to reach out:
- **Email**: zenrsrdev@gmail.com
- **GitHub**: [zenrsr](https://github.com/zenrsr)

---

Feel free to customize this README file to match your project’s specifics. Let me know if you need further assistance! 🚀
