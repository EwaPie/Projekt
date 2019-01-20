#pragma once

#include "StatisticService.h"
#include <fstream>
#include <iostream>
#include <chrono>

//using namespace std;

class BufferedStatisticService : public StatisticService {
private:
    const int DEFAULT_BUFF_SIZE = 10;
    int maxBuffSize;

    std::vector<std::string> buff;
    string filePath;

public:

    BufferedStatisticService();

    ~BufferedStatisticService() override;

    bool addEvent(std::shared_ptr<Bill> event) override;

    void flush();

    void setFilePath(std::string filePath);

    void setBuffSize(int newBuffSize);

    std::vector <std::string> getBufferedEvents();
};

