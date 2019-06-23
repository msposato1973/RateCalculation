# Rate Calculation Application

## Problem Statement
There is a need for a rate calculation system allowing prospective borrowers to obtain a quote from
our pool of lenders for 36 month loans. This system will  take the form of a command-line application.
You will be provided with a file containing a list of all the offers being made by the lenders within the system in CSV format, see the example market.csv file provided alongside this specification.

You should strive to provide as low a rate to the borrower as is possible to ensure that Zopa's quotes are as
competitive as they can be against our competitors'. You should also provide the borrower with the details of the
monthly repayment amount and the total repayment amount.

Repayment amounts should be displayed to 2 decimal places and the rate of the  loan should be displayed to one decimal
place.

Borrowers should be able to request a loan of any £100 increment between £1000 and £15000 inclusive.
If the market does not have sufficient offers from lenders to satisfy the loan then the system should
inform the borrower that it is not possible to provide a quote at that time.

## Assumptions
If a lender has insufficient requested amount then we will take the maximum from him and rest can be taken from other lenders and rate will be the average rate

## Prerequisites
You need to install the following tools

* [Java 1.8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - Lambda and Annotation were used in the code
* [Maven](https://maven.apache.org/) - Dependency Management

## Building the code:
* Clone from git or unzip the supplied zip file, open shall ms dos and navigate to the root location of the project, where the POM is.
* Building jar: \RateCalculation\target\RateCalculation.jar

## Running the Application locally
1. Duration, Maximum and minimum loan amount are confiurable in a constant class
2. Sample MarketDataforExercise.csv file is kept at src\test\resources

## Running the App
* Sample test file is located at /src/test/resources
From the root path, run the following commands:

* mvn exec:java -Dexec.mainClass=com.zopa.ratecalculation.client.Application -Dexec.args="src/test/resources/MarketDataforExercise.csv 1500"

From the folder where jar is kept run below file via command prompt

###  java -jar "Absolute path of MarketDataforExercise.csv" "Loan amount"
### Example:: 
java -jar \RateCalculation\target\RateCalculation.jar C:\..\RateCalculation\src\test\resources\MarketDataforExercise.csv 1500

## Testing
This application is built using TDD methodology and tests are written in Junit

### TODO
1.Logs implementation

## The application should produce output in the form example:
Requested amount: £1000

Rate: 7.0%

Monthly repayment: £30.78

Total repayment: £1108.10
 



