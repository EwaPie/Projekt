#pragma once

#include <string>
#include "ReportType.h"
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

