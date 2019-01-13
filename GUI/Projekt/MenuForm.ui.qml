import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: menuPage
    width: 800
    height: 680
    property alias toolButton: toolButton
    title: 'Menu'

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
        id: menu
        width: 800
        height: 680
        currentIndex: tabBar.currentIndex
        anchors.fill: parent

        Item {
            id: menu_view
            Layout.preferredHeight: 0
            Layout.preferredWidth: 0

            ListView {
                id: menu_list
                anchors {
                    fill: parent
                    margins: 2
                }

                Rectangle {
                    id: meals
                    x: 285
                    y: 97
                    width: 227
                    height: 444
                    border.color: black
                    border.width: 1
                }

                Rectangle {
                    id: desserts
                    x: 543
                    y: 97
                    width: 227
                    height: 444
                    border.color: black
                    border.width: 1
                }

                Rectangle {
                    id: drinks
                    x: 28
                    y: 97
                    width: 227
                    height: 444
                    border.color: black
                    border.width: 1
                }

                Button {
                    id: remove
                    x: 74
                    y: 556
                    width: 130
                    height: 55
                    text: qsTr("Usuń")
                    font.pointSize: 10
                }

                Button {
                    id: remove1
                    x: 335
                    y: 556
                    width: 130
                    height: 55
                    text: qsTr("Usuń")
                    font.pointSize: 10
                }

                Button {
                    id: remove2
                    x: 602
                    y: 556
                    width: 130
                    height: 55
                    text: qsTr("Usuń")
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
            }
        }

        Item {
            id: menu_manage
            Layout.preferredHeight: 0
            Layout.preferredWidth: 0

            ComboBox {
                id: comboBox
                x: 55
                y: 101
                width: 691
                height: 62
                font.pointSize: 9
                displayText: "Wybierz kategorię"
            }

            TextField {
                id: name_of_dish
                x: 55
                y: 205
                width: 691
                height: 63
                placeholderText: "Wpisz nazwę"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            TextField {
                id: value_of_dish
                x: 55
                y: 297
                width: 691
                height: 63
                placeholderText: "Podaj cenę"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            CheckBox {
                id: checkBox
                x: 55
                y: 420
                width: 336
                height: 40
                text: qsTr("Czy obowiązują zniżki?")
                font.pointSize: 10
            }

            Button {
                id: button
                x: 292
                y: 489
                width: 216
                height: 93
                text: qsTr("Dodaj do menu")
                font.pointSize: 10
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
            text: qsTr("Przeglądaj menu")
            font.pointSize: 9
        }

        TabButton {
            id: manage_menu
            x: 156
            y: 0
            width: 150
            height: 52
            text: qsTr("Dodaj pozycję")
            font.pointSize: 9
        }
    }
}
