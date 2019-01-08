Test Case Sheet
Since the requirements were not mentioned I went ahead with my experience of testing such a Single page application and written testcases in excel sheet. These tests include
-	Different tabs of testcase sheet
o	Revision history – Gives detail of the author who has written the testcases
o	Test status – Gives the testcase summary of the test execution (count of Pass, Fail etc)
o	Testcases – List of all the testcases for the application
o	Issue Tracker – Gives list of bugs captured. Bugs are also mentioned inline to the failed testcases in the Testcases Tab
-	There is a total of 82 Manual testcases captured in the sheet Test cases. This includes both positive and negative/error testcases.
-	Test cases for validation of the Boundary values were omitted, since the requirements were not available

Bugs Captured:
-	There are 19 bugs captured during the testing out of which 10 are Major defects and 9 are Minor ones.
-	Detailed description of the bugs captured during execution is recorded in the word document ‘Hotel Bookings - Issues.docx’.
-	All the issues captured in the above sheet is mapped to the corresponding Failed testcases in the test case doc ‘Hotel Bookings - Testcases.xlsx’.

Automation Update:
Added individual automation testcases for Create and Delete bookings using the below technologies.
-	Selenium WebDriver which is a collection of open source APIs which are used to automate the testing of a web application
-	Java as Programming language
-	Maven is used as Build tool
-	JUnit which is an open source framework designed for the purpose of writing and running tests in the Java programming language
Steps to build the project:
1.	Import the project into any of the IDEs.
2.	Depending on the operating system where the code will run, update the attribute ‘os’ if required in “config.properties” file. If it is Mac, you need not make any changes. If windows comment out os=Mac and uncomment #os=Windows
3.	Then Run the HotelBookingsTests.java file (Navigation path: src -> test -> java -> org.equalexperts -> HotelBookingsTests.java)

