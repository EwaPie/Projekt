//
// Created by Mateusz on 31.12.2018.
//

#include "ReservationData.h"

ReservationData::ReservationData(int day, int month, int year, int hour, const string &firstName, const string &lastName,
                                 const string &phoneNumber, int numberOfPeople) : day(day), month(month), year(year),
                                                                                  hour(hour), firstName(firstName),
                                                                                  lastName(lastName),
                                                                                  phoneNumber(phoneNumber),
                                                                                  numberOfPeople(numberOfPeople) {}

int ReservationData::getDay() const {
    return day;
}

void ReservationData::setDay(int day) {
    ReservationData::day = day;
}

int ReservationData::getMonth() const {
    return month;
}

void ReservationData::setMonth(int month) {
    ReservationData::month = month;
}

int ReservationData::getYear() const {
    return year;
}

void ReservationData::setYear(int year) {
    ReservationData::year = year;
}

const string &ReservationData::getFirstName() const {
    return firstName;
}

void ReservationData::setFirstName(const string &firstName) {
    ReservationData::firstName = firstName;
}

const string &ReservationData::getLastName() const {
    return lastName;
}

void ReservationData::setLastName(const string &lastName) {
    ReservationData::lastName = lastName;
}

const string &ReservationData::getPhoneNumber() const {
    return phoneNumber;
}

void ReservationData::setPhoneNumber(const string &phoneNumber) {
    ReservationData::phoneNumber = phoneNumber;
}

int ReservationData::getNumberOfPeople() const {
    return numberOfPeople;
}

void ReservationData::setNumberOfPeople(int numberOfPeople) {
    ReservationData::numberOfPeople = numberOfPeople;
}

int ReservationData::getHour() const {
    return hour;
}

void ReservationData::setHour(int hour) {
    ReservationData::hour = hour;
}

bool ReservationData::operator==(const ReservationData &rhs) const {
    return day == rhs.day &&
           month == rhs.month &&
           year == rhs.year &&
           hour == rhs.hour &&
           firstName == rhs.firstName &&
           lastName == rhs.lastName &&
           phoneNumber == rhs.phoneNumber &&
           numberOfPeople == rhs.numberOfPeople;
}

bool ReservationData::operator!=(const ReservationData &rhs) const {
    return !(rhs == *this);
}

ostream &operator<<(ostream &os, const ReservationData &reservationData) {
    os << "day: " << reservationData.day << " month: " << reservationData.month << " year: " << reservationData.year
       << " hour: " << reservationData.hour << " firstName: " << reservationData.firstName << " lastName: "
       << reservationData.lastName << " phoneNumber: " << reservationData.phoneNumber << " numberOfPeople: "
       << reservationData.numberOfPeople;
    return os;
}

ReservationData::ReservationData() = default;
