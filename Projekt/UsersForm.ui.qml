import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

Page {
    id: userPage
    width: 800
    height: 680
    property alias toolButton: toolButton
    title: "Użytkownicy"

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
        anchors.fill: parent
        currentIndex: tabBar.currentIndex

        Item {
            id: createTab
            TextField {
                id: add_password
                x: 36
                y: 470
                width: 362
                height: 72
                placeholderText: "Hasło"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            TextField {
                id: add_login
                x: 36
                y: 344
                width: 362
                height: 72
                text: ""
                placeholderText: "Nazwa użytkownika"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            ComboBox {
                id: select_role
                x: 426
                y: 101
                width: 358
                height: 64
                displayText: "Wybierz role"
                textRole: ""
            }

            TextField {
                id: add_name
                x: 36
                y: 101
                width: 362
                height: 72
                clip: false
                placeholderText: "Imię"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            TextField {
                id: add_lastname
                x: 36
                y: 222
                width: 362
                height: 72
                placeholderText: "Nazwisko"

                selectByMouse: true
                MouseArea {
                    anchors.fill: parent
                    cursorShape: Qt.IBeamCursor
                    acceptedButtons: Qt.NoButton
                }
            }

            Button {
                id: add_user
                x: 479
                y: 331
                width: 253
                height: 111
                text: qsTr("Dodaj użytkownika")
                font.pointSize: 10
            }

            ColumnLayout {
            }
        }

        Item {
            id: delete_tab

            ComboBox {
                id: select_user
                x: 59
                y: 114
                width: 681
                height: 90
                displayText: "Wybierz użytkownika"
                textRole: ""
            }

            Button {
                id: delete_user
                x: 253
                y: 418
                width: 294
                height: 109
                text: qsTr("Usuń użytkownika")
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
            x: 0
            y: 0
            width: 150
            height: 52
            text: qsTr("Stwórz użytkownika")
            font.pointSize: 9
        }

        TabButton {
            x: 148
            y: 0
            width: 150
            height: 52
            text: qsTr("Usuń użytkownika")
            font.pointSize: 9
        }
    }
}
