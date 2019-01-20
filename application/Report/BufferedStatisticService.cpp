#include "BufferedStatisticService.h"


BufferedStatisticService::BufferedStatisticService() {
    maxBuffSize = DEFAULT_BUFF_SIZE;
    this->filePath = R"(.\statystyka.txt)";
}

BufferedStatisticService::~BufferedStatisticService() {
    if (!buff.empty()) {
        flush();
    }
}

bool BufferedStatisticService::addEvent(shared_ptr<Bill> event) {
    // Pobranie aktualnego czasu
    chrono::milliseconds ms = chrono::duration_cast<chrono::milliseconds>(
            chrono::system_clock::now().time_since_epoch());

    string eventLine = to_string(ms.count())
                       + " billType " + toString(event->getBillType())
                       + " amount " + to_string(event->getCurrentAmount())
                       + "\n";
    buff.push_back(eventLine);
    if (buff.size() == maxBuffSize) {
        flush();
    }
    return true;
}

void BufferedStatisticService::flush() {
    std::ofstream statisticFile(filePath, std::ios::app);
    for (const auto &it: buff) {
        statisticFile << it << endl;
    }
    buff.clear();
    statisticFile.close();
}

void BufferedStatisticService::setFilePath(string filePath) {
    this->filePath = std::move(filePath);
}

void BufferedStatisticService::setBuffSize(int newBuffSize) {
    this->maxBuffSize = newBuffSize;
}

vector<string> BufferedStatisticService::getBufferedEvents() {
    return buff;
}

