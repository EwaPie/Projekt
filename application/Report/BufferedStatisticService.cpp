//

#include "BufferedStatisticService.h"

//
// Created by User on 2019-01-13.
BufferedStatisticService::BufferedStatisticService(string filePath) {
    maxBuffSize = DEFAULT_BUFF_SIZE;
    buff = new list<string>;
    this->filePath = filePath;
}

BufferedStatisticService::~BufferedStatisticService() {
    delete buff;
}

bool BufferedStatisticService::addEvent(Bill *event) {
    string eventLine =
            "billType;" + toString(event->getBillType()) + "amount;" + std::to_string(event->getCurrentAmount());
    buff->push_back(eventLine);
    if (buff->size() == maxBuffSize) {
        flush();
    }
    return true;
}

void BufferedStatisticService::flush() {
    std::ofstream statisticFile(filePath, std::ios::app);
    for (auto &it: *buff) {
        statisticFile << it << endl;
    }
    buff->clear();
    statisticFile.close();
}

void BufferedStatisticService::setFilePath(string filePath) {
    this->filePath = filePath;
}

void BufferedStatisticService::setBuffSize(int newBuffSize) {
    this->maxBuffSize = newBuffSize;
}

list<string> *BufferedStatisticService::getBufferedEvent() {
    return buff;
}

