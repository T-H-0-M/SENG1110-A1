# Clinic Management System

This is a simple console-based application written in Java that simulates a clinic management system. The system allows you to manage doctors and pets, including adding new doctors and pets, removing existing ones, and analyzing pet data.

## Classes

The project consists of three main classes:

1. Clinic.java: This is the main class that contains the logic for the flow of the program. It includes methods for adding and removing doctors and pets, as well as for analyzing pet data.

2. Doctor.java: This class represents a doctor in the clinic. Each doctor has a name and a specialization (either "cat" or "dog").

3. Pet.java: This class represents a pet in the clinic. Each pet has a type (either "cat" or "dog"), a size (either "small", "medium", or "large"), a name, a weight, an age, and a doctor assigned to it.

## Usage

When you run the Clinic.java class, you will be presented with a menu of options:

1. New Doctor: Add a new doctor to the clinic. You will be asked to enter the doctor's name and specialization.

2. New Pet: Add a new pet to the clinic. You will be asked to enter the pet's name, type, age, size, weight, and the name of the doctor assigned to the pet.

3. Remove Doctor: Remove a doctor from the clinic. You will be asked to enter the name of the doctor you wish to remove.

4. Remove Pet: Remove a pet from the clinic. You will be asked to enter the name of the pet you wish to remove.

5. Pet List and Analysis: Analyze a pet's data. You will be asked to select a pet, and the system will display the pet's details and whether the pet is overweight based on its type and size.

6. Doctor List: Display a list of all doctors in the clinic.

7. Exit: Exit the program.

## Note

This is a simple console-based application and does not include any persistence or error handling. If you enter invalid data, the program will crash. Always enter data as prompted and use the correct format.

This is also an assignment I did in the first semester of my first year of Software Engineering, hence it does not follow best practice and is likely very inefficient. One day I will revisit this a recreate it with best practice.
