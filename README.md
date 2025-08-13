# AP-Java

## Data Source
Dataset: Restaurant Tips Dataset
Author: Saurabh Badole
Kaggle Link: https://www.kaggle.com/datasets/saurabhbadole/restaurant-tips-dataset
Focus: Analyzing Factors Influencing Tips in a Restaurant Setting

## License and Usage Rights
This dataset is available publicly on Kaggle for educational and research purposes as well as data science analysis projects. Since it's hosted on Kaggle's public platform, it is appropriate for academic coursework like AP Java projects.

## Dataset Properties

| Column Name | Data Type | Description |
|------------|-----------|-------------|
| `total_bill` | Numerical | Total bill amount in dollars |
| `tip` | Numerical | Tip amount given in dollars |
| `sex` | Categorical | Customer gender |
| `day` | Categorical | Day of the week |
| `time` | Categorical | Time of day (Lunch/Dinner) |
| `size` | Numerical | Party size (number of people) |

## Data Representation

### What Each Row Represents
Each row in the dataset represents **one restaurant dining transaction** - a complete record of a single table's bill, tip, and dining details from a restaurant.

### Java Class Design
To store each record as an object, I designed a `RestaurantTip` class with the following fields:

| CSV Column | Java Field | Data Type | Reasoning |
|------------|------------|-----------|-----------|
| `total_bill` | `totalBill` | `double` | Money values need decimal precision |
| `tip` | `tipAmount` | `double` | Money values need decimal precision |
| `sex` | `customerGender` | `String` | Text data (Male/Female) |
| `day` | `dayOfWeek` | `String` | Text data (Sun, Mon, etc.) |
| `time` | `mealTime` | `String` | Text data (Lunch/Dinner) |
| `size` | `partySize` | `int` | Whole number of people |

### UML Class Diagram
```
┌─────────────────────────────────────┐
│           RestaurantTip             │
├─────────────────────────────────────┤
│ - totalBill: double                 │
│ - tipAmount: double                 │
│ - customerGender: String            │
│ - dayOfWeek: String                 │
│ - mealTime: String                  │
│ - partySize: int                    │
├─────────────────────────────────────┤
│ + RestaurantTip()                   │
│ + RestaurantTip(params...)          │
│ + getTotalBill(): double            │
│ + getTipAmount(): double            │
│ + getCustomerGender(): String       │
│ + getDayOfWeek(): String            │
│ + getMealTime(): String             │
│ + getPartySize(): int               │
│ + getTipPercentage(): double        │
│ + getTipPerPerson(): double         │
│ + toString(): String                │
│ + [all setters and standard methods]│
└─────────────────────────────────────┘
```
## Project Structure
```
restaurant-tips-analysis/
├── README.md
├── data/
│   └── tips.csv
├── src/
│   ├── RestaurantTip.java
│   ├── DataAnalyzer.java
│   └── Main.java
└── docs/
    └── analysis-results.md
```
## Expected Outcomes

## Citation
```
Badole, S. Restaurant Tips Dataset. Kaggle. 
https://www.kaggle.com/datasets/saurabhbadole/restaurant-tips-dataset
```

