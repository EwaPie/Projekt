//
// Created by Mateusz on 31.12.2018.
//

#pragma once


#include <string>
#include <ostream>

class ReservationData {
protected:
    int day;
    int month;
    int year;
    int hour;
    std::string firstName;
    std::string lastName;
    std::string phoneNumber;
    int numberOfPeople;
    int tableId;

public:
    int getDay() const;

    void setDay(int day);

    int getTableId() const;

    void setTableId(int tableId);

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

    const std::string &getFirstName() const;

    /**
     *
     * @param string firstName
     */
    void setFirstName(const std::string &firstName);

    const std::string &getLastName() const;

    /**
     *
     * @param string lastName
     */
    void setLastName(const std::string &lastName);

    const std::string &getPhoneNumber() const;

    /**
     *
     * @param string phoneNumber
     */
    void setPhoneNumber(const std::string &phoneNumber);

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
     * @param int tableId
     */
    ReservationData(int day, int month, int year, int hour, const std::string &firstName, const std::string &lastName,
                    const std::string &phoneNumber, int numberOfPeople, int tableId);

    ReservationData();

    bool operator==(const ReservationData &rhs) const;

    friend std::ostream &operator<<(std::ostream &os, const ReservationData &reservationData);

    bool operator!=(const ReservationData &rhs) const;

    std::string toString();

};

