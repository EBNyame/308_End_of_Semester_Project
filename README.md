# 308 End of Semester Project
# 🚛 Adom Logistics Fleet Management and Delivery System

Adom Logistics, based in Tema, Ghana, faced challenges due to manual record-keeping for managing fleet operations. This console-based, offline system was developed to automate and streamline vehicle tracking, driver assignments, maintenance schedules, and delivery tracking without relying on external libraries or APIs.

---

## 📌 Features

### 1. Vehicle Database
- Add, remove, and search trucks and delivery vans.
- **Attributes:** Registration Number, Type, Mileage, Fuel Usage, Assigned Driver ID, Maintenance History.
- **Storage:** `vehicles.txt`  
- **Data Structure:** Custom list-based structure for direct access.

### 2. Driver Assignment
- Manage driver pool and assign drivers to vehicles or deliveries.
- **Attributes:** ID, Name, Experience, Location, Routes, Delays, Infractions.
- **Storage:** `drivers.txt`
- **Data Structure:** Queue-based simulation.

### 3. Delivery Tracking
- Track packages from origin to destination.
- **Attributes:** Package ID, Origin, Destination, Assigned Vehicle & Driver, ETA, Status.
- **Storage:** `deliveries.txt`
- **Data Structure:** Queue-like system for tracking delivery flow.

### 4. Maintenance Scheduler
- Automatically flags vehicles due for service based on mileage or service date.
- **Attributes:** Date, Mileage, Parts Replaced & Costs.
- **Storage:** Inside `vehicles.txt` (can be separated).
- **Data Structure:** Iterative search (possible future min-heap upgrade).

### 5. Fuel Efficiency Reports
- Calculates average fuel consumption and identifies anomalies.
- **Implementation:** Iterative analysis across fleet data.

### 6. File Storage
- All records are stored in plain text files:
  - `vehicles.txt`
  - `drivers.txt`
  - `deliveries.txt`
  - `maintenance.txt`

---

## ⚙️ System Architecture

- **Language:** Java (no external libraries)
- **Data Handling:** Manual data structure implementation (lists, queues, maps)
- **Persistence:** Java File I/O (sequential read/write)

---

## 📈 Algorithms and Logic

- **Search & Sort:**
  - Binary search for sorted data (planned)
  - Sorting via Insertion, Merge, or Quick Sort

- **Data Structures:**
  - Array/List for vehicles
  - Queue for driver and delivery management
  - HashMap for maintenance records

---

## 📊 Time & Space Complexity

| Operation                  | Time Complexity |
|---------------------------|-----------------|
| Add/Search Vehicle        | O(1) / O(n) or O(log n) |
| Add Driver/Delivery       | O(1)            |
| Assign Next Driver        | O(1)            |
| Maintenance Check         | O(n)            |
| File Read/Write           | O(N)            |

**Space Complexity:** O(V + D + L)  
Where:  
- V = Number of Vehicles  
- D = Number of Drivers  
- L = Number of Deliveries

---

## 💡 Future Enhancements
- Use of priority queues for delivery urgency.
- Separate maintenance database.
- GUI version or web-based application.
- More advanced search and reporting modules.

---

## 🧠 Project Reflection

This system models real-world logistics dispatching using code, emulating manual systems through queues and lists. It provides a foundational approach for developing larger, scalable fleet management software.

---

## 📁 Project Files

- `vehicles.txt`: Stores vehicle information and maintenance history
- `drivers.txt`: Contains driver records and assignments
- `deliveries.txt`: Tracks package deliveries
- `maintenance.txt`: Optional separate maintenance logs

---

## 👨‍💻 Developer Note

This was developed as an educational and practical solution to address operational inefficiencies in Adom Logistics' current system. It prioritizes simplicity, accessibility, and algorithmic thinking over external dependencies.
