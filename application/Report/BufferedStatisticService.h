//
// Created by User on 2019-01-13.
//

#ifndef PROJEKT_BUFFEREDSTATISTICSERVICE_H
#define PROJEKT_BUFFEREDSTATISTICSERVICE_H

#include "StatisticService.h"
#include <fstream>
#include <iostream>
#include <chrono>

using namespace std;

class BufferedStatisticService : public StatisticService {
private:
    const int DEFAULT_BUFF_SIZE = 10;
    int maxBuffSize;

    vector<string> buff;
    string filePath;

public:

    BufferedStatisticService();

    ~BufferedStatisticService() override;

    bool addEvent(shared_ptr<Bill> event) override;

    void flush();

    void setFilePath(string filePath);

    void setBuffSize(int newBuffSize);

    vector <string> getBufferedEvents();
};


#endif //PROJEKT_BUFFEREDSTATISTICSERVICE_H
