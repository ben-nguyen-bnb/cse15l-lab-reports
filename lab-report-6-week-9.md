
Week 8
# Week 9 Lab Report 

## Part 1

The following block of code is my grade.sh file
```
rm -rf student-submission
git clone $1 student-submission
cp TestListExamples.java student-submission
cp lib/hamcrest-core-1.3.jar student-submission
cp lib/junit-4.13.2.jar student-submission
cd student-submission

if [[ -f ListExamples.java ]]
then 
    echo "ListExamples.java File was found"
else 
    echo "0/5 tests passed"
    echo "ListExamples.java file is not found"
    exit
fi

javac -cp ".;hamcrest-core-1.3.jar;junit-4.13.2.jar" TestListExamples.java 2> error.txt > output.txt

if [[  $? -eq 0  ]]
then
    echo "file was compiled"
else
    echo "1/5 tests passed"
    echo "file was not compiled"
    cat error.txt
    exit
fi

java -cp ".;hamcrest-core-1.3.jar;junit-4.13.2.jar" org.junit.runner.JUnitCore TestListExamples 2> RuntimeError.txt > RuntimeOutput.txt
if [ $? -eq 0 ]
then
    echo "[PASSED] 5/5 tests passed"
    exit
else
    echo "at least 2/5 tests passed"
    echo "[FAILED] at least 1 test (total 3)"
    cat RuntimeOutput.txt
    exit
fi
```



## Part 2
Tracing `grade.sh` for Example 2
Student submission:

`https://github.com/ucsd-cse15l-f22/list-methods-corrected.git`


1. Line 1: `rm -rf student-submission`

Standard Output: [blank]

Standard Error: [blank]

Return Code: 0

2. Line 2: `git clone $1 student-submission`

Standard Output: [blank]

Standard Error:

`Cloning into 'student-submission'...`

Return Code: 0

3. Line 3: `cp TestListExamples.java student-submission`

Standard Output: [blank]

Standard Error: [blank]

Return Code: 0

4. Line 4: `cp lib/hamcrest-core-1.3.jar student-submission` 

Standard Output: [blank]

Standard Error: [blank]

Return Code: 0

5. Line 5: `cp lib/junit-4.13.2.jar student-submission`

Standard Output: [blank]

Standard Error: [blank]

Return Code: 0

6. Line 6: `cd student-submission`

Standard Output: [blank]

Standard Error: [blank]

Return Code: 0

7. Line 8: `if [[ -f ListExamples.java ]]`

The condition was true. In this line, the command is determining whether or not the `ListExamples.java` was in the student submission, and whether or not the file was submitted in the appropriate directory in the submission. Since in this example the student submitted the file and the file was in the approrpiate directory, the condition of this statement was true

8. Line 9: `then`

Indicates to the script to run the next section of code since the if statement's condition was true

9. Line 10: `echo "ListExamples.java File was found"`

Standard Output: 

`ListExamples.java File was found`

Standard Error: [blank]

Return Code: 0

10, Lines 11-14:
```
else 
    echo "0/5 tests passed"
    echo "ListExamples.java file is not found"
    exit
```
This block of code did not run because the if statement's condition in line 8 was true

11. Line 15: `fi`

Closes the if statement

12. Line 17: `javac -cp ".;hamcrest-core-1.3.jar;junit-4.13.2.jar" TestListExamples.java 2> error.txt > output.txt`

Standard Output: [blank]

Standard Error: [blank]

Return Code: 0

13. Line 19: `if [[  $? -eq 0  ]]`

The condition was true. This if statement determines whether or not the return code of the previous command (`javac -cp ".;hamcrest-core-1.3.jar;junit-4.13.2.jar" TestListExamples.java 2> error.txt > output.txt`) was 0 or not. Since the return code of the command was 0 (the code successfuly compiled without any compiler errors), the condition is true

14. Line 20: `then`

Indicates to the script to run the next section of code since the if statement's condition was true.

15. Line 21: `echo "file was compiled"`

Standard Output: 

`file was compiled`

Standard Error: [blank]

Return Code: 0

16. Lines 22-26:
```
else
    echo "1/5 tests passed"
    echo "file was not compiled"
    cat error.txt
    exit
```
This block of code did not run because the if statement's condition in line 19 was true.

17. Line 27: `fi`

Closes the if statement

18. Line 29: `java -cp ".;hamcrest-core-1.3.jar;junit-4.13.2.jar" org.junit.runner.JUnitCore TestListExamples 2> RuntimeError.txt > RuntimeOutput.txt`

Standard Output:
```
[JUnit version 4.13.2

...

Time: 0.039

OK (3 tests)]
```

Standard Error: [blank]

Return Code: 0

19. Line 30: `if [ $? -eq 0 ]`

The condition was true. This if statement determines whether or not the return code of the previous command (`javac -cp ".;hamcrest-core-1.3.jar;junit-4.13.2.jar" TestListExamples.java 2> error.txt > output.txt`) was 0 or not. Since the return code of the command was 0 (the code successfuly ran without any runtime errors), the condition is true

20. Line 31: `then`

Indicates to the script to run the next section of code since the if statement's condition was true.

21. Line 32: `"[PASSED] 5/5 tests passed"`

Standard Output: 

`[PASSED] 5/5 tests passed`

Standard Error: [blank]

Return Code: 0

22. Line 33: `exit`

Standard Output: [blank]

Standard Error: [blank]

Return Code: Non 0 exit code

23. Lines 34-39:
```
else
    echo "at least 2/5 tests passed"
    echo "[FAILED] at least 1 test (total 3)"
    cat RuntimeOutput.txt
    exit
```
This block of code did not run because the if statement's condition in line 30 was true. Additionally, line the 33 exited the bash script and therefore prevented the script from running the rest of the file


