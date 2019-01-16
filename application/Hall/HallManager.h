
#ifndef RESTAURANT_HALLMANAGER_H
#define RESTAURANT_HALLMANAGER_H

#include <list>
#include "Model/Hall.h"
#include "ReservationList/ReservationList.h"
#include "Reservation/Reservation.h"
#include "Table/Table.h"

using namespace std;

class HallManager {
private:
    Hall *hall;
public:

    /**
     *
     * @param Hall** hall
     */
    explicit HallManager(Hall *hall);

    /**
     *
     * @return list<Table>
     */
    list<Table*> *getTableList();

    /**
     *
     * @param Table* table
     * @return int
     */
    int addTable(Table * table);

    /**
     *
     * @param Table* table
     * @return int
     */
    int deleteTable(Table * table);

    /**
     *
     * @param Reservation** reservation
     * @return int
     */
    int addReservation(Reservation *reservation);

    /**
     *
     * @param Reservation** reservation
     * @return int
     */
    int deleteReservation(Reservation **reservation);

    /**
     *
     * @return Hall*
     */
    Hall* getHall();

    /**
     *
     * @return ReservationList*
     */
    ReservationList* getReservationList();

    virtual ~HallManager();
};


#endif //RESTAURANT_HALLMANAGER_H
