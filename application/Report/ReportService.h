//
// Created by User on 2019-01-16.
//

#ifndef PROJEKT_REPORTSERVICE_H
#define PROJEKT_REPORTSERVICE_H

#include <string>
#include <ReportType.h>
#include <fstream>

using namespace std;

class ReportService {
private:
    string filePath = R"(.\statystyka.txt)";
public:
    string createFinancialReport(ReportType reportType, long from, long to);

    void setFilePath(const string &filePath);

    string getIncomeReport(long from, long to) const;
};


#endif //PROJEKT_REPORTSERVICE_H
