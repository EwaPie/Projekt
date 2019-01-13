import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: discountsPage
    width: 800
    height: 680
    property alias toolButton: toolButton
    title: qsTr("Rabaty")

    header: ToolBar {
        id: maintoolbar
        RowLayout {
            anchors.fill: parent
            ToolButton {
                id: toolButton
                text: qsTr("‹")
            }
        }
    }

    TabBar {
        id: tabBar
        width: 296
        height: 45
        currentIndex: 0

        TabButton {
            id: add_discount_tab
            x: 0
            y: 0
            width: 150
            height: 52
            text: qsTr("Dodaj rabat")
            font.pointSize: 9
        }

        TabButton {
            id: manage_discounts_tab
            x: 156
            y: 0
            width: 150
            height: 52
            text: qsTr("Zarządzaj rabatami")
            font.pointSize: 9
        }
    }

    StackLayout {
        id: discounts_view
        width: 800
        height: 680
        currentIndex: tabBar.currentIndex
        anchors.fill: parent

        Item {
            id: add_discout_view
            Layout.preferredHeight: 0
            Layout.preferredWidth: 0

            TextField {
                id: add_discount_name
                x: 115
                y: 168
                width: 570
                height: 60
                placeholderText: "Nazwa"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            TextField {
                id: add_discount_value
                x: 115
                y: 285
                width: 570
                height: 60
                placeholderText: "Wartość (w %)"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            Button {
                id: button
                x: 244
                y: 454
                width: 302
                height: 74
                text: qsTr("Dodaj")
                font.pointSize: 10
            }
        }

        Item {
            id: manage_discounts_view
            Layout.preferredHeight: 0
            Layout.preferredWidth: 0

            TextField {
                id: name_of_discount
                x: 115
                y: 216
                width: 570
                height: 60
                placeholderText: "Nazwa"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            TextField {
                id: value_of_discount
                x: 115
                y: 305
                width: 570
                height: 60
                placeholderText: "Wartość (w %)"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            Button {
                id: save_changes
                x: 63
                y: 466
                width: 190
                height: 90
                text: qsTr("Zapisz zmiany")
                font.pointSize: 10
            }

            Button {
                id: delete_button
                x: 529
                y: 466
                width: 190
                height: 90
                text: qsTr("Usuń")
                font.pointSize: 10
            }

            ComboBox {
                id: comboBox
                x: 115
                y: 110
                width: 570
                height: 60
                displayText: "Wybierz rabat"
            }
        }
    }
}
