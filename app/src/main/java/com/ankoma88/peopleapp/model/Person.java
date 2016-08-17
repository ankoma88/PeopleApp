package com.ankoma88.peopleapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ankoma88 on 17.08.16.
 */
public class Person implements Parcelable {

    private String firstName;
    private String lastname;
    private String sex;
    private String portrait;
    private String birth;
    private String birthPlace;
    private String birthLatitude;
    private String birthLongitude;
    private String death;
    private String deathPlace;
    private String deathLatitude;
    private String deathLongitude;


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthLatitude() {
        return birthLatitude;
    }

    public void setBirthLatitude(String birthLatitude) {
        this.birthLatitude = birthLatitude;
    }


    public String getBirthLongitude() {
        return birthLongitude;
    }


    public void setBirthLongitude(String birthLongitude) {
        this.birthLongitude = birthLongitude;
    }

    public String getDeath() {
        return death;
    }


    public void setDeath(String death) {
        this.death = death;
    }


    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) {
        this.deathPlace = deathPlace;
    }


    public String getDeathLatitude() {
        return deathLatitude;
    }


    public void setDeathLatitude(String deathLatitude) {
        this.deathLatitude = deathLatitude;
    }


    public String getDeathLongitude() {
        return deathLongitude;
    }


    public void setDeathLongitude(String deathLongitude) {
        this.deathLongitude = deathLongitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null)
            return false;
        if (lastname != null ? !lastname.equals(person.lastname) : person.lastname != null)
            return false;
        return birth != null ? birth.equals(person.birth) : person.birth == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sex='" + sex + '\'' +
                ", portrait='" + portrait + '\'' +
                ", birth='" + birth + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthLatitude='" + birthLatitude + '\'' +
                ", birthLongitude='" + birthLongitude + '\'' +
                ", death='" + death + '\'' +
                ", deathPlace='" + deathPlace + '\'' +
                ", deathLatitude='" + deathLatitude + '\'' +
                ", deathLongitude='" + deathLongitude + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastname);
        parcel.writeString(sex);
        parcel.writeString(portrait);
        parcel.writeString(birth);
        parcel.writeString(birthPlace);
        parcel.writeString(birthLatitude);
        parcel.writeString(birthLongitude);
        parcel.writeString(death);
        parcel.writeString(deathPlace);
        parcel.writeString(deathLatitude);
        parcel.writeString(deathLongitude);
    }

    protected Person(Parcel in) {
        firstName = in.readString();
        lastname = in.readString();
        sex = in.readString();
        portrait = in.readString();
        birth = in.readString();
        birthPlace = in.readString();
        birthLatitude = in.readString();
        birthLongitude = in.readString();
        death = in.readString();
        deathPlace = in.readString();
        deathLatitude = in.readString();
        deathLongitude = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
