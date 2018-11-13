import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: startPage
    width: 640
    height: 480

    GridLayout {
        x: 79
        y: 33
        width: 495
        height: 359
        rowSpacing: 9
        columnSpacing: 18
        rows: 3
        columns: 2


        Button {
            id: hall_button
            x: 0
            y: 211
            width: 236
            height: 60
            text: qsTr("Sala")
            font.pointSize: 12
            Layout.fillHeight: true
            Layout.fillWidth: true
            z: 1
        }

        Button {
            id: orders_button
            width: 236
            height: 60
            text: qsTr("Zamówienia")
            font.pointSize: 12
            Layout.fillHeight: true
            Layout.fillWidth: true
        }


        Button {
            id: discounts_button
            width: 236
            height: 60
            text: qsTr("Rabaty")
            font.pointSize: 12
            Layout.fillHeight: true
            Layout.fillWidth: true
        }

        Button {
            id: menu_button
            width: 236
            height: 60
            text: qsTr("Menu")
            font.pointSize: 12
            Layout.fillHeight: true
            Layout.fillWidth: true
        }

        Button {
            id: users_button
            width: 236
            height: 60
            text: qsTr("Użytkownicy")
            font.pointSize: 12
            Layout.fillHeight: true
            Layout.fillWidth: true
        }

        Button {
            id: statisticks_button
            width: 236
            height: 60
            text: qsTr("Statystyki")
            font.pointSize: 12
            Layout.fillHeight: true
            Layout.fillWidth: true
        }
    }
}





















