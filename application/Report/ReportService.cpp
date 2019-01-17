//
// Created by User on 2019-01-16.
//

#include "ReportService.h"

string ReportService::createFinancialReport(ReportType reportType, long from, long to) {
    switch (reportType) {
        case INCOME:
            return getIncomeReport(from, to);
        default:
            return "NIEOBSLUGIWANY TYP RAPORTU";
    }
}

string ReportService::getIncomeReport( long from, long to) const {
    ifstream file(filePath);
    string temp;
    int income = 0;
    string delimiterA = " ";
    while (getline(file, temp)) {

        size_t pos = 0;
        string element;

        // timestamp
        element = temp.substr(0, pos);
        unsigned long timestamp = stoul(element);
        if (timestamp < from || timestamp < to) {
            continue;
        }

        // typ rachunku -> label
        pos = temp.find(delimiterA);
        element = temp.substr(0, pos);
        temp.erase(0, pos + delimiterA.length());

        // typ rachunku -> wartosc
        pos = temp.find(delimiterA);
        element = temp.substr(0, pos);
        temp.erase(0, pos + delimiterA.length());

        // kwota rachuku -> label
        pos = temp.find(delimiterA);
        element = temp.substr(0, pos);
        temp.erase(0, pos + delimiterA.length());

        // kwota rachuku -> label
        pos = temp.find(delimiterA);
        element = temp.substr(0, pos);

        income += stoi(element);
    }
    return "Suma przychodow w zadanym okresie wyniosla : " + to_string(income);
}

void ReportService::setFilePath(const string &filePath) {
    ReportService::filePath = filePath;
}
