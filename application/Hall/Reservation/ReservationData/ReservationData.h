//
// Created by Mateusz on 31.12.2018.
//

#pragma once


#include <string>
#include <ostream>

using namespace std;

class ReservationData {
protected:
    int day;
    int month;
    int year;
    int hour;
    string firstName;
    string lastName;
    string phoneNumber;
    int numberOfPeople;

public:
    int getDay() const;

    void setDay(int day);

    int getMonth() const;

    /**
     *
     * @param int month
     */
    void setMonth(int month);

    int getYear() const;

    /**
     *
     * @param int year
     */
    void setYear(int year);

    const string &getFirstName() const;

    /**
     *
     * @param string firstName
     */
    void setFirstName(const string &firstName);

    const string &getLastName() const;

    /**
     *
     * @param string lastName
     */
    void setLastName(const string &lastName);

    const string &getPhoneNumber() const;

    /**
     *
     * @param string phoneNumber
     */
    void setPhoneNumber(const string &phoneNumber);

    int getNumberOfPeople() const;

    /**
     *
     * @param int numberOfPeople
     */
    void setNumberOfPeople(int numberOfPeople);

    int getHour() const;

    /**
     *
     * @param int hour
     */
    void setHour(int hour);

    /**
     *
     * @param int day
     * @param int month
     * @param int year
     * @param int hour
     * @param string firstName
     * @param string lastName
     * @param string phoneNumber
     * @param int numberOfPeople
     */
    ReservationData(int day, int month, int year, int hour, const string &firstName, const string &lastName,
                    const string &phoneNumber, int numberOfPeople);

    ReservationData();

    bool operator==(const ReservationData &rhs) const;

    friend ostream &operator<<(ostream &os, const ReservationData &reservationData);

    bool operator!=(const ReservationData &rhs) const;

};

