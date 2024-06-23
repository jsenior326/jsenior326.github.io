Pre-requisites:

Create a file named '.env' in the Grazioso folder containing the following line:
	JWT_SECRET=NewHampsh!reCollege0fAccounting@Commerce

Usage:

1. Ensure you are connected to MongoDB server.
2. Launch the Express application. (See below)
3. Launch the Angular SPA. (See below)
4. Sign in or create an account by clicking the log in button at the top right of the page.
5. Filter results using the dropdown selection. None returns all data.
6. Edit or delete rows from the table by clicking a button in the actions column.

Launching the Express Application:

1. Open a command prompt window.
2. Change directories to the project root folder ('Grazioso').
3. Run the following command:
   npm start
Note: The Express application should remain running at all times and will seed
      the database automatically on start-up.

Launching the Angular SPA:

1. Open a command prompt window
2. Change directories to the app_admin folder.
3. Run the following command:
   ng serve
4. Open a web browser and navigate to http://localhost:4200