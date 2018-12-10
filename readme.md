# Group 2 Project  ![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")
Our goal its to make a metric program that able to show the user the metrics of a website or a file. It will
tell the use the amount of lines code and text. It will tell the user what kind of operators are present when the program is a java, c or a c++ file.
The user will then be given in a app window the metrics of their dataCollected based on the file that they upload.
provided. This application will work with both Mac and Windows machines.
> The program will allow the user to link a website(like a github file) or input a local file into the program
and then it will give the user the options to select what kind of metric they would like to see. The options we have to far are
word count, line count, character count, comment line count and source line count. The program will show the user in a GUI interface and a pie chart of what data it has gathered.
## Members 
* Christopher Vejsada
* Francisco Prado
* Michael Nguyen
* Cameron Kiyomura
* Jodilyn Peralta

# Software Requirements Specification
**Table of Contents**
1. **Introduction**

   **1.1** Purpose

      The purpose of this SRS document is to provide a detailed overview of our metrics software. This SRS will cover all aspects of the software.

   **1.2** Intended Audience

      As a tool for measuring software metrics, our target audience is primarily other software developers.

   **1.3** Scope

      Our goal is to deliver a platform in which users can measure the metrics of a file and are able to use this
      information in a easy and productive way.

2. **Overview**

   **2.1** Product Functions

      Our software will allow users to check for software metrics and information in their uploaded files or website. This will help aid the user
      in improving their software with the info provided. Below is a list and brief description of each software metric available in this program:

         - Lines of Code - raw lines of code in the program. (May include blank lines at end bottom of classes.)
         - Number of Words - raw number of words in the program.
         - Number of Characters - raw number of characters in the program.
         - Number of Lines - raw number of lines in the program.
         - Number of Source Lines of Code - number of lines including source code in the program.

         //Halstead Metrics - calculated value of operators in the program.
         //Depth of Inheritance - calculated ?w? value of class inheritance in the program.
         //Cyclomatic Complexity - raw number of unique paths in the program.
         //Maintainability Index - calculated value of maintainability of the program.
         //idk why this is making a box on webpage

   
   **2.2** Definitions

   Some terms in the SRS may be referred to via acronym, so we will be pre-defining any here.

      - GUI - Graphic User Interface

      - Char - Characters

      - LOC - Lines of Code

      - SLOC - Source Lines of Code

      - DIT - Depth of Inheritance

      - CC - Cyclomatic Complexity

      - MI - Maintainability Index
   
   **2.3** Product Constraints

      Our time frame for completion was approximately 7 weeks.
      Most of us were new to using V.C so getting past merge issues was a small setback.
      Some of the metrics gathering seems to work differently on different systems.

   **2.5** Operating Environment

      This program will run on Windows machines and Mac.
      (platform, OS)

3. **External Interface Requirements**

      **3.1** User Interfaces

      The GUI makes it much more user friendly to input a file or website than when using the program through a command line.
      The metrics are also placed in boxes making it much easier for the user to see what their file/url has.

4 **System Features**

   **4.1** GUI

      **4.1.1** Description and Priority

      A fully functioning GUI that allows user to get metrics from a file or a website with ease.
      The program will then relay this information to the GUI and user will be able to observe the data colected
      from their inputted source.


      **4.1.2** Stimulus/Response Sequences
      
      The user would need to run the java file within an IDE of some sort or run it as
      and excuatable. 


      **4.1.3** Functional Requirements
      The user needs to input a file or a website into the GUI, the user would need to specify what kinda of file
      it would be if not the file will default to a text file called (temp).

   **4.2**

5. **Other Non-Functional Requirements**
    
    User system needs to have java installed in order to run the program.
    Java runtime is required for full functionality of the program. User need to input a full url
    from github with no restrictions in order to run properly.  If there is a temp file the program will go to delete/rewrite
    that file in order list the metrics requested in the program. 

