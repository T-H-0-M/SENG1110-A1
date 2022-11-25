public class Pet {
    //Thomas Bandy c3374048
    private String type;            //This stores the type of pet (cat or dog)
    private String size;            //This stores the size of the pet (s, m ,l)
    private String name;            //This stores the name of the pet
    private double weight;          //This stores the weight of the pet
    private int age;                //This stores the age of the pet
    private String doctor;          //This stores the name of the doctor assigned to the pet

    public void setType(String type){       //setter method for type
        this.type = type;
    }

    public String getType(){                //getter method for type
        return type;
    }

    public void setSize(String size){       //setter method for size
        this.size = size;
    }

    public String getSize(){                //getter method for size
        return size;
    }

    public void setName(String name){       //setter method for name
        this.name = name;
    }

    public String getName(){                //getter method for name
        return name;
    }

    public void setWeight(double weight){   //setter method for weight
        this.weight = weight;
    }

    public double getWeight (){             //getter method for weight
        return weight;
    }

    public void setAge (int age){           //setter method for age
        this.age = age;
    }

    public int getAge (){                   //getter method for age
        return age;
    }

    public void setDoctor(String doctor) {  //setter method for doctor
        this.doctor = doctor;
    }

    public String getDoctor() {             //getter method for doctor
        return doctor;
    }

}
