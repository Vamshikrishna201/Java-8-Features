# 🗓️ Date & Time API Changes in Java (Java 8+)

---

## Legacy Date Classes (Pre-Java 8)

In Java, before version 8, the following two classes were primarily used to represent a date:

* **`java.util.Date`**: Used for **normal date-related operations**.
* **`java.sql.Date`**: Used when performing **database operations**.

> **Note:** When you create an object for `java.util.Date`, it represents **both date and time**.
>
> ```java
> Date d = new Date();
> System.out.println(d); // Example output: Wed Nov 19 23:08:02 IST 2025
> ```

---

## SimpleDateFormat

If you want to format a `Date` object to get only the time or a specific format, you use the `SimpleDateFormat` class, which is available in the `java.text` package.

### Key features of `SimpleDateFormat`:

* It's a **predefined class** in the `java.text` package.
* It provides methods to perform **Date conversions**:
    * **Date to String conversion**: `String format(Date d);`
    * **String to Date conversion**: `Date parse(String str);`

---

## Modern Date/Time API (Java 8+)

To overcome the problems and limitations of the older classes (like **not being thread-safe** and having a **confusing design**), Java introduced a new **Date/Time API (JSR-310)** in **Java 8**.

### Key Advantages of the New API:

1.  **Immutability:** All core classes in `java.time` are **immutable** and **thread-safe**. Any operation that modifies a date/time object (like adding days) returns a *new* instance, unlike the old, mutable classes.
2.  **Domain-Driven Design:** Clear separation of concerns, meaning each class represents a single, well-defined concept.

### Core Classes (`java.time`)

| Class | Purpose | Includes Time Zone? |
| :--- | :--- | :--- |
| `java.time.LocalDate` | Date only (year-month-day) | No |
| `java.time.LocalTime` | Time only (hour-minute-second-nanosecond) | No |
| `java.time.LocalDateTime` | Date and Time combined | No |
| **`java.time.Instant`** | **A point on the timeline (machine time)** | **Always UTC** |
| **`java.time.ZonedDateTime`** | **Date, Time, and a fully qualified Time Zone** | **Yes** |
| **`java.time.Duration`** | **A time-based amount of time (e.g., 5 seconds)** | **N/A** |
| **`java.time.Period`** | **A date-based amount of time (e.g., 3 months, 2 days)** | **N/A** |
| **`java.time.DateTimeFormatter`** | **Used for formatting/parsing (replaces SimpleDateFormat)** | **N/A** |

> **Note on Time Zones:** The "Local" classes (`LocalDate`, `LocalTime`, `LocalDateTime`) are excellent for representing a date/time without a specific time zone reference (e.g., a birthday or a scheduled job). For global or distributed systems, you must use **`ZonedDateTime`** or **`Instant`**.