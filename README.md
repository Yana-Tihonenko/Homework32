# Task1 
Write a program to create a small dictionary of slang programmer expressions so that it returns values from this dictionary on request.
Input data format
File dict.txt
The first line contains one integer n - the number of words in the dictionary. The next n lines contain the words and their definitions, separated by a colon and a space character. Keyboard input
The first line contains an integer m - the number of search words whose definition should be output.
The next m lines contain the words themselves, one per line.
Output format
For each word, regardless of its case, if it is present in the dictionary, its definition should be displayed. If the word is not in the dictionary, the program should print "Not found", without quotes.
# Task2 
   The file system of a supercomputer has been infiltrated by a virus that has broken control over file access rights. For each file, we know what actions can be performed to access it:
    write W,
    read R,
    run X.
File files.txt
The first line contains the number N - the number of files contained in this file system.
The next N lines contain the names of the files and the operations allowed with them, separated by spaces.
File operations.txt
The number M - the number of requests to the files - is specified next.
The last M lines contain a request of the form Operation File.
Any number of requests can be applied to the same file.
You need to regain control over access rights to files.
File results.txt
Your program should output for each query
File: Operation: OK if a valid operation is performed on the file, or File: Operation: Access denied if the operation is invalid.
