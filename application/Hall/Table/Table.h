//
// Created by Mateusz on 31.12.2018.
//

#ifndef RESTAURANT_TABLE_H
#define RESTAURANT_TABLE_H


class Table {
protected:
    int tableId;
    int numberOfSeats;
public:
    /**
     *
     * @param int tableId
     * @param int numberOfSeats
     */
    Table(int tableId, int numberOfSeats);

    /**
     *
     * @return int
     */
    int getNumberOfSeats() const;

    /**
     *
     * @return int
     */
    int getTableId() const;

    /**
     *
     * @param int tableId
     */
    void setTableId(int tableId);

    /**
     *
     * @param int numberOfSeats
     */
    void setNumberOfSeats(int numberOfSeats);

    bool operator==(const Table &rhs) const;

    bool operator!=(const Table &rhs) const;
};


#endif //RESTAURANT_TABLE_H
