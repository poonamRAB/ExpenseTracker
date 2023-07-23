# ExpenseTracker
-------
## Framework and Language used
  + Springboot
  + JAVA
-------
## Data Flow
  + controller
      - ExpenseController
      - ProductController
      - UserController
  + model
    + dto
        - SignInInput
        - SignUpOutput
    - AuthenticationToken
    - Expense
    - Product
    - User
  + repository
      - IAuthenticationRepo
      - IExpenseRepo
      - IProductRepo
      - IUserRepo
  + service
      - hashingUtility
          + PasswordEncrypter
      - AuthenticationService
      - ExpenseService
      - ProductService
      - UserService
  + ExpenseTrackerApplication(main class)

-------
## Data Structure used
  + List
--------
## Project Summary 
This is a simple expense tracker backend design project. It can be used to keep expence record of perticular user.
Also sign up/ sign in is mandetory for user to use this application. Using Authentication token user will have limited
session period after sign in or sign up after that user need to login again. User can keep record of products with details.
