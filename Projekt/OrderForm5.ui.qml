import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3
import Qt.labs.calendar 1.0

Page {
    id: menuPage
    width: 800
    height: 680
    property alias toolButton: toolButton
    title: 'Zamówienie dla stolika nr 1'

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

    StackLayout {
        id: orders
        width: 800
        height: 680
        currentIndex: tabBar.currentIndex
        anchors.fill: parent

        Item {
            id: add_to_order
            Layout.preferredHeight: 0
            Layout.preferredWidth: 0

            ListView {
                id: menu_list
                anchors {
                    fill: parent
                    margins: 2
                }

                Rectangle {
                    id: desserts
                    x: 285
                    y: 97
                    width: 227
                    height: 444
                    border.color: black
                    border.width: 1
                }

                Rectangle {
                    id: drinks
                    x: 543
                    y: 97
                    width: 227
                    height: 444
                    border.color: black
                    border.width: 1
                }

                Rectangle {
                    id: meals
                    x: 28
                    y: 97
                    width: 227
                    height: 444
                    border.color: black
                    border.width: 1
                }

                Button {
                    id: add_meal
                    x: 28
                    y: 556
                    width: 88
                    height: 55
                    text: qsTr("Dodaj ")
                    font.pointSize: 10
                }

                Text {
                    id: element
                    x: 31
                    y: 75
                    width: 71
                    height: 18
                    text: qsTr("Dania główne")
                    font.pixelSize: 13
                }

                Text {
                    id: element1
                    x: 291
                    y: 77
                    text: qsTr("Desery")
                    font.pixelSize: 13
                }

                Text {
                    id: element2
                    x: 546
                    y: 77
                    text: qsTr("Napoje")
                    font.pixelSize: 13
                }

                Button {
                    id: add_dessert
                    x: 285
                    y: 556
                    width: 88
                    height: 55
                    text: qsTr("Dodaj ")
                    font.pointSize: 10
                }

                Button {
                    id: add_drink
                    x: 543
                    y: 556
                    width: 88
                    height: 55
                    text: qsTr("Dodaj ")
                    font.pointSize: 10
                }

                Button {
                    id: remove_meal
                    x: 167
                    y: 556
                    width: 88
                    height: 55
                    text: qsTr("Usuń")
                    font.pointSize: 10
                }

                Button {
                    id: remove_dessert
                    x: 424
                    y: 556
                    width: 88
                    height: 55
                    text: qsTr("Usuń")
                    font.pointSize: 10
                }

                Button {
                    id: remove_drink
                    x: 682
                    y: 556
                    width: 88
                    height: 55
                    text: qsTr("Usuń")
                    font.pointSize: 10
                }
            }
        }

        Item {
            id: order_manage
            Layout.preferredHeight: 0
            Layout.preferredWidth: 0

            ListView {
                id: lsit
                x: 2
                y: 2
                anchors {
                    fill: parent
                    margins: 2
                }

                Rectangle {
                    id: order1
                    x: 37
                    y: 112
                    width: 505
                    height: 239
                    border.color: black
                    border.width: 1
                    color: white
                }

                Text {
                    id: element3
                    x: 37
                    y: 83
                    width: 77
                    height: 18
                    text: qsTr("Zamówienie")
                    font.pixelSize: 13
                }

                ComboBox {
                    id: select_discount
                    x: 37
                    y: 393
                    width: 707
                    height: 64
                    displayText: "Wybierz rabat"
                }

                Button {
                    id: generate_receipt
                    x: 89
                    y: 509
                    width: 132
                    height: 67
                    text: qsTr("Wystaw rachunek")
                    font.pointSize: 10
                }

                TextField {
                    id: pay_order5
                    x: 566
                    y: 212
                }

                Text {
                    id: element4
                    x: 566
                    y: 188
                    width: 77
                    height: 18
                    text: qsTr("Do zapłaty")
                    font.pixelSize: 13
                }

                Button {
                    id: generate_invoice
                    x: 550
                    y: 509
                    width: 132
                    height: 67
                    text: qsTr("Wystaw fakutrę")
                    font.pointSize: 10
                }
            }
        }
    }

    TabBar {
        id: tabBar
        width: 296
        height: 45
        currentIndex: 0

        TabButton {
            id: menu_items
            x: 0
            y: 0
            width: 150
            height: 52
            text: qsTr("Wybierz z Menu")
            font.pointSize: 9
        }

        TabButton {
            id: manage_orders
            x: 156
            y: 0
            width: 150
            height: 52
            text: qsTr("Finalizuj zamówienie")
            font.pointSize: 9
        }
    }
}
