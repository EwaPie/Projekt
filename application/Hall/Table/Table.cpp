//
// Created by Mateusz on 31.12.2018.
//

#include "Table.h"

Table::Table(int tableId, int numberOfSeats) : tableId(tableId), numberOfSeats(numberOfSeats) {}

int Table::getNumberOfSeats() const {
    return numberOfSeats;
}

void Table::setNumberOfSeats(int numberOfSeats) {
    Table::numberOfSeats = numberOfSeats;
}

int Table::getTableId() const {
    return tableId;
}

void Table::setTableId(int tableId) {
    Table::tableId = tableId;
}

bool Table::operator==(const Table &rhs) const {
    return tableId == rhs.tableId &&
           numberOfSeats == rhs.numberOfSeats;
}

bool Table::operator!=(const Table &rhs) const {
    return !(rhs == *this);
}
