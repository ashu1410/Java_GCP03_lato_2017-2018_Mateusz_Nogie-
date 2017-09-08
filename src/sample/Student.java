package sample;


import javafx.beans.property.*;


/**
 * Created by Ash on 31.08.2017.
 */
public class Student
{
    private SimpleDoubleProperty grade= new SimpleDoubleProperty();
    private SimpleStringProperty name=new SimpleStringProperty();
    private SimpleStringProperty surname=new SimpleStringProperty();
    private SimpleIntegerProperty age=new SimpleIntegerProperty();



    public String getName()
    {
        return this.name.get();
    }

    public StringProperty getNameProp()
    {
        return this.name;
    }

    public void setName( String _name )
    {
        this.name.set(_name);
    }

    public String getSurname()
    {
        return this.surname.get();
    }

    public StringProperty getSurnameProp()
    {
        return this.surname;
    }

    public void setSurname( String _surname )
    {
        this.surname.set(_surname);
    }

    public int getAge()
    {
        return this.age.get();
    }

    public IntegerProperty getAgeProp (){
        return this.age;
}

    public void setAge( int _age )
    {
        this.age.set(_age);
    }

    public double getGrade()
    {
        return this.grade.get();
    }

    public DoubleProperty getGradeProp() { return this.grade;}

    public void setGrade( double _grade )
    {
        this.grade.set(_grade);
    }

    Student(){}

    Student(String name,String surname, double grade, int age){
        setName(name);
        setSurname(surname);
        setGrade(grade);
        setAge(age);
    }


    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 53 * hash + (getName() != null ? getName().hashCode() : 0);
        hash = 53 * hash + (getSurname() != null ? getSurname().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        if ( this == object )
            return true;

        if ( object == null )
            return false;

        if ( getClass() != object.getClass() )
            return false;

        Student other = (Student) object;

        if ( age != other.age )
            return false;

        if ( name == null )
        {
            if ( other.name != null )
                return false;
        }
        else
        if ( !name.equals( other.name ) )
            return false;

        if ( surname == null )
        {
            if ( other.surname != null )
                return false;
        }
        else
        if ( !surname.equals( other.surname) )
            return false;


        if (object.hashCode()!=other.hashCode())
        {
            return false;
        }

        return true;
    }

}
