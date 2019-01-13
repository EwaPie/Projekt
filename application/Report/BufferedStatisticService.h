//
// Created by User on 2019-01-13.
//

#ifndef PROJEKT_BUFFEREDSTATISTICSERVICE_H
#define PROJEKT_BUFFEREDSTATISTICSERVICE_H

#include "StatisticService.h"
#include <fstream>
#include <iostream>

using namespace std;

class BufferedStatisticService : StatisticService {
private:
    const int DEFAULT_BUFF_SIZE = 10;
    int maxBuffSize;

    list<string>* buff;
    string filePath;

public:

    BufferedStatisticService(string filePath);
    ~BufferedStatisticService();

    bool addEvent(Bill *event) override;

    void flush();

    void setFilePath(string filePath);

    void setBuffSize(int newBuffSize);

    list<string> *getBufferedEvent();
};


#endif //PROJEKT_BUFFEREDSTATISTICSERVICE_H
