# JOM. Inner, outer class. Enum
## Task 5
Create **ClientType** enum that contains **NEW**, **SILVER**, **GOLD** and **PLATINUM** constants that represent client status.

For storing count of months for each client create private "months" field of type int and initialize it using constructor with int parameter.

Set for each item of **enum** a value according to next table:  


Client status | Count of months  
--|--  
NEW | 1  
SILVER | 12  
GOLD | 30  
PLATINUM | 60  


Create **public** method named **“discount()”** that return discount value as coefficient from **1.0** to **0.0** according to client status.

By default **discount()** method should return value **1.0** of **double** type.

Override **discount()** method for each constant and return discount value that calculated by next formula:

 
Client status | Formula  
--|--  
NEW | Default value  
SILVER | (100 - `<count of months>` * 0,25) / 100  
GOLD | (100 - `<count of months>` * 0,3) / 100  
PLATINUM | (100 - `<count of months>` * 0,35) / 100  

> For correct passing of all tests don't use print and println methods in your code.   

