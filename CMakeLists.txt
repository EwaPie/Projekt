cmake_minimum_required(VERSION 3.12)
project(Projekt)

set(CMAKE_CXX_STANDARD 14)

include_directories(application/Hall)
include_directories(application/Hall/Model)
include_directories(application/Hall/Reservation)
include_directories(application/Hall/Reservation/ReservationData)
include_directories(application/Hall/ReservationList)
include_directories(application/Hall/ReservationList/Model)
include_directories(application/Hall/Table)
include_directories(application/MenuItem)
include_directories(application/MenuItem/Dish)
include_directories(application/MenuItem/Drink)
include_directories(User/Exception)
include_directories(User/Model)
include_directories(User/Repository)
include_directories(User/Service)
include_directories(User/Validator)

add_executable(Projekt
        application/Hall/Model/Hall.cpp
        application/Hall/Model/Hall.h
        application/Hall/Reservation/ReservationData/ReservationData.cpp
        application/Hall/Reservation/ReservationData/ReservationData.h
        application/Hall/Reservation/Reservation.cpp
        application/Hall/Reservation/Reservation.h
        application/Hall/ReservationList/Model/ReservationListElement.cpp
        application/Hall/ReservationList/Model/ReservationListElement.h
        application/Hall/ReservationList/ReservationList.cpp
        application/Hall/ReservationList/ReservationList.h
        application/Hall/Table/Table.cpp
        application/Hall/Table/Table.h
        application/Hall/HallManager.cpp
        application/Hall/HallManager.h
        application/MenuItem/Dish/Dish.cpp
        application/MenuItem/Dish/Dish.h
        application/MenuItem/Drink/Drink.cpp
        application/MenuItem/Drink/Drink.h
        application/MenuItem/MenuItem.cpp
        application/MenuItem/MenuItem.h
        GUI/Projekt/main.cpp
        Projekt/main.cpp
        User/Exception/CouldNotOpenFileException.h
        User/Exception/InvalidFilenameLengthException.h
        "User/Exception/PermissionDeniedException .h"
        User/Exception/UserIsNotLoggedException.h
        User/Exception/UserNameNotUniqueException.h
        User/Exception/UserWrongLengthException.h
        User/Model/ACL.cpp
        User/Model/ACL.h
        User/Model/User.cpp
        User/Model/User.h
        User/Repository/AbstractACLRepository.h
        User/Repository/AbstractUserRepository.h
        User/Repository/FileAclRepository.cpp
        User/Repository/FileAclRepository.h
        User/Repository/FileUserRepository.cpp
        User/Repository/FileUserRepository.h
        User/Service/UserService.cpp
        User/Service/UserService.h
        User/Validator/UsernameValidator.cpp
        User/Validator/UsernameValidator.h application/Report/Bill.cpp application/Report/Bill.h application/Report/BillType.h application/Report/StatisticService.h application/Report/BufferedStatisticService.cpp application/Report/BufferedStatisticService.h)
