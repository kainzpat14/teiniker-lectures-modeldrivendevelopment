# Metamodel Telephone System

## Task 

Create a metamodel based on the following domain description in any format you prefer (ex. PlantUML, Handdrawn)

## Domain

These days much of customer interaction is completely automated without the need for employees
performing these tasks. While younger customers are perfectly fine using a website or 
an app to interact with a company, older people do prefer using the phone. For this 
purpose automated telephone systems have been used for many years to increase the degree
of automation during phone calls to businesses. 

A telephone system contains a number of workflows, each triggered by a call to a certain 
extension and containing several menus which query the caller for information by making
them choose a menu entry. 

When a menu entry is chosen by the caller, either another menu is executed, a message is read and the call terminated, 
a subworkflow is called or the caller is transfered to a certain extension. 

A workflow has a name and a starting menu. Each menu contains a number of entries, a query string and 
does not have a name. 

An entry in the menu can have a number between 0 and 9 and a short description. 

An extension, regardless if its the one triggering a workflow or if its one to be called
is a numeric string. 

The messages to be read are strings.
