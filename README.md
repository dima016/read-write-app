## This small Application was created to read data from XLSX file and write it to sql file

### Application properties are located in: 
* `read-write-file-app/src/main/resources/app_en_US.properties`
### To use this application you should update properties:
#### What properties does it contain:
##### For reading:
* `colNumberToRead - number of column that shoud be read`
* `startRowNumberToRead - first row number that should be read(by default read from startRowNumberToRead to last row)`
* `XlsxPathToRead - path to XLSX file to read data`

##### For writing:
* `SqlPathToWrite - path to SQL file to write data`
* `Sql Query - SQL query which will be written to the file inclusive pattern '%s' for putting read value inside query`