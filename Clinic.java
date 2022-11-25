import java.util.*;
import java.lang.*;

public class Clinic {

    //Thomas Bandy c3374048

    private static Doctor d1 = new Doctor();
    private static Doctor d2 = new Doctor();
    private static Pet p1 = new Pet();
    private static Pet p2 = new Pet();
    private static Pet p3 = new Pet();
    private static Pet p4 = new Pet();
    private static Scanner kb = new Scanner(System.in);
    private static String response = null;
    private static int responseInt = 1;
    private static double responseDouble = 0;
    private static int count = 0;
    private static int docCount = 0;
    private static int petCount = 0;
    private static boolean overweight;


    public static void run(){                          //this is where the flow of the program will go
        menu();
    }

    public static void main(String[] args) {            //This is the main method of the main class. This is the method that is executed in the console
        try {
            run();
        }
        catch (Exception e){
            System.out.println("Something went wrong, please restart the program.");        //This try catch statement displays an error message when the program encounters an unexpected error
        }
    }
/*-------------------------------------------------------------------------------------------------------------------------------------------
                                        Doctor Methods
-------------------------------------------------------------------------------------------------------------------------------------------*/
    private static void doctorDec1() {                   //This is the method that asks the user for the first doctors name and specialisation of the doctor and
        System.out.println("What is the name of the doctor?");          //and stores it as an instance of the doctor class
        response = kb.nextLine();
        while (response.equalsIgnoreCase(d2.getName())){
            System.out.println("A doctor with that anme already exists, enter a different name");
            response = kb.nextLine();
        }
        d1.setName(response.toLowerCase());
        System.out.println("What is the specialisation of Dr. " + d1.getName() + "?");
        response = kb.nextLine();
        boolean docSpec1 = false;
        while (docSpec1 == false){
            if (response.equalsIgnoreCase("dog")){
                docSpec1 = true;
            }
            else if (response.equalsIgnoreCase("cat")){
                docSpec1 = true;
            }
            else{
                docSpec1 = false;
                System.out.println("Specialisation must be either dog or cat, try again");
                response = kb.nextLine();
            }
        }
        d1.setSpecialisation(response);
    }

    private static void doctorDec2(){                   //This is the method that asks the user for the second doctors name and specialisation
        System.out.println("What is the name of the doctor?");          //and stores it as a second instance of the doctor class
        while (response.equalsIgnoreCase(d1.getName())){
            System.out.println("A doctor with that anme already exists, enter a different name");
            response = kb.nextLine();
        }
        d2.setName(response.toLowerCase());
        System.out.println("What is the specialisation of Dr. " + d2.getName() + "?");
        response = kb.nextLine();
        boolean docSpec2 = false;
        while (docSpec2 == false){                      //This section is present in both doctor declaration methods and checks that the specialisation input
            if (response.equalsIgnoreCase("dog")){      //by the user is either cat or dog.
                docSpec2 = true;
            }
            else if (response.equalsIgnoreCase("cat")){
                docSpec2 = true;
            }
            else{
                docSpec2 = false;
                System.out.println("Specialisation must be either dog or cat, try again");
                response = kb.nextLine();
            }
        }
        d2.setSpecialisation(response);
    }

    private static void doctorFlow(){                   //This is the method that puts the doctor declaration methods in order.
        if (docCount == 1){
            doctorDec2();
        }
        else if (docCount == 0){
            doctorDec1();
            docCount = 1;
        }
        else{
            System.out.println("maximum amount of doctors reached.");
            System.out.println("Please remove a doctor before adding a new one.");
        }
    }

    /*private static void doctorDel(){                    //This is the method that is used to delete a doctor
        System.out.println("What doctor do you wish to remove?");
        System.out.println("1: " + d1.getName());
        System.out.println("2: " + d2.getName());
        responseInt = Integer.parseInt(kb.nextLine());

        switch (responseInt){                                   //This switch allows the user to select which doctor they would like to delete
            case 1: d1.doctorDel();
            docCount = 0;
            break;
            case 2: d2.doctorDel();
            docCount = 1;
            break;
            default:
                System.out.println(responseInt + " is not a valid response, please enter either 2 or 1.");
        }
    }*/

    private static void doctorDel(){
        System.out.println("What doctor would you like to delete?");
        response = kb.nextLine();
        if (response.equalsIgnoreCase(d1.getName())){
            d1.doctorDel();
        }
        else if (response.equalsIgnoreCase(d2.getName())){
            d2.doctorDel();
        }
        else {
            System.out.println("doctor does not exist");
        }
    }



    private static void doctorRet1(){                    //This is the method that is used to return all the information about the doctors
        System.out.println("Doctor 1 name: " + d1.getName() + ", Specialisation: " + d1.getSpecialisation());

    }

    private static void doctorRet2(){                    //This is the method that is used to return all the information
        System.out.println("Doctor name: " + d2.getName() + ", Specialisation: " + d2.getSpecialisation());

    }

    private static void docList(){
        System.out.println("There are " + docCount + 1 + " doctors in the system");
        System.out.println("they are: ");
        if (d1.getName().equalsIgnoreCase("none1") && d2.getName().equalsIgnoreCase("none2")){
            System.out.println("no doctors input");
        }
        else if (docCount == 1) {
            doctorRet1();
        }
        else{
            doctorRet1();
            doctorRet2();
        }

    }

/*-------------------------------------------------------------------------------------------------------------------------------------------
                                    Pet Methods
-------------------------------------------------------------------------------------------------------------------------------------------*/
    private static void petDec1(){
        System.out.println("What is the name of pet 1?");
        response = kb.nextLine();
        while (response.equalsIgnoreCase(p2.getName()) || response.equalsIgnoreCase(p3.getName()) || response.equalsIgnoreCase(p4.getName())){
            System.out.println("That pet name already exists in the database, enter a different name.");
            response = kb.nextLine();
        }
        p1.setName(response.toLowerCase());
        System.out.println("Is the pet and cat or a dog?");
        response = kb.nextLine();
        boolean pet1Check1 = false;
        while (pet1Check1 == false) {
            if (response.equalsIgnoreCase("cat") || response.equalsIgnoreCase("dog")) {
                pet1Check1 = true;
            }
            else{
                pet1Check1 = false;
                System.out.println("That is not a valid type of pet, please try again");
                response = kb.nextLine();
            }
        }
        p1.setType(response);
        System.out.println("What is the age of the pet?");
        responseInt = Integer.parseInt(kb.nextLine());
        while (responseInt < 0){
            System.out.println("Age cannot be below zero, try again.");
            responseInt = Integer.parseInt(kb.nextLine());
        }
        p1.setAge(responseInt);
        System.out.println("What is the size of the pet?");
        response = kb.nextLine();
        boolean pet1Check2 = false;
        while (pet1Check2 == false) {
            if (response.equalsIgnoreCase("large") || response.equalsIgnoreCase("medium") || response.equalsIgnoreCase("small")) {
                pet1Check2 = true;
            }
            else{
                pet1Check2 = false;
                System.out.println("That is not a valid size of pet, please try again");
                response = kb.nextLine();
            }
        }
        p1.setSize(response);
        System.out.println("What is the weight of the pet?");
        responseDouble = Double.parseDouble(kb.nextLine());
        while (responseDouble < 0){
            System.out.println("Weight of a pet cannot be below zero, try again");
            responseDouble = Double.parseDouble(kb.nextLine());
        }
        p1.setWeight(responseDouble);
        System.out.println("What doctor is looking after this pet?");
        response = kb.nextLine();
        boolean pet1Check3 = false;
        while (pet1Check3 == false){
            if (response.equalsIgnoreCase(d1.getName())){
                if (p1.getType().equalsIgnoreCase(d1.getSpecialisation())){
                    pet1Check3 = true;
                }
                else{
                    System.out.println("Doctor does not have correct specialisation");
                    menu();
                }

            }
            else if (response.equalsIgnoreCase(d2.getName())){
                if (p1.getType().equalsIgnoreCase(d2.getSpecialisation())){
                    pet1Check3 = true;
                }
                else{
                    System.out.println("Doctor does not have correct specialisation");
                    menu();
                }
            }
            else{
                System.out.println(response + " is not a valid doctor, try again");
                pet1Check3 = false;
                response = kb.nextLine();
            }
        }
        p1.setDoctor(response);

    }

//----------------------------------------------------------------------------
//----------------------------------------------------------------------------

    private static void petDec2(){
        System.out.println("What is the name of pet 1?");
        response = kb.nextLine();
        while (response.equalsIgnoreCase(p1.getName()) || response.equalsIgnoreCase(p3.getName()) || response.equalsIgnoreCase(p4.getName())){
            System.out.println("That pet name already exists in the database, enter a different name.");
            response = kb.nextLine();
        }
        p2.setName(response.toLowerCase());
        System.out.println("Is the pet and cat or a dog?");
        response = kb.nextLine();
        boolean pet2Check1 = false;
        while (pet2Check1 == false) {
            if (response.equalsIgnoreCase("cat") || response.equalsIgnoreCase("dog")) {
                pet2Check1 = true;
            }
            else{
                pet2Check1 = false;
                System.out.println("That is not a valid type of pet, please try again");
                response = kb.nextLine();
            }
        }
        p2.setType(response);
        System.out.println("What is the age of the pet?");
        responseInt = Integer.parseInt(kb.nextLine());
        while (responseInt < 0){
            System.out.println("Age cannot be below zero, try again.");
            responseInt = Integer.parseInt(kb.nextLine());
        }
        p2.setAge(responseInt);
        System.out.println("What is the size of the pet?");
        response = kb.nextLine();
        boolean pet2Check2 = false;
        while (pet2Check2 == false) {
            if (response.equalsIgnoreCase("large") || response.equalsIgnoreCase("medium") || response.equalsIgnoreCase("small")) {
                pet2Check2 = true;
            }
            else{
                pet2Check2 = false;
                System.out.println("That is not a valid size of pet, please try again");
                response = kb.nextLine();
            }
        }
        p2.setSize(response);
        System.out.println("What is the weight of the pet?");
        responseDouble = Double.parseDouble(kb.nextLine());
        while (responseDouble < 0){
            System.out.println("Weight of a pet cannot be below zero, try again");
            responseDouble = Double.parseDouble(kb.nextLine());
        }
        p2.setWeight(responseDouble);
        System.out.println("What doctor is looking after this pet?");
        response = kb.nextLine();
        boolean pet2Check3 = false;
        while (pet2Check3 == false){
            if (response.equalsIgnoreCase(d1.getName())){
                if (p2.getType().equalsIgnoreCase(d1.getSpecialisation())){
                    pet2Check3 = true;
                }
                else{
                    System.out.println("Doctor does not have correct specialisation");
                    menu();
                }

            }
            else if (response.equalsIgnoreCase(d2.getName())){
                if (p2.getType().equalsIgnoreCase(d2.getSpecialisation())){
                    pet2Check3 = true;
                }
                else{
                    System.out.println("Doctor does not have correct specialisation");
                    menu();
                }
            }
            else{
                System.out.println(response + " is not a valid doctor, try again");
                pet2Check3 = false;
                response = kb.nextLine();
            }
        }
        p2.setDoctor(response);

    }

//----------------------------------------------------------------------------
//----------------------------------------------------------------------------

    private static void petDec3(){
        System.out.println("What is the name of pet 1?");
        response = kb.nextLine();
        while (response.equalsIgnoreCase(p2.getName()) || response.equalsIgnoreCase(p1.getName()) || response.equalsIgnoreCase(p4.getName())){
            System.out.println("That pet name already exists in the database, enter a different name.");
            response = kb.nextLine();
        }
        p3.setName(response.toLowerCase());
        System.out.println("Is the pet and cat or a dog?");
        response = kb.nextLine();
        boolean pet3Check1 = false;
        while (pet3Check1 == false) {
            if (response.equalsIgnoreCase("cat") || response.equalsIgnoreCase("dog")) {
                pet3Check1 = true;
            }
            else{
                pet3Check1 = false;
                System.out.println("That is not a valid type of pet, please try again");
                response = kb.nextLine();
            }
        }
        p3.setType(response);
        System.out.println("What is the age of the pet?");
        responseInt = Integer.parseInt(kb.nextLine());
        while (responseInt < 0){
            System.out.println("Age cannot be below zero, try again.");
            responseInt = Integer.parseInt(kb.nextLine());
        }
        p3.setAge(responseInt);
        System.out.println("What is the size of the pet?");
        response = kb.nextLine();
        boolean pet3Check2 = false;
        while (pet3Check2 == false) {
            if (response.equalsIgnoreCase("large") || response.equalsIgnoreCase("medium") || response.equalsIgnoreCase("small")) {
                pet3Check2 = true;
            }
            else{
                pet3Check2 = false;
                System.out.println("That is not a valid size of pet, please try again");
                response = kb.nextLine();
            }
        }
        p3.setSize(response);
        System.out.println("What is the weight of the pet?");
        responseDouble = Double.parseDouble(kb.nextLine());
        while (responseDouble < 0){
            System.out.println("Weight of a pet cannot be below zero, try again");
            responseDouble = Double.parseDouble(kb.nextLine());
        }
        p3.setWeight(responseDouble);
        System.out.println("What doctor is looking after this pet?");
        response = kb.nextLine();
        boolean pet3Check3 = false;
        while (pet3Check3 == false){
            if (response.equalsIgnoreCase(d1.getName())){
                if (p3.getType().equalsIgnoreCase(d1.getSpecialisation())){
                    pet3Check3 = true;
                }
                else{
                    System.out.println("Doctor does not have correct specialisation");
                    menu();
                }

            }
            else if (response.equalsIgnoreCase(d2.getName())){
                if (p3.getType().equalsIgnoreCase(d2.getSpecialisation())){
                    pet3Check3 = true;
                }
                else{
                    System.out.println("Doctor does not have correct specialisation");
                    menu();
                }
            }
            else{
                System.out.println(response + " is not a valid doctor, try again");
                pet3Check3 = false;
                response = kb.nextLine();
            }
        }
        p3.setDoctor(response);

    }
//----------------------------------------------------------------------------
//----------------------------------------------------------------------------

    private static void petDec4(){
        System.out.println("What is the name of pet 1?");
        response = kb.nextLine();
        while (response.equalsIgnoreCase(p2.getName()) || response.equalsIgnoreCase(p3.getName()) || response.equalsIgnoreCase(p1.getName())){
            System.out.println("That pet name already exists in the database, enter a different name.");
            response = kb.nextLine();
        }
        p4.setName(response.toLowerCase());
        System.out.println("Is the pet and cat or a dog?");
        response = kb.nextLine();
        boolean pet4Check1 = false;
        while (pet4Check1 == false) {
            if (response.equalsIgnoreCase("cat") || response.equalsIgnoreCase("dog")) {
                pet4Check1 = true;
            }
            else{
                pet4Check1 = false;
                System.out.println("That is not a valid type of pet, please try again");
                response = kb.nextLine();
            }
        }
        p4.setType(response);
        System.out.println("What is the age of the pet?");
        responseInt = Integer.parseInt(kb.nextLine());
        while (responseInt < 0){
            System.out.println("Age cannot be below zero, try again.");
            responseInt = Integer.parseInt(kb.nextLine());
        }
        p4.setAge(responseInt);
        System.out.println("What is the size of the pet?");
        response = kb.nextLine();
        boolean pet4Check2 = false;
        while (pet4Check2 == false) {
            if (response.equalsIgnoreCase("large") || response.equalsIgnoreCase("medium") || response.equalsIgnoreCase("small")) {
                pet4Check2 = true;
            }
            else{
                pet4Check2 = false;
                System.out.println("That is not a valid size of pet, please try again");
                response = kb.nextLine();
            }
        }
        p4.setSize(response);
        System.out.println("What is the weight of the pet?");
        responseDouble = Double.parseDouble(kb.nextLine());
        while (responseDouble < 0){
            System.out.println("Weight of a pet cannot be below zero, try again");
            responseDouble = Double.parseDouble(kb.nextLine());
        }
        p4.setWeight(responseDouble);
        System.out.println("What doctor is looking after this pet?");
        response = kb.nextLine();
        boolean pet4Check3 = false;
        while (pet4Check3 == false){
            if (response.equalsIgnoreCase(d1.getName())){
                if (p4.getType().equalsIgnoreCase(d1.getSpecialisation())){
                    pet4Check3 = true;
                }
                else{
                    System.out.println("Doctor does not have correct specialisation");
                    menu();
                }

            }
            else if (response.equalsIgnoreCase(d2.getName())){
                if (p4.getType().equalsIgnoreCase(d2.getSpecialisation())){
                    pet4Check3 = true;
                }
                else{
                    System.out.println("Doctor does not have correct specialisation");
                    menu();
                }
            }
            else{
                System.out.println(response + " is not a valid doctor, try again");
                pet4Check3 = false;
                response = kb.nextLine();
            }
        }
        p4.setDoctor(response);

    }


    /* private static void petDel(){
        System.out.println("What pet would you like to delete?");
        System.out.println("1: " + p1.getName());
        System.out.println("2: " + p2.getName());
        System.out.println("3: " + p3.getName());
        System.out.println("4: " + p4.getName());
        responseInt = Integer.parseInt(kb.nextLine());
        switch (responseInt){
            case 1: petDel1();
            break;
            case 2: petDel2();
            break;
            case 3: petDel3();
            break;
            case 4: petDel4();
            break;
            default:
                System.out.println(responseInt + " is not a valid input.");

        }
    }*/

    private static void petDel(){
        System.out.println("What pet would you like to delete?");
        response = kb.nextLine();
        if (response.equalsIgnoreCase(p1.getName())){
            petDel1();
        }
        else if (response.equalsIgnoreCase(p2.getName())){
            petDel2();
        }
        else if (response.equalsIgnoreCase(p3.getName())){
            petDel3();
        }
        else if (response.equalsIgnoreCase(p4.getName())){
            petDel4();
        }
        else{
            System.out.println("pet with name " + response + " does not exist.");
        }
    }

    public static void petDel1(){
        p1.setType("none");
        p1.setSize("none");
        p1.setWeight(0);
        p1.setName("none1");
        p1.setDoctor("none");
        p1.setAge(0);
        petCount = 0;
    }

    public static void petDel2(){
        p2.setType("None2");
        p2.setSize("none");
        p2.setWeight(0);
        p2.setName("none2");
        p2.setDoctor("none");
        p2.setAge(0);
        petCount = 1;
    }

    public static void petDel3(){
        p3.setType("none");
        p3.setSize("none");
        p3.setWeight(0);
        p3.setName("none3");
        p3.setDoctor("none");
        p3.setAge(0);
        petCount = 2;
    }

    public static void petDel4(){
        p4.setType("none");
        p4.setSize("none");
        p4.setWeight(0);
        p4.setName("none4");
        p4.setDoctor("none");
        p4.setAge(0);
        petCount = 3;
    }

    private static void petAddFlow(){
        if (petCount == 0){
            petDec1();
            petCount = 1;
        }
        else if (petCount == 1){
            petDec2();
            petCount = 2;
        }
        else if (petCount == 2){
            petDec3();
            petCount = 3;
        }
        else if (petCount == 3){
            petDec4();
            petCount = 4;
        }
    }

    private static void petOverweight(){

    }

    private static void petAnalysis1(){
        System.out.println("Pet Name: " + p1.getName());
        System.out.println("Pet Type: " + p1.getType());
        System.out.println("Pet Age: " + p1.getAge());
        System.out.println("Pet Size: " + p1.getSize());
        System.out.println("Pet Weight: " + p1.getWeight());
        System.out.println("Assigned Doctor: " + p1.getDoctor());
        if (p1.getType().equalsIgnoreCase("cat")) {
            if (p1.getSize().equalsIgnoreCase("small") && p1.getWeight() > 4) {
                System.out.println(p1.getName() + " is overweight");
            }
            else if (p1.getSize().equalsIgnoreCase("medium") && p1.getWeight() > 6){
                System.out.println(p1.getName() + " is overweight");
            }
            else if (p1.getSize().equalsIgnoreCase("large") && p1.getWeight() > 8){
                System.out.println(p1.getName() + " is overweight");
            }
            else{
                System.out.println(p1.getName() + " is not overweight");
            }
        }
        else if (p1.getType().equalsIgnoreCase("dog")){
            if (p1.getSize().equalsIgnoreCase("small") && p1.getWeight() > 6) {
                System.out.println(p1.getName() + " is overweight");
            }
            else if (p1.getSize().equalsIgnoreCase("medium") && p1.getWeight() > 9){
                System.out.println(p1.getName() + " is overweight");
            }
            else if (p1.getSize().equalsIgnoreCase("large") && p1.getWeight() > 12){
                System.out.println(p1.getName() + " is overweight");
            }
            else{
                System.out.println(p1.getName() + " is not overweight");
            }
        }


    }

    private static void petAnalysis2(){

        System.out.println("Pet Name: " + p2.getName());
        System.out.println("Pet Type: " + p2.getType());
        System.out.println("Pet Age: " + p2.getAge());
        System.out.println("Pet Size: " + p2.getSize());
        System.out.println("Pet Weight: " + p2.getWeight());
        System.out.println("Assigned Doctor: " + p2.getDoctor());
        if (p2.getType().equalsIgnoreCase("cat")) {
            if (p2.getSize().equalsIgnoreCase("small") && p2.getWeight() > 4) {
                System.out.println(p2.getName() + " is overweight");
            }
            else if (p2.getSize().equalsIgnoreCase("medium") && p2.getWeight() > 6){
                System.out.println(p2.getName() + " is overweight");
            }
            else if (p2.getSize().equalsIgnoreCase("large") && p2.getWeight() > 8){
                System.out.println(p2.getName() + " is overweight");
            }
            else{
                System.out.println(p2.getName() + " is not overweight");
            }
        }
        else if (p2.getType().equalsIgnoreCase("dog")){
            if (p2.getSize().equalsIgnoreCase("small") && p2.getWeight() > 6) {
                System.out.println(p2.getName() + " is overweight");
            }
            else if (p2.getSize().equalsIgnoreCase("medium") && p2.getWeight() > 9){
                System.out.println(p2.getName() + " is overweight");
            }
            else if (p2.getSize().equalsIgnoreCase("large") && p2.getWeight() > 12){
                System.out.println(p2.getName() + " is overweight");
            }
            else{
                System.out.println(p2.getName() + " is not overweight");
            }
        }
    }

    private static void petAnalysis3(){

        System.out.println("Pet Name: " + p3.getName());
        System.out.println("Pet Type: " + p3.getType());
        System.out.println("Pet Age: " + p3.getAge());
        System.out.println("Pet Size: " + p3.getSize());
        System.out.println("Pet Weight: " + p3.getWeight());
        System.out.println("Assigned Doctor: " + p3.getDoctor());
        if (p3.getType().equalsIgnoreCase("cat")) {
            if (p3.getSize().equalsIgnoreCase("small") && p3.getWeight() > 4) {
                System.out.println(p2.getName() + " is overweight");
            }
            else if (p3.getSize().equalsIgnoreCase("medium") && p3.getWeight() > 6){
                System.out.println(p3.getName() + " is overweight");
            }
            else if (p3.getSize().equalsIgnoreCase("large") && p3.getWeight() > 8){
                System.out.println(p3.getName() + " is overweight");
            }
            else{
                System.out.println(p3.getName() + " is not overweight");
            }
        }
        else if (p3.getType().equalsIgnoreCase("dog")){
            if (p3.getSize().equalsIgnoreCase("small") && p3.getWeight() > 6) {
                System.out.println(p3.getName() + " is overweight");
            }
            else if (p3.getSize().equalsIgnoreCase("medium") && p3.getWeight() > 9){
                System.out.println(p3.getName() + " is overweight");
            }
            else if (p3.getSize().equalsIgnoreCase("large") && p3.getWeight() > 12){
                System.out.println(p3.getName() + " is overweight");
            }
            else{
                System.out.println(p3.getName() + " is not overweight");
            }
        }
    }

    private static void petAnalysis4(){

        System.out.println("Pet Name: " + p4.getName());
        System.out.println("Pet Type: " + p4.getType());
        System.out.println("Pet Age: " + p4.getAge());
        System.out.println("Pet Size: " + p4.getSize());
        System.out.println("Pet Weight: " + p4.getWeight());
        System.out.println("Assigned Doctor: " + p4.getDoctor());
        if (p4.getType().equalsIgnoreCase("cat")) {
            if (p4.getSize().equalsIgnoreCase("small") && p4.getWeight() > 4) {
                System.out.println(p4.getName() + " is overweight");
            }
            else if (p4.getSize().equalsIgnoreCase("medium") && p4.getWeight() > 6){
                System.out.println(p4.getName() + " is overweight");
            }
            else if (p4.getSize().equalsIgnoreCase("large") && p4.getWeight() > 8){
                System.out.println(p4.getName() + " is overweight");
            }
            else{
                System.out.println(p4.getName() + " is not overweight");
            }
        }
        else if (p4.getType().equalsIgnoreCase("dog")){
            if (p4.getSize().equalsIgnoreCase("small") && p4.getWeight() > 6) {
                System.out.println(p4.getName() + " is overweight");
            }
            else if (p4.getSize().equalsIgnoreCase("medium") && p4.getWeight() > 9){
                System.out.println(p4.getName() + " is overweight");
            }
            else if (p4.getSize().equalsIgnoreCase("large") && p4.getWeight() > 12){
                System.out.println(p4.getName() + " is overweight");
            }
            else{
                System.out.println(p4.getName() + " is not overweight");
            }
        }
    }

    private static void petAnalysisFlow(){
        System.out.println("What pet would you like to analyse?");
            System.out.println("1: " + p1.getName());
            System.out.println("2: " + p2.getName());
            System.out.println("3: " + p3.getName());
            System.out.println("4: " + p4.getName());
            responseInt = Integer.parseInt(kb.nextLine());
                switch (responseInt){
                    case 1: petAnalysis1();
                    break;
                    case 2: petAnalysis2();
                    break;
                    case 3: petAnalysis3();
                    break;
                    case 4: petAnalysis4();
                    break;
                    default:
                        System.out.println("That is not a valid input, try again.");
                }
        }


/*-------------------------------------------------------------------------------------------------------------------------------------------
                                    Menu
-------------------------------------------------------------------------------------------------------------------------------------------*/
    private static void menu (){
        while (responseInt != 0){
            System.out.println("What would you like to do?");
            System.out.println("Please type the number corresponding to the action you would like to take: ");
            System.out.println("1: New Doctor");
            System.out.println("2: New Pet");
            System.out.println("3: Remove Doctor");
            System.out.println("4: Remove Pet");
            System.out.println("5: Pet List and Analysis");
            System.out.println("6: Doctor List");
            System.out.println("0: Exit");
            responseInt = Integer.parseInt(kb.nextLine());
            switch (responseInt) {
                case 1: doctorFlow();
                break;
                case 2: petAddFlow();
                break;
                case 3: doctorDel();
                break;
                case 4: petDel();
                break;
                case 5: petAnalysisFlow();
                break;
                case 6: docList();
                break;
                case 0: System.exit(0);
                break;
                default:
                    System.out.println(responseInt + " is not a valid input, try again.");
            }
        }
    }



}
