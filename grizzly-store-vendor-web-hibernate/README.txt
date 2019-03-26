Grizzly-store-vendor-web-hibernate



In this project I have implemented hibernate in addition to the previously used concept of Servlets,Jsp,Html and Java.

The brief outline of the project is as follows:

----->The user log's into the interface and according to the role is guided to the respective page and its respective   
      functions and certain restrictions too.

----->If the user's role is admin then he/she is guided to the add product page initially after which they are able to view 
      the added products and also gives them the access to delete the product from the list.

----->The Admin can also add another product by clicking on ADD PRODUCT which will again guide them to the add product page.Also
      the admin is not allowed to access the inventory only the product tab is available for them.

----->After their task is over they can click the logout button which will guide them back to the login page, thus giving a chance 
      for other users either ADMIN/VENDOR can login.

----->If the VENDOR logs into the interface they will initially guided to the products tab showing all the information for the 
      products available in the database.

----->If the Vendor tries to access the inventory tab ,to which he/she has access they can update the stock of the product which
      was initially set to zero by pressing on the MANAGE button.

The major coding implementations of the project:

----->Also the Service layer was introduced in the code.

----->To avoid long extensive coding servlet chaining has been introduced.

----->To handle the Exception the User Defined Exceptions has been used under HibernateException.

----->Data Abstraction is introduced using interfaces for acesssing the methods.

----->The data in the iframe on the left is changing data dynamically according to the change in the user.

----->Joining of two tables has been used to access the data in the inventory table.	