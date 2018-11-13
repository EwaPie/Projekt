import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: startPage
    width: 640
    height: 480

    RowLayout {
        id: rowLayout
        x: 0
        width: 640
        height: 154
        anchors.top: parent.top
        anchors.topMargin: 131
        anchors.horizontalCenter: parent.horizontalCenter
        transformOrigin: Item.Center
        antialiasing: false


        Button {
            id: hall_button
            x: 0
            y: 211
            text: qsTr("Sala")
            Layout.fillWidth: true
            z: 1
        }

        Button {
            id: orders_button
            text: qsTr("Zamówienia")
            Layout.fillWidth: true
        }


        Button {
            id: discounts_button
            text: qsTr("Rabaty")
            Layout.fillWidth: true
        }

        Button {
            id: menu_button
            text: qsTr("Menu")
            Layout.fillWidth: true
        }

        Button {
            id: users_button
            text: qsTr("Użytkownicy")
            Layout.fillWidth: true
        }

        Button {
            id: statisticks_button
            text: qsTr("Statystyki")
            Layout.fillHeight: false
            Layout.fillWidth: true
        }
    }
}




















/*##^## Designer {
    D{i:1;anchors_height:154;anchors_width:640;anchors_x:0;anchors_y:131}
}
 ##^##*/
