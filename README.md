# AP-Java

## Data Source
Dataset: Restaurant Tips Dataset
Author: Saurabh Badole
Kaggle Link: https://www.kaggle.com/datasets/saurabhbadole/restaurant-tips-dataset
Focus: Analyzing Factors Influencing Tips in a Restaurant Setting

## License and Usage Rights
This dataset is available publicly on Kaggle for educational and research purposes as well as data science analysis projects. Since it's hosted on Kaggle's public platform, it is appropriate for academic coursework like AP Java projects.


### What Each Row Represents
Each row in the dataset represents **one restaurant dining transaction** 

### Column Headers/Representation

| Column Name | Data Type | Description |
|------------|-----------|-------------|
| `total_bill` | Numerical | Total bill amount in dollars |
| `tip` | Numerical | Tip amount given in dollars |
| `sex` | Categorical | Customer gender |
| `day` | Categorical | Day of the week |
| `time` | Categorical | Time of day (Lunch/Dinner) |
| `size` | Numerical | Party size (number of people) |

### Java Class Design
To store each record as an object, I would design a `RestaurantTip` class with the following fields:

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
## Analysis
Column 1: total_bill
Total Records Processed: 244

Minimum Value: 3.07
Maximum Value: 50.81
Average Value: 19.79
Range: 47.74
This is notable because $50.81 is not a high total bill considering the party sizes range up to 6 people. This value corresponds to a 3 person party, which is reasonable. I was surprised to find out the 6 person party spent less though.

Column 2: tip
Total Records Processed: 244

Minimum Value: 1.00
Maximum Value: 10.00
Average Value: 3.00
Range: 9.00
This is notable as the tip range is pretty high, and the average value is closer to the lower end. This makes me think about what made the outlier want to tip $10.00. 

## Citation
```
Badole, S. Restaurant Tips Dataset. Kaggle. 
https://www.kaggle.com/datasets/saurabhbadole/restaurant-tips-dataset
```

