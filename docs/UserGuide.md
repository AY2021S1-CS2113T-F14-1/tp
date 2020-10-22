# User Guide
1. Introduction
2. Quick Start
3. Features <br/>
   3.1 Help `help` <br/>
   3.2 Exit the program: `exit` <br/>
   3.3 HR `HR` <br/>
      *  Add Members: `addMember`<br/>
      *  Delete Members: `delMember`<br/>
      *  View summary of members: `listMember`<br/>
   
   3.4 Events `event` <br/>
     * Add events: `addEvent`<br/>
     * Delete events: `delEvent`<br/>
     * View Summary of events: `listEvent`<br/>
     * Countdown events: `countdown` <br/>
     * Mark event as done: `done` <br/>
     * search for a particular event `search`<br/>
     
   3.5 Finance `finance` <br/>
     * Add finance log : `addLog`<br/>
     * Delete finance log: `delLog`<br/>
     * View financial summary: `summary`<br/>
            
4. FAQ
5. Command Summary
6. Glossary

## Introduction

CCA Manager is a revolutionary tool that changes the way you can manage interest groups with unrivaled efficiency and simplicity. Its lightweight Command Line Interface (CLI) allows administrators to breeze through tasks quickly and easily while offering powerful features to advanced users.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of CCA manager from here
3. Run the program by entering java -jar cca.java in a terminal.

## Features 

### 3.1 Help `help`
Shows a list of available commands<br/>
Format: help
### 3.2 Exit the program: `bye` 
Exits the program.
Format: `bye`

### 3.3 HR features `HR` <br/>
#### Add members: `addMember`<br/>
Adds a member to the list of members.<br/>

Format: `hr add /n NAME /p PHONE_NUMBER /e EMAIL /r ROLE`<br/>

Example of usage: <br/>
 `hr addMember /n John Sterling /p 88888888 /e js@gmail.com /r president`<br/>
 `hr addMember /n Harry Potter /p 12345678 /e H_P@gmail.com /r member`<br/>
 
 #### Delete members: `delMember`<br/>
 Deletes a member from the list of members. <br/>
 Format: `hr delMember MEMBER_INDEX` <br/>
 Deletes the member at the specified MEMBER_INDEX.<br/>
 
 The MEMBER_INDEX refers to the index number shown in the list of members.<br/>
 The MEMBER_INDEX must be an integer greater than 0. <br/>
 
 Example of usage: 
 `hr delMember 1` <br/>
 `hr delMember 19` <br/>

#### list members: `listMember`<br/>
Prints the list of members, based on the order in which they are added into the list. 
Format: `hr listMember` <br/>

Example of usage:
`hr listMember`  


#### search members: `search`  
Search the members whose information matches user input.  
Format: `hr search ITEM (/n ITEM) (/p ITEM) (/e ITEM) (/r ITEM)`  

Example of usage:  
`hr search peter`  
`hr search /n peter /r president`  


#### view contacts of prof/admin: `list prof&admin`  
List the contacts of the professors and administrators.  
Format: `hr list prof&admin`  

Example of usage:  
`hr list prof&admin`  


#### view contacts of connections: `list connections`  
List the contacts of connections(alumni, speakers).  
Format: `hr list connections`  

Example of usage:  
`hr list connections`  


### 3.4 Event features`event` <br/>
#### Add events: `addEvent`<br/>
Adds an event to the list of events.<br/>

Format: `event addEvent /n EVENT_NAME /d EVENT_DATE /t EVENT_TIME`<br/>

Example of usage: <br/>
 `event addEvent /n arduino course /d 2020-12-30 /t 8pm`<br/>
 `event addEvent /n Autodesk course/d 2020-12-20 /t 8-10.30pm`<br/>
 
 #### Delete events: `delEvent`<br/>
 Deletes an event from the list of events. <br/>
 Format: `event delEvent EVENT_INDEX` <br/>
 Deletes the event at the specified EVENT_INDEX.<br/>
 
 The EVENT_INDEX refers to the index number shown in the list of events.<br/>
 The EVENT_INDEX must be an integer greater than 0. <br/>
 
 Example of usage: 
 `event delEvent 1` <br/>
 `event delEvent 19` <br/>

#### list events: `listEvent`<br/>
Prints the list of events, based on the order in which they are added into the list. 
Format: `event listEvent` <br/>

Example of usage: 
`event listEvent`

#### countdown events `countdown`<br/>
lists the events with the number of days left. It also sorts them so that the event due first will be displayed first.<br/>
Format: `event countdown` <br/>

Example of usage: 
`event countdown`

#### Mark an event as completed `done`<br/>
Mark an event as done. 
Format: `event done EVENT_INDEX` <br/>

The EVENT_INDEX refers to the index number of the event that is to be marked as completed.<br/>
The EVENT_INDEX must be an integer greater than 0. <br/>

Example of usage:
`event done 1`

#### Search for an Event `search`<br/>
Search for a particular event.
Format: 'event search /s KEYWORD' <br/>

Example of usage:
`event search /s arduino course`


### 3.5 Finance features `finance`  
#### Add finance log entry: `addLog`  
Adds an entry into the finance log.  
Format: `finance addLog ITEM_NAME ITEM_VALUE`  

Example of usage:  
`finance addLog have lunch 4.5`  
`f addlog buy flight ticket 750`  

#### Delete finance log entry: `delLog`  
Removes an entry from finance log.  
Format: `finance delLog ITEM_INDEX`  

Example of usage:  
`finance dellog 3`  
`f delLog 10`  

#### View financial summary: `summary`  
Brings up a summary of the financial log and shows the total amount of money expended.  
Format: `finance summary`  


##FAQ

##Command Summary
Command | Format | Example
------- | ---------- | ------------
help | `help` | -
bye | `bye` | -
addMember  | `hr addMember /n NAME /p PHONE_NUMBER /e EMAIL /r ROLE` | `hr addMember /n Harry /p 12345678 /e HP@gmail.com /r member`<br/>
delMember  | `hr delMember MEMBER_INDEX` | `hr delMember 1`
listMember  | `hr listMember` | -
addEvent | `event addEvent /n EVENT_NAME /d EVENT_DATE /t EVENT_TIME` | `event addEvent /n arduino course /d 2020-09-16 /t 8pm`<br/>
delEvent | `event delEvent EVENT_INDEX`  | `event delEvent 1`
listEvent | `event listEvent` | -
countdown | `event countdown` | -
done   | `event done EVENT_INDEX`| `event done 2`
search | `event search /s <KEYWORD>` | `event search /s arduino` 
addLog | `finance addLog ITEM_NAME ITEM_VALUE` | `finance addLog have lunch 4.5`
delLog | `finance delLog ITEM_INDEX` | `finance delLog 3`
summary | `finance summary` |   -
hr search | `hr search ITEM (/n ITEM) (/p ITEM) (/e ITEM) (/r ITEM)` | `hr search /n Peter /r president`
list prof&admin | `hr list prof&admin` | -
list connections | `hr list connections` | -

##Glossary



