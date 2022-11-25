import java.util.Locale;

//Thomas Bandy c3374048

public class Doctor {
    private String name;                                        //This is the variable that will store the nam eof the doctor.
    private String specialisation;                              //This is the specialisation of the doctor
    private boolean testSpec = false;

    public void setName(String name){                           //This is the setter method for the name of the doctor (setter methods gather a data for a variable from another class and assign it to a variable in an instance of this class)

        name.toLowerCase(Locale.ROOT);
        this.name = name;
    }

    public String getName(){                                    //This is the getter method for the name of the doctor (getter methods return the value of a variable in an instance of this class)
        return name;
    }

    public void setSpecialisation(String specialisation){       //setter method for specialisation of the doctor
        this.specialisation = specialisation;
    }

    public String getSpecialisation(){                          //getter method for specialisation of the doctor
        return specialisation;
    }

    public void doctorDel(){                                    //This is a method that deletes a doctor when called from the main class
        this.specialisation = "none";
        this.name = "none1";
    }
}
